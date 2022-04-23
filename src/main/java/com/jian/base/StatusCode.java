package com.jian.base;

/**
 * 定义枚举类，返回给前端的状态码
 */
public enum StatusCode {

    SUCCESS(0, "Success"),
    ERROR(-1, "System error"),
    AUTHZ_ERR(10, "Authz err"),
    AUTHC_ERR(11, "Authc err"),
    ILLEGAL_REQ(19, "非法请求"),
    ILLEGAL_PARAM(20, "Illegal param"),
    UN_AUTHEN(30, "未经认证"),
    BUSINESS_ERR(40, "业务异常");

    private int code;
    private String msg;

    StatusCode(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    //根据状态码获得msg
    public static String getMsg(int code){
        StatusCode[] enums = StatusCode.values();
        for (StatusCode en:enums){
            if (en.getCode() == code){
                return en.getMsg();
            }
        }

        throw new IllegalArgumentException("Illegal code: " + code);
    }
}
