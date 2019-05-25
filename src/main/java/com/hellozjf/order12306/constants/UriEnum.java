package com.hellozjf.order12306.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpMethod;

/**
 * @author hellozjf
 */
@Getter
@AllArgsConstructor
public enum UriEnum {

    OTN_LOGIN_CONF(HttpMethod.POST, "https", "kyfw.12306.cn", "/otn/login/conf"),
    OTN_INDEX12306_GETLOGINBANNER(HttpMethod.GET, "https", "kyfw.12306.cn", "/otn/index12306/getLoginBanner"),
    PASSPORT_WEB_AUTH_UAMTK_STATIC(HttpMethod.POST, "https", "kyfw.12306.cn", "/passport/web/auth/uamtk-static"),
    ;

    HttpMethod httpMethod;
    String scheme;
    String host;
    String path;

}
