package com.ycw.im.imdistributedcom.vo.resp;

import com.ycw.im.imdistributedcom.enums.StatusEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author yuchunwei
 */

@Data
public class BaseResponse<T> implements Serializable {
    private int status;
    private String message;
    private String reqNo;
    private T dataBody;

    public BaseResponse(){

    }

    public BaseResponse(T dataBody, String message, int status) {
        this.dataBody = dataBody;
        this.message = message;
        this.status = status;
    }

    public BaseResponse(T dataBody, String message, int status, String reqNo) {
        this.dataBody = dataBody;
        this.message = message;
        this.status = status;
        this.reqNo = reqNo;
    }
    public static <T> BaseResponse<T> ok(T data, String message,int code) {
        return new BaseResponse<>(data, message, code);
    }

    public static <T> BaseResponse<T> ok(T data, String message) {
        return new BaseResponse<>(data, message, StatusEnum.SUCCESS.getCode());
    }
    public static <T> BaseResponse<T> error(T data,String message,int status){
        return new BaseResponse<>(data,message,status);
    }
}
