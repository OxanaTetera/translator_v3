package com.test_task.translator.service;

import com.test_task.translator.entity.TranslatorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface YandexTranslatorService {
    ResponseEntity<TranslatorResponse> getTranslation(String text, String lang);
}
