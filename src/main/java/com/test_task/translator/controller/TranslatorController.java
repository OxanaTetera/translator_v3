package com.test_task.translator.controller;

import com.test_task.translator.entity.ServiceResponse;
import com.test_task.translator.dto.TranslatorRequest;
import com.test_task.translator.service.TranslatorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
public class TranslatorController {
    @Autowired
    TranslatorServiceImpl translatorServiceImpl;

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/translate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServiceResponse> getTranslation(@RequestBody TranslatorRequest request)
            throws IOException {
        return translatorServiceImpl.getTranslation(request);
    }
}
