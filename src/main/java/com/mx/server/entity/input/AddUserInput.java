package com.mx.server.entity.input;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class AddUserInput {
    private String nickName;
    private String mail;
    private String password;
    private String description;
    private Timestamp saveTime;
}
