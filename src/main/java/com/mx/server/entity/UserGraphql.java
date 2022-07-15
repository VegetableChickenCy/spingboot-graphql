package com.mx.server.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_graphql")
public class UserGraphql implements Serializable {
    @Id
    @Column(name = "id")
    private String id;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "description")
    private String description;
    @Column(name = "update_time")
    private String updateTime;
    @Column(name = "create_time")
    private String createTime;
    @Column(name = "save_time")
    private Timestamp saveTime;
}
