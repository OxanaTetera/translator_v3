package com.test_task.translator.service;

import com.test_task.translator.entity.ServiceResponse;
import com.test_task.translator.dto.TranslatorRequest;
import com.test_task.translator.entity.TranslatorResponse;
import com.test_task.translator.model.Translations;
import com.test_task.translator.repository.TranslatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Timestamp;
import java.util.*;

import static java.time.LocalDateTime.now;

@Service
public class TranslatorServiceImpl implements TranslatorService {

    @Autowired
    private YandexTranslatorServiceImpl yandexTranslatorServiceImpl;

    @Autowired
    private TranslatorRepository translatorRepository;

    @Override
    public ResponseEntity<ServiceResponse> getTranslation(TranslatorRequest request)
            throws IOException {
        List<String> worldsToTranslate = Arrays.asList(request.getText().split(" "));
        String respText = "";
        ResponseEntity<TranslatorResponse> response;

        for (String str : worldsToTranslate) {
            response = yandexTranslatorServiceImpl.getTranslation(str, request.getLang());
            respText = respText + response.getBody().getText();
            saveToDB(str, getClientIp());
        }

        readFromDB();

        return new ResponseEntity<>(new ServiceResponse(respText),
                    HttpStatus.OK);
    }

    // Для получения корректного ip клиента
    private String getClientIp() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("translate.yandex.net", 80));
        String ipClient = socket.getLocalAddress().toString();
        socket.close();
        return ipClient;
    }

    private void saveToDB(String str, String ip) {
        //Сохраняем параметры запроса в бд
        translatorRepository.save(new Translations(Timestamp.valueOf(now()), str, ip));
    }

    //Читаем из базы в консоль
    private void readFromDB() {
        for (Translations translation : translatorRepository.findAll()) {
            System.out.println(translation.toString());
        }
    }
}
