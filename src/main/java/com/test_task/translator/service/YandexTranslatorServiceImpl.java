package com.test_task.translator.service;

import com.test_task.translator.entity.TranslatorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class YandexTranslatorServiceImpl implements YandexTranslatorService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${key}")
    private String apiKey;

    @Value("${url}")
    private String apiUrl;

    @Override
    public ResponseEntity<TranslatorResponse> getTranslation(String text, String lang) {
        StringBuilder url = new StringBuilder(apiUrl);
        url.append("/translate").append("?key=").append(apiKey);
        url.append("&text=").append(text).append("&lang=").append(lang);

        ResponseEntity<TranslatorResponse> translation = restTemplate.getForEntity(url.toString(), TranslatorResponse.class);

        return translation;
    }
}
