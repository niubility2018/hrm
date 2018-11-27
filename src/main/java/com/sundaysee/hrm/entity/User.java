package com.sundaysee.hrm.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {
    private static final long serialVersionUID = -6649114017220111640L;
    private Integer id; // id
    private String username;    //用户名
    private String loginname;   //登录名
    private String password;    //登录密码
    private Integer status;     //状态
    private Date createDate;    //建档日期
}