package com.sundaysee.hrm.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id; //编号
    private String title;   //标题
    private String content; //内容
    private Date createDate;    //发布日期
    private User user;      //发布人

}