package com.sundaysee.hrm.dao;

import java.util.List;
import java.util.Map;

import com.sundaysee.hrm.dao.provider.NoticeDynaSqlProvider;
import com.sundaysee.hrm.entity.Notice;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

public interface NoticeDao {

    //动态查询
    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "selectWithParam")
    @Results({
        @Result(id = true,column = "id",property= "id"),
        @Result(column = "create_date",property="createDate",javaType = java.util.Date.class),
        @Result(column = "user_id",property = "id",
        one = @One(select="com.sundaysee.hrm.dao.UserDao.selectWithParam",fetchType = FetchType.EAGER))
    })
    List<Notice> selectByPages(Map<String,Object> params);

    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    @Select("select * from " + HrmConstants.NOTICETABLE + " where id = #{id}")
    Notice selectById(Integer id);

    @Select("delete from " + HrmConstants.NOTICETABLE + " where id = #{id}")
    void deleteById(Integer id);

    //动态插入
    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "insertNotice")
    void save(Notice notice);

    //动态更新公告
    @SelectProvider(type = NoticeDynaSqlProvider.class,method = "updateNotice")
    void update(Notice notice);


}