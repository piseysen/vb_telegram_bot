package com.vb.telegram.bot.advice;

import com.vb.telegram.bot.dto.response.DataResponse;
import com.vb.telegram.bot.dto.response.ResponseMsg;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Pisey Sen
 */

@ControllerAdvice
public class Handler {

    @ExceptionHandler(Exception.class)
    public DataResponse<Object> handle(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        if (ex instanceof NullPointerException) {
            return new DataResponse<>(ResponseMsg.responseBadRequestError(), null);
        }

        return new DataResponse<>(ResponseMsg.responseInternalServerError(), null);
    }
}