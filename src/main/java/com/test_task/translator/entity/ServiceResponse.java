package com.test_task.translator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ServiceResponse {
    @JsonProperty("text")
    public String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ServiceResponse(String text) {
        this.text = text;
    }
}
