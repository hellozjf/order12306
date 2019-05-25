package com.hellozjf.order12306.service;

import com.hellozjf.order12306.constants.UriEnum;

import java.net.URI;

/**
 * @author hellozjf
 */
public interface UriService {
    URI getUri(String scheme, String host, int port, String path, String query);
    URI getUri(UriEnum uriEnum, String params);
}
