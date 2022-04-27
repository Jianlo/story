package com.jian.entity;

import lombok.Data;
import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -2231665180549556764L;
    private int id;
    private String uid;
    private String username;
    private String password;
    private String photoUrl;
    private String email;

}
