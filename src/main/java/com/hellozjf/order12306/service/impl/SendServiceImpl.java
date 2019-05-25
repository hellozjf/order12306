package com.hellozjf.order12306.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hellozjf.order12306.constants.UriEnum;
import com.hellozjf.order12306.service.CookieService;
import com.hellozjf.order12306.service.SendService;
import com.hellozjf.order12306.service.UriService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author hellozjf
 */
@Service
@Slf4j
public class SendServiceImpl implements SendService {

    @Autowired
    private UriService uriService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public <T> T send(HttpClient httpClient, UriEnum uriEnum, String params, TypeReference typeReference) {
        String result = send(httpClient, uriEnum, params);
        try {
            return objectMapper.readValue(result, typeReference);
        } catch (IOException e) {
            log.error("e = {}", e);
            return null;
        }
    }

    @Override
    public String send(HttpClient httpClient, UriEnum uriEnum, String params) {
        URI uri = uriService.getUri(uriEnum, params);
        HttpMethod httpMethod = uriEnum.getHttpMethod();
        return send(httpClient, uri, httpMethod, params);
    }

    @Override
    public String send(HttpClient httpClient, URI uri, HttpMethod httpMethod, String params) {
        HttpRequest.Builder httpRequestBuilder = HttpRequest.newBuilder(uri);
        if (httpMethod.equals(HttpMethod.POST)) {
            httpRequestBuilder.POST(HttpRequest.BodyPublishers.ofString(params));
        }
        HttpRequest httpRequest = httpRequestBuilder.build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }
}
