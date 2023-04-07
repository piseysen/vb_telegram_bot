package com.vb.telegram.bot.dto.response;




import com.vb.telegram.bot.util.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Pisey Sen
 */

@Getter
@Setter
public class DataResponse<T> extends BaseDataResponse<T> {
    public DataResponse(ResponseCode responseCode, T data) {
        super(responseCode, data);
    }


}
