package com.sundaysee.hrm.dao;

import java.util.List;
import java.util.Map;

import com.sundaysee.hrm.dao.provider.UserDynaSqlProvider;
import com.sundaysee.hrm.entity.User;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

public interface UserDao {

    //根据用户名喝密码查询员工
    @Select("select * from " + HrmConstants.USERTABLE + " where loginname = #{loginname} and password = #{password}")
    User selectByLoginnameAndPassword(@Param("loginname") String loginname,@Param("password") String password);

    //根据id查询用户
    @Select("select * from " + HrmConstants.USERTABLE + " where id = #{id}")
    User selectById(Integer id);

    //根据id删除用户
    @Delete("delete from " + HrmConstants.USERTABLE + " where id = #{id}")
    void deleteById(Integer id);
    
    //动态修改用户
    @SelectProvider(type = UserDynaSqlProvider.class,method = "updateUser")
    void update(User user);

    //动态查询用户
    @SelectProvider(type = UserDynaSqlProvider.class,method = "selectWithParam")
    List<User> selectByPage(Map<String,Object> params);

    //根据参数查询用户总数
    @SelectProvider(type = UserDynaSqlProvider.class,method = "count")
    Integer count(Map<String,Object> params);

    //动态插入
    @SelectProvider(type = UserDynaSqlProvider.class,method = "insertUser")
    void save(User user);

}