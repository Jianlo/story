package com.jian.base;

import lombok.Data;

import java.util.Optional;

@Data
public class ResultData<T> {
    private int code;
    private String msg;
    private T data;

    //默认使用StatusCode中定义的SUCCESS的code和msg
    public ResultData(){
        this.code = StatusCode.SUCCESS.getCode();
        this.msg = StatusCode.SUCCESS.getMsg();
    }

    public ResultData(T data){
        this();
        this.data = data;
    }

    //自定义code和msg
    public ResultData(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    //返回对象的data,若对象的data为空则返回传入的data参数值
    public T dataOrElse(T data){
        return Optional.ofNullable(this.data).orElse(data);
    }


    /**
     * 静态方法，直接用类名调用，不需要实例对象
     */
    public static <T> ResultData<T> of(){
        return new ResultData<>();
    }

    public static <T> ResultData<T> of(T data){
        return new ResultData<>(data);
    }

    public static <T> ResultData<T> of(int code,String msg){
        return new ResultData<>(code, msg);
    }
}
