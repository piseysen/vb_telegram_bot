package com.vb.telegram.bot.util;
/**
 * Created by Pisey Sen
 */

public class ResponseCode {
    private String code;
    private  String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseCode() {
    }
}
