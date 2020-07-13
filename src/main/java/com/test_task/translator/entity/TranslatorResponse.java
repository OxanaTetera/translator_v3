package com.test_task.translator.entity;

import java.io.Serializable;
import java.util.List;

public class TranslatorResponse implements Serializable {
    private String code;
    private String lang;
    private List<String> text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TranslatorResponse{" +
                "code='" + code + '\'' +
                ", lang='" + lang + '\'' +
                ", text=" + text +
                '}';
    }
}
