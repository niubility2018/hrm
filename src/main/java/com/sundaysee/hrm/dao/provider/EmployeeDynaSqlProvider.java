package com.sundaysee.hrm.dao.provider;

import java.util.Map;
import com.sundaysee.hrm.entity.Employee;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.jdbc.SQL;

public class EmployeeDynaSqlProvider {

    //分页动态查询
    public String selectWithParam(Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(HrmConstants.EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee)params.get(("employee"));
                    if (employee.getDept() != null && employee.getDept().getId() != null
                    && employee.getDept().getId() != 0) {
                        WHERE(" DEPT_ID = #{employee.dept.id}");
                    }
                    if (employee.getJob() != null && employee.getJob().getId() != null
                    && employee.getJob().getId() != 0) {
                        WHERE(" JOB_ID = #{employee.job.id}");
                    }
                    if (employee.getName() != null && !employee.getName().equals("")) {
                        WHERE(" name like concat('%',#{employee.name},'%')");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE("phone like concat('%',employee.phone,'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE("card_id like concat('%',employee.cardId,'%')");
                    }
                    if (employee.getSex() != null && employee.getSex() != 0) {
                        WHERE(" sex = #{employee.sex}");
                    }
                }
            }
        }.toString();

        if (params.get("pageModel") != null) {
            sql += "limit #{pageModel.firstLimitParam},#{pageModel.pageSize} ";
        }
        return sql;

    }

    //动态查询总量
    public String count(Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(HrmConstants.EMPLOYEETABLE);
                if (params.get("employee") != null) {
                    Employee employee = (Employee) params.get("params");
                    if (employee.getDept() != null  
                    && employee.getDept().getId() != null && employee.getDept().getId() != 0) {
                        WHERE(" dept_id = #{employee.dept.id}");
                    }
                    if (employee.getJob() != null 
                    && employee.getJob().getId() != null && employee.getJob().getId() != 0) {
                        WHERE(" job_id = #{employee.job.id}");
                    }
                    if (employee.getName() != null && !employee.getName().equals("")) {
                        WHERE(" name like concat('%',#{employee.name},'%')");
                    }
                    if (employee.getPhone() != null && !employee.getPhone().equals("")) {
                        WHERE("phone like concat('%',#{employee.phone},'%')");
                    }
                    if (employee.getCardId() != null && !employee.getCardId().equals("")) {
                        WHERE("card_id like concat('%',#{employee.cardId,'%'})");
                    }
                    if (employee.getSex() != null && employee.getSex() != 0) {
                        WHERE("sex = #{employee.sex}");
                    }
                }
            }
        }.toString();
    }

    //动态插入
    public String insertEmployee(Employee employee) {
        return new SQL(){
            {
                INSERT_INTO(HrmConstants.EMPLOYEETABLE);
                if (employee.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (employee.getCardId() != null) {
                    VALUES("card_id", "#{cardId}");
                }
                if (employee.getPostCode() != null) {
                    VALUES("post_code", "#{postCode}");
                }
                if (employee.getTel() != null) {
                    VALUES("tel", "#{tel}");
                }
                if (employee.getBirthday() != null) {
                    VALUES("birthday", "#{birthday}");
                }
                if (employee.getEducation() != null) {
                    VALUES("education", "#{education}");
                }
                if (employee.getSpeciality() != null) {
                    VALUES("speciality", "#{speciality}");
                }
                if (employee.getCreateDate() != null) {
                    VALUES("createDate", "#{createDate}");
                }
                if (employee.getDept() != null) {
                    VALUES("dept_id", "#{dept.id}");
                }
                if (employee.getJob() != null) {
                    VALUES("job_id", "#{job.id}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateEmployee(Employee employee) {
        return new SQL(){
            {
                UPDATE(HrmConstants.EMPLOYEETABLE);
                if (employee.getName() != null) {
                    SET(" name = ${name} ");
                }
                if (employee.getCardId() != null) {
                    SET(" card_id = #{cardId}");
                }
                if (employee.getAddress() != null) {
                    SET(" address = ${address} ");
                }
                if (employee.getPostCode() != null) {
                    SET(" post_code = #{postCode} ");
                }
                if (employee.getTel() != null) {
                    SET(" tel = #{tel} ");
                }
                if (employee.getPhone() != null) {
                    SET(" phone = #{phone} ");
                }
                if (employee.getQqNum() != null) {
                    SET(" qq_num = #{qqNum} ");
                }
                if (employee.getEmail() != null) {
                    SET(" email = #{email} ");
                }
                if (employee.getSex() != null) {
                    SET(" sex = #{sex} ");
                }
                if (employee.getParty() != null) {
                    SET(" party = #{party} ");
                }
                if (employee.getBirthday() != null) {
                    SET(" birthday = #{birthday} ");
                }
                if (employee.getRace() != null) {
                    SET(" race = #{race} ");
                }
                if (employee.getEducation() != null) {
                    SET( " education = #{education} ");
                }
                if (employee.getSpeciality() != null) {
                    SET(" speciality = #{speciality} ");
                }
                if (employee.getRemark() != null) {
                    SET(" remark = #{remark} ");
                }
                if (employee.getCreateDate() != null) {
                    SET(" create_Date #{createDate} ");
                }
                if (employee.getDept() != null) {
                    SET(" dept_id = #{dept.id} ");
                }
                if (employee.getJob() != null) {
                    SET(" job_id = #{job.id} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }





}