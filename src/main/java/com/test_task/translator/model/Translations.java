package com.test_task.translator.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "translations")
public class Translations {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date callTime;
    private String inputParameters;
    private String ipClient;

    public Translations() {}

    public Translations(Date callTime, String inputParameters, String ipClient) {
        this.callTime = callTime;
        this.inputParameters = inputParameters;
        this.ipClient = ipClient;
    }

    public Long getId() {
        return id;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public String getInputParameters() {
        return inputParameters;
    }

    public void setInputParameters(String inputParameters) {
        this.inputParameters = inputParameters;
    }

    public String getIpClient() {
        return ipClient;
    }

    public void setIpClient(String ipClient) {
        this.ipClient = ipClient;
    }

    @Override
    public String toString() {
        return "Translations{" +
                "id=" + id +
                ", callTime=" + callTime +
                ", inputParameters='" + inputParameters + '\'' +
                ", ipClient='" + ipClient + '\'' +
                '}';
    }
}
