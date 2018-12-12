package com.sundaysee.hrm.dao;

import java.util.List;
import java.util.Map;

import com.sundaysee.hrm.entity.Document;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.annotations.Select;

public interface DocumentDao {

    List<Document> selectByPage(Map<String,Object> params);

    Integer count(Map<String,Object> params);

    void save(Document document);

    @Select("select * from " + HrmConstants.DOCUMENTTABLE + " where id = #{id}")
    Document selectById(Integer id);

    @Select("delete from " + HrmConstants.DOCUMENTTABLE + " where id = #{id}")
    void deleteById(Integer id);

    void update(Document document);

}