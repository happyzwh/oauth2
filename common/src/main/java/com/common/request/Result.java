package com.common.request;

import com.common.constant.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements java.io.Serializable{

    private int code;

    private String msg;

    private T data;

    public static <T> Result success(T data){
        return Result.builder().code(Constants.SUCCESS).msg(Constants.SUCCESS_MSG).data(data).build();
    }

    public static <T> Result fail(T data){
        return Result.builder().code(Constants.FAIL).msg(Constants.FAIL_MSG).data(data).build();
    }

    public static <T> Result fail(String msg,T data){
        return Result.builder().code(Constants.FAIL).msg(msg).data(data).build();
    }

    public static <T> Result result(int code,String msg,T data){
        return Result.builder().code(code).msg(msg).data(data).build();
    }

}
