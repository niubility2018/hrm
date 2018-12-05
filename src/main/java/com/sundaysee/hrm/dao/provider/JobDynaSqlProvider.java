package com.sundaysee.hrm.dao.provider;

import java.util.Map;

import com.sundaysee.hrm.entity.Job;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.jdbc.SQL;

public class JobDynaSqlProvider {

    public String selectWithParam(Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(HrmConstants.JOBTABLE);
                if (params.get("job") != null) {
                    Job job =  (Job)params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE(" name LIKE CONCAT('%',#{job.name},'%')");
                    }
                }
            }
        }.toString();

        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam,#{pageModel.pageSize}}";
        }

        return sql;
    }

    public String count(Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("*");
                FROM(HrmConstants.JOBTABLE);
                if (params.get("job") != null) {
                    Job job =  (Job)params.get("job");
                    if (job.getName() != null && !job.getName().equals("")) {
                        WHERE(" name LIKE CONCAT('%',#{job.name},'%')");
                    }
                }
            }
        }.toString();
    }

    //动态插入
    public String insertJob(Job job) {
        return new SQL(){
            {
                INSERT_INTO(HrmConstants.JOBTABLE);
                if (job.getName() != null && !job.getName().equals("")) {
                    VALUES(" name", "#{name}");
                }
                if (job.getRemark() != null && !job.getRemark().equals("")) {
                    VALUES(" remark", "#{remark|");
                }

            }
        }.toString();
    }

    //动态更新
    public String updateJob(Job job) {
        return new SQL(){
            {
                UPDATE(HrmConstants.JOBTABLE);
                if (job.getName() != null && !job.getName().equals("")) {
                    SET(" name = #{name}");
                }
                if (job.getRemark() != null && !job.getRemark().equals("")) {
                    SET(" remark = #{remark}");
                }
            }

        }.toString();
    }
    
}