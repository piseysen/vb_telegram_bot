package com.vb.telegram.bot.dto.response;


import com.vb.telegram.bot.util.ResponseCode;

/**
 * Created by Pisey Sen
 */

public abstract class BaseDataResponse<T> {
    private String code;
    private String message;
    private T data;

    public BaseDataResponse(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
