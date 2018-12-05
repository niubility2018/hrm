package com.sundaysee.hrm.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sundaysee.hrm.dao.provider.EmployeeDynaSqlProvider;
import com.sundaysee.hrm.entity.Employee;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;

public interface EmployeeDao {

    //根据参数查询员工总数
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    //根据参数动态查询员工
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "selectWithParam")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "card_id",property = "cardId"),
        @Result(column = "post_code",property = "postCode"),
        @Result(column = "qq_num",property = "qqNum"),
        @Result(column = "birthday",property = "birthday",javaType = Date.class),
        @Result(column = "create_date",property = "createDate",javaType = Date.class),
        @Result(column = "dept_id",property = "dept",
        one = @One(select = "com.sundaysee.hrm.dao.DeptDao.selectById",fetchType = FetchType.EAGER)),
        @Result(column = "job_id",property = "job",
        one = @One(select = "com.sundaysee.hrm.dao.JobDao.selectById",fetchType = FetchType.EAGER))
    })
    List<Employee> selectByPage(Map<String,Object> params);

    //动态插入员工
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "insertEmployee")
    void save(Employee employee);

    //根据id删除员工
    @Delete("delete from " + HrmConstants.EMPLOYEETABLE + " where id = #{id}")
    void deleteById(Integer id);

    //根据id查询员工
    @Select("select * from " + HrmConstants.EMPLOYEETABLE + " where id = #{id}")
    @Results({
        @Result(id = true,column = "id",property = "id"),
        @Result(column = "card_id",property = "cardId"),
        @Result(column = "post_code",property = "postCode"),
        @Result(column = "qq_num",property = "qqNum"),
        @Result(column = "birthday",property = "birthday",javaType = Date.class),
        @Result(column = "create_date",property = "createDate",javaType = Date.class),
        @Result(column = "dept_id",property = "dept",
        one = @One(select = "com.sundaysee.hrm.dao.DeptDao.selectById",fetchType = FetchType.EAGER)),
        @Result(column = "job_id",property = "job",
        one = @One(select = "com.sundaysee.hrm.dao.JobDao.selectById",fetchType = FetchType.EAGER))
    })
    Employee selectById(Integer id);

    //动态修改员工
    @SelectProvider(type = EmployeeDynaSqlProvider.class,method = "updateEmployee")
    void update(Employee employee);

}