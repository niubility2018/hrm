package com.sundaysee.hrm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document implements Serializable {

    private static final long serialVersionUID = 6998874500676511439L;

    private Integer id; //编号
    private String title;   //标题
    private String fileName;    //文件名
    private MultipartFile file; //文件
    private String remark;  //描述
    private Date createDate;    //发布日期
    private User user;      //上传人


}