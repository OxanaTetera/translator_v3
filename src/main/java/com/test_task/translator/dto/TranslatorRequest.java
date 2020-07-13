package com.test_task.translator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class TranslatorRequest implements Serializable {
    @JsonProperty("text")
    private String text;
    @JsonProperty("lang")
    private String lang;

    public TranslatorRequest(String text, String from, String to) {
        this.text = text;
        this.lang = from + "-" + to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public String toString() {
        return "{" +
                "text='" + text + '\'' +
                ", lang='" + lang + '\'' +
                '}';
    }
}
