package com.hellozjf.order12306.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hellozjf
 */
@Getter
@AllArgsConstructor
public enum UriEnum {

    OTN_HTTPZF_GETJS(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/otn/HttpZF/GetJS",
            otnHttpzfGetjs()),
    OTN_HTTPZF_LOGDEVICE(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/otn/HttpZF/logdevice",
            otnHttpZFLogdevice()),
    OTN_RESOURCES_LOGIN_HTML(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/otn/resources/login.html",
            otnResourcesLoginHtml()),
    OTN_LOGIN_CONF(HttpMethod.POST, "https", "kyfw.12306.cn", -1,
            "/otn/login/conf",
            otnLoginConfMap()),
    OTN_INDEX12306_GETLOGINBANNER(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/otn/index12306/getLoginBanner",
            otnIndex12306GetloginbannerMap()),
    PASSPORT_WEB_AUTH_UAMTK_STATIC(HttpMethod.POST, "https", "kyfw.12306.cn", -1,
            "/passport/web/auth/uamtk-static",
            passportWebAuthUamtkStaticMap()),
    PASSPORT_CAPTCHA_CAPTCHA_IMAGE64(HttpMethod.GET, "https", "kyfw.12306.cn",-1,
            "/passport/captcha/captcha-image64",
            passportCaptchaCaptchaImage64Map()),
    GET_ANSWER(HttpMethod.POST, "http", "aliyun.hellozjf.com", 8080,
            "/result/base64",
            getAnswerMap()),
    PASSPORT_CAPTCHA_CAPTCHA_CHECK(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/passport/captcha/captcha-check",
            getPassportCaptchaCaptchaCheckMap()),
    PASSPORT_WEB_LOGIN(HttpMethod.POST, "https", "kyfw.12306.cn", -1,
            "/passport/web/login",
            getPassportWebLoginMap()),
    OTN_LOGIN_USER_LOGIN(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/otn/login/userLogin",
            getOtnLoginUserLoginMap()),
    OTN_PASSPORT(HttpMethod.GET, "https", "kyfw.12306.cn", -1,
            "/otn/passport",
            getOtnPassportMap()),
    PASSPORT_WEB_AUTH_UAMTK(HttpMethod.POST, "https", "kyfw.12306.cn", -1,
            "/passport/web/auth/uamtk",
            getPassportWebAuthUamtkMap()),
    OTN_UAMAUTHCLIENT(HttpMethod.POST, "https", "kyfw.12306.cn", -1,
            "/otn/uamauthclient",
            getOtnUamauthclientMap()),
    ;

    private static Map<Object, Object> otnResourcesLoginHtml() {
        Map<Object, Object> params = new HashMap<>();
        return params;
    }

    private static Map<Object, Object> otnHttpzfGetjs() {
        Map<Object, Object> params = new HashMap<>();
        return params;
    }

    private static Map<Object, Object> otnHttpZFLogdevice() {
        Map<Object, Object> params = new HashMap<>();
        return params;
    }

    private static Map<Object, Object> otnLoginConfMap() {
        Map<Object, Object> params = new HashMap<>();
        return params;
    }

    private static Map<Object, Object> otnIndex12306GetloginbannerMap() {
        Map<Object, Object> params = new HashMap<>();
        return params;
    }

    private static Map<Object, Object> passportWebAuthUamtkStaticMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("appid", "otn");
        return params;
    }

    private static Map<Object, Object> passportCaptchaCaptchaImage64Map() {
        Map<Object, Object> params = new HashMap<>();
        params.put("login_site", "E");
        params.put("module", "login");
        params.put("rand", "sjrand");
        params.put("callback", "jQuery191027188156577876876_1558182495381");
        params.put("_", "1558182495382");
        // 记得再put一个key为毫秒，value为null的东西
        return params;
    }

    private static Map<Object, Object> getAnswerMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("base64String", "");
        return params;
    }

    private static Map<Object, Object> getPassportCaptchaCaptchaCheckMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("callback", "jQuery191027188156577876876_1558182495381");
        params.put("answer", "");
        params.put("rand", "sjrand");
        params.put("login_site", "E");
        params.put("_", "1558182495383");
        return params;
    }

    private static Map<Object, Object> getPassportWebLoginMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("username", "");
        params.put("password", "");
        params.put("appid", "otn");
        params.put("answer", "");
        return params;
    }

    private static Map<Object, Object> getOtnLoginUserLoginMap() {
        Map<Object, Object> params = new HashMap<>();
        return params;
    }

    private static Map<Object, Object> getOtnPassportMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("redirect", "/otn/login/userLogin");
        return params;
    }

    private static Map<Object, Object> getPassportWebAuthUamtkMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("appid", "otn");
        return params;
    }

    private static Map<Object, Object> getOtnUamauthclientMap() {
        Map<Object, Object> params = new HashMap<>();
        params.put("tk", "c9g0-ECRWXRzrVzAM9mty3IEo020ratnKtn-76pLPh4ij1110");
        return params;
    }

    HttpMethod httpMethod;
    String scheme;
    String host;
    int port;
    String path;
    Map<Object, Object> params;

}
