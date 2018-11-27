package com.sundaysee.hrm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id; //id
    private Dept dept;  //员工对应的部门
    private Job job;    //员工关联的职位对象
    private String name;    //名称
    private String cardId;  //身份证
    private String address; //地址
    private String postCode;    //邮政编码
    private String tel;     //电话
    private String phone;   //手机
    private String qqNum;   //qq号
    private String email;   //邮箱
    private Integer sex;    //性别
    private String party;   //政治面貌
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;  //生日
    private String race;    //民族
    private String education;   //学历
    private String speciality;  //专业
    private String hobby;       //爱好
    private String remark;      //备注
    private Date createDate;      //建档日期


}