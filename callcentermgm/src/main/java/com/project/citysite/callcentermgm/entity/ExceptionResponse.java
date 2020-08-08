package com.project.citysite.callcentermgm.entity;


import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class ExceptionResponse {

    private String timestamp;
    private String code;
    private String status;
    private String data;

    public ExceptionResponse(String timestamp, String code, String status, String data) {
        super();
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}

