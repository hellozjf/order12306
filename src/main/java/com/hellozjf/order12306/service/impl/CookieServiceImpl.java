package com.hellozjf.order12306.service.impl;

import com.hellozjf.order12306.constants.UriEnum;
import com.hellozjf.order12306.service.CookieService;
import com.hellozjf.order12306.service.UriService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.CookieManager;
import java.net.HttpCookie;
import java.net.URI;
import java.net.http.HttpClient;
import java.util.List;

/**
 * @author hellozjf
 */
@Slf4j
@Service
public class CookieServiceImpl implements CookieService {

    @Autowired
    private UriService uriService;

    @Override
    public List<HttpCookie> getAll(HttpClient httpClient, UriEnum uriEnum) {
        URI uri = uriService.getUri(uriEnum, "");
        return getAll(httpClient, uri);
    }

    @Override
    public List<HttpCookie> getAll(HttpClient httpClient, URI uri) {
        CookieManager manager = (CookieManager) httpClient.cookieHandler().get();
        List<HttpCookie> httpCookieList = manager.getCookieStore().get(uri);
        return httpCookieList;
    }
}
