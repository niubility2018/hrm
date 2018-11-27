package com.sundaysee.hrm.dao;

import java.util.List;
import java.util.Map;

import com.sundaysee.hrm.dao.provider.DeptDynaSqlProvider;
import com.sundaysee.hrm.entity.Dept;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface DeptDao {

    //动态查询
    @SelectProvider(type = DeptDynaSqlProvider.class,method = "selectWithParam")
    List<Dept> selectByPage(Map<String,Object> params);

    @SelectProvider(type = DeptDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    @Select("select * from " + HrmConstants.DEPTTABLE)
    List<Dept> selectAllDept();

    @Select("select * from " + HrmConstants.DEPTTABLE + " where id = #{id}")
    Dept selectById(int id);

    //根据id删除部门
    @Delete("delete from " + HrmConstants.DEPTTABLE + " where id = #{id}")
    void deleteById(int id);

    //动态插入部门
    @SelectProvider(type = DeptDynaSqlProvider.class,method = "insertDept")
    void save(Dept dept);

    //动态修改
    @SelectProvider(type = DeptDynaSqlProvider.class,method = "updateDept")
    void update(Dept dept);

}