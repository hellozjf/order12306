package com.hellozjf.order12306.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

/**
 * from corejava11 v2ch4 HttpClientTest.java
 *
 * @author hellozjf
 */
public class MoreBodyPublisherUtils {

    public static String getStringFromFormData(Map<Object, Object> data) {
        var first = true;
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (first) {
                first = false;
            } else {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(),
                    StandardCharsets.UTF_8));
            if (entry.getValue() != null) {
                builder.append("=");
                builder.append(URLEncoder.encode(entry.getValue().toString(),
                        StandardCharsets.UTF_8));
            }
        }
        return builder.toString();
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        return HttpRequest.BodyPublishers.ofString(getStringFromFormData(data));
    }

    private static byte[] bytes(String s) {
        return s.getBytes(StandardCharsets.UTF_8);
    }

    public static HttpRequest.BodyPublisher ofMimeMultipartData(Map<Object, Object> data, String boundary)
            throws IOException {
        var byteArrays = new ArrayList<byte[]>();
        byte[] separator = bytes("--" + boundary + "\nContent-Disposition: form-data; name=");
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            byteArrays.add(separator);

            if (entry.getValue() instanceof Path) {
                var path = (Path) entry.getValue();
                String mimeType = Files.probeContentType(path);
                byteArrays.add(bytes("\"" + entry.getKey() + "\"; filename=\"" + path.getFileName()
                        + "\"\nContent-Type: " + mimeType + "\n\n"));
                byteArrays.add(Files.readAllBytes(path));
            } else {
                byteArrays.add(bytes("\"" + entry.getKey() + "\"\n\n" + entry.getValue() + "\n"));
            }
        }
        byteArrays.add(bytes("--" + boundary + "--"));
        return HttpRequest.BodyPublishers.ofByteArrays(byteArrays);
    }

    public static HttpRequest.BodyPublisher ofSimpleJSON(Map<Object, Object> data) {
        var builder = new StringBuilder();
        builder.append("{");
        var first = true;
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (first) {
                first = false;
            } else {
                builder.append(",");
            }
            builder.append(jsonEscape(entry.getKey().toString())).append(": ")
                    .append(jsonEscape(entry.getValue().toString()));
        }
        builder.append("}");
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

    private static Map<Character, String> replacements = Map.of('\b', "\\b", '\f', "\\f",
            '\n', "\\n", '\r', "\\r", '\t', "\\t", '"', "\\\"", '\\', "\\\\");

    private static StringBuilder jsonEscape(String str) {
        var result = new StringBuilder("\"");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String replacement = replacements.get(ch);
            if (replacement == null) {
                result.append(ch);
            } else {
                result.append(replacement);
            }
        }
        result.append("\"");
        return result;
    }
}
