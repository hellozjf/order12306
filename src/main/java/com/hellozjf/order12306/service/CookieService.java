package com.hellozjf.order12306.service;

import com.hellozjf.order12306.constants.UriEnum;

import java.net.HttpCookie;
import java.net.URI;
import java.net.http.HttpClient;
import java.util.List;

/**
 * @author hellozjf
 */
public interface CookieService {
    List<HttpCookie> getAll(HttpClient httpClient, UriEnum uriEnum);
    List<HttpCookie> getAll(HttpClient httpClient, URI uri);
}
