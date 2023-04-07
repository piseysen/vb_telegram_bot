package com.vb.telegram.bot.dto.response;


import com.vb.telegram.bot.util.ResponseCode;

/**
 * Created by Pisey Sen
 */

public class ResponseMsg {

    public static ResponseCode responseSuccessful() {
        return new ResponseCode("0", "Successful");
    }

    public static ResponseCode responseError() {
        return new ResponseCode("01", "Error");
    }

    public static ResponseCode responseInternalServerError() {
        return new ResponseCode("500", "Internal Server Error");
    }

    public static ResponseCode responseBadRequestError() {
        return new ResponseCode("400", "Bad Request");
    }

}
