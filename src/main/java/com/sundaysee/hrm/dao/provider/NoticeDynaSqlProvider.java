package com.sundaysee.hrm.dao.provider;

import java.util.Map;

import com.sundaysee.hrm.entity.Notice;
import com.sundaysee.hrm.utils.HrmConstants;

import org.apache.ibatis.jdbc.SQL;

public class NoticeDynaSqlProvider {

    public String selectWithParam(Map<String,Object> params) {
        String sql = new SQL(){
            {
                SELECT("*");
                FROM(HrmConstants.NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice) params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE(" title like concat('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE(" content like concat('%',#{notice.content},'%')");
                    }
                }
            }
        }.toString();
        if (params.get("pageModel") != null) {
            sql += " limit #{pageModel.firstLimitParam},#{pageModel.pageSize}";
        }

        return sql;
    }

    public String count(Map<String,Object> params) {
        return new SQL(){
            {
                SELECT("count(*)");
                FROM(HrmConstants.NOTICETABLE);
                if (params.get("notice") != null) {
                    Notice notice = (Notice)params.get("notice");
                    if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                        WHERE(" title like concat('%',#{notice.title},'%')");
                    }
                    if (notice.getContent() != null && !notice.getContent().equals("")) {
                        WHERE(" content like concat('%',#{notice.content},'%')");
                    }
                }
            }
        }.toString();
    }

    //动态插入
    public String insertNotice(Notice notice) {
        return new SQL(){
            {
                INSERT_INTO(HrmConstants.NOTICETABLE);
                if (notice.getTitle() != null) {
                    VALUES("title", "#{title}");
                }
                if (notice.getContent() != null) {
                    VALUES("content", "#{content}");
                }
                if (notice.getUser() != null && notice.getUser().getId() != null) {
                    VALUES("user_id", "#{user.id}");
                }
            }
        }.toString();
    }

    //动态更新
    public String updateNotice(Notice notice) {
        return new SQL(){
            {
                UPDATE(HrmConstants.NOTICETABLE);
                if (notice.getTitle() != null && !notice.getTitle().equals("")) {
                    SET(" title = #{title}");
                }
                if (notice.getContent() != null && !notice.getContent().equals("")) {
                    SET(" content = #{content}");
                }
                if (notice.getUser() != null && notice.getUser().getId() != null) {
                    SET(" user_id = #{user.id}");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

}