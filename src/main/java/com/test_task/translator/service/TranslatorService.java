package com.test_task.translator.service;

import com.test_task.translator.dto.TranslatorRequest;
import com.test_task.translator.entity.ServiceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public interface TranslatorService {
    ResponseEntity<ServiceResponse> getTranslation(TranslatorRequest request) throws InterruptedException, ExecutionException, IOException;
}
