package com.sundaysee.hrm.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dept implements Serializable {

    private static final long serialVersionUID = 1605563473261454976L;
    private Integer id;     //id
    private String name;    //部门名称
    private String remark;  //详细描述

}