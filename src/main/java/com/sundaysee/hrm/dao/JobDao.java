package com.sundaysee.hrm.dao;

import java.util.List;
import java.util.Map;

import com.sundaysee.hrm.dao.provider.JobDynaSqlProvider;
import com.sundaysee.hrm.entity.Job;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface JobDao {

    @Select("select * from " + HrmConstants.JOBTABLE + " where id = #{id}")
    Job selectById(int id);

    @Select("select * from " + HrmConstants.JOBTABLE)
    List<Job> selectAllJob();

    //动态查询
    @SelectProvider(type = JobDynaSqlProvider.class,method = "selectWithParam")
    List<Job> selectByPage(Map<String,Object> params);

    //统计数量
    Integer count(Map<String,Object> params);

    void deleteById(Integer id);

    //动态插入职位信息
    void save(Job job);

    //动态修改职位信息
    void update(Job job);

}