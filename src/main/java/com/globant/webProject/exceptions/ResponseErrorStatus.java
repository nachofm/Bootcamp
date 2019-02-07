package com.globant.webProject.exceptions;

public class ResponseErrorStatus {

    private String code;

    private String message;

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {

        return code;
    }

    public String getMessage() {
        return message;
    }

    public ResponseErrorStatus(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

}