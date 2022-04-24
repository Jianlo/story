package com.jian.dto;

import lombok.Data;

@Data
public class SignUpDto {

    //用户名
    private String username;
    //密码
    private String password;
    //邮箱地址
    private String email;
}
