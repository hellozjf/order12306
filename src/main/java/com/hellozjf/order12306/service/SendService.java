package com.hellozjf.order12306.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.hellozjf.order12306.constants.UriEnum;
import org.springframework.http.HttpMethod;

import java.net.URI;
import java.net.http.HttpClient;

/**
 * @author hellozjf
 */
public interface SendService {

    <T> T send(HttpClient httpClient, UriEnum uriEnum, String params, TypeReference clazz);

    String send(HttpClient httpClient, UriEnum uriEnum, String params);

    String send(HttpClient httpClient, URI uri, HttpMethod httpMethod, String params);
}
