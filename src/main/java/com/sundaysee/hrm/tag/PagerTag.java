package com.sundaysee.hrm.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;


import lombok.Setter;

public class PagerTag extends SimpleTagSupport {

    //定义请求url中的常量字符
    private static final String TAG = "{0}";
    //当前页码
    @Setter
    private int pageIndex;
    //每页显示数量
    @Setter
    private int pageSize;
    //总记录条数
    @Setter
    private int recordCount;
    //请求url，page.action?pageIndex={0}
    @Setter
    private String submitUrl;
    //样式
    @Setter
    private String style = "subrosus";
    //总页数
    @Setter
    private int totalPage = 0;

    //在页面引用自定义标签就会触发一个标签类
    @Override
    public void doTag() throws JspException, IOException {
        //定义拼接的结果
        StringBuilder res = new StringBuilder();
        //定义它拼接的中间结果
        StringBuilder str = new StringBuilder();
        //判断记录总数
        if (recordCount > 0) {
            totalPage = (this.recordCount - 1) / this.pageSize + 1;
            //判断上一页活下一页是否需要加a标签
            if (this.pageIndex == 1) { //首页
                str.append("<span class='disabled'>上一页</span>");
                //计算中间页码
                this.calcPage(str);
                //下一页需不需要a标签
                if (this.pageIndex == this.totalPage) {
                    //只有一页
                    str.append("<span class='disabled'>下一页</span>");
                } else {
                    String tempUrl = this.submitUrl.replace(TAG, String.valueOf(this.pageIndex + 1));
                    str.append("<a href='" + tempUrl + "'>下一页</a>'");
                }
                
            } else if (this.pageIndex == this.totalPage){ //尾页
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(this.pageIndex - 1));
                str.append("<a href='" + tempUrl + "'>上一页</a>'");
                //计算中间页
                this.calcPage(str);
                str.append("<span class='disabled'>下一页</span>");
            } else {
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(this.pageIndex - 1));
                str.append("<a href='" + tempUrl + "'>上一页</a>'");
                //计算中间页
                this.calcPage(str);
                tempUrl = this.submitUrl.replace(TAG, String.valueOf(this.pageIndex + 1));
                str.append("<a href='" + tempUrl + "'>下一页</a>'");
            }
            //拼接其他信息
            res.append("<table width='100%' align='center' style='font-size:13px;' class='" + style + "'>");
            res.append("<tr><td style='color:#0061de;margin-right=3px;padding-top:2px;text-decoration:none'>" + str.toString());
            res.append("&nbsp; 跳转到 &nbsp;&nbsp;<input style='text-align=center;border-right:#aaaadd 1px solid;padding-right:5px");
            res.append("border-top:#aaaadd 1px solid;padding-left:5px;padding-bottom:2px;margin:2px;border-left:#aaaadd 1px solid;");
            res.append("color:#000099;padding-top:2px;border-bottom:#aaaadd 1px solid;text-decoration:none;' type='text'");
            res.append("size='2' id='pager_jump_page_size'/>");
            res.append("&nbsp;<input type='button' style='text-align:center;border-right:#dedfde 1px solid;padding-right:6px;");
            res.append("padding-bottom:2px;border-left:#dedfde 1px solid;color:#0061de;margin-right:3px;padding-top:2px;");
            res.append("border-bottom:#dedfde 1px solid;text-decoration:none' value=' 确 定 ' id='pager_jump_btn'");
            res.append("</td></tr>");
            res.append("<tr align='center'><td style='font-size:13px;'><tr><td style='color:#0061de;margin-right:3px;'");
            res.append("padding-top:2px;text-decoration:none'>");
            //开始条数
            int startNum = (this.pageIndex - 1) * this.pageSize + 1;
            //结束条数
            int endNum = (this.pageIndex == this.totalPage) ? this.recordCount : this.pageIndex * this.pageSize;
            res.append("总共<font color='red'>" + this.recordCount + "</font>条记录，当前显示" + startNum + "-" + endNum + "条记录。");
            res.append("</td></tr>");
            res.append("</table>");
            res.append("<script type='text/javascript'>");
            res.append(" document.getElementById('pager_jump_btn').onclick = function(){");
            res.append(" var page_size = document.getElementById('pager_jump_page_size').value");
            res.append("  if(!/^[1-9]\\d*$/.test(page_size)|| page_size < 1 || page_size > " + this.totalPage + "){");
            res.append("  alert('请输入[1-" + this.totalPage + "]之间的页码!');");
            res.append("  } else {");
            res.append(" var submit_url = '" + this.submitUrl + "';");
            res.append("   window.location = submit_url.replace('" + TAG + "',page_size);");
            res.append("   }");
            res.append("}");
            res.append("</script>");

        } else {
            res.append("<table align='center' style='font-size:13px;'>")
            .append("tr")
            .append("<td style='color:#0061ee;margin-right:3px;padding-top:2px;text-decoration:none'>")
            .append("总共<font color='red'>0</font>条记录，当前显示0-0条记录")
            .append("</td>")
            .append("</tr>")
            .append("</table>");
        }

        this.getJspContext().getOut().print(res.toString());
    }

    //计算中间页码的方法
    private void calcPage(StringBuilder str) {
        //判断总页数
        if (this.totalPage <= 11) {
            //一次性显示全部
            for (int i = 1; i <= this.totalPage; i++) {
                if(this.pageIndex == i) {
                    //当前页码
                    str.append("<span class='current'>" + i + "</span>");
                } else {
                    String tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
                    str.append("<a href='" + tempUrl + "'>" + i + "</a>");
                }
            }
        } else {
            //靠近首页
            if (this.pageIndex <= 8) {
                for (int i = 1; i <= 10; i++) {
                    if(this.pageIndex == i) {
                        //当前页码
                        str.append("<span class='current'>" + i + "</span>");
                    } else {
                        String tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
                        str.append("<a href='" + tempUrl + "'>" + i + "</a>");
                    }
                }
                str.append("...");
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(this.totalPage));
                str.append("<a href='" + tempUrl + "'>" + this.totalPage + "</a>");
            } else if(this.pageIndex + 8 >= this.totalPage){//靠近尾页
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
                str.append("<a href='" + tempUrl + "'>1</a>");
                str.append("...");
                for (int i = this.totalPage - 10; i <= this.totalPage; i++) {
                    if(this.pageIndex == i) {
                        //当前页码
                        str.append("<span class='current'>" + i + "</span>");
                    } else {
                        tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
                        str.append("<a href='" + tempUrl + "'>" + i + "</a>");
                    }
                }

            } else { //在中间
                String tempUrl = this.submitUrl.replace(TAG, String.valueOf(1));
                str.append("<a href='" + tempUrl + "'>1</a>");
                str.append("...");
                for (int i = this.pageIndex - 4; i <= this.pageIndex + 4; i++) {
                    if(this.pageIndex == i) {
                        //当前页码
                        str.append("<span class='current'>" + i + "</span>");
                    } else {
                        tempUrl = this.submitUrl.replace(TAG, String.valueOf(i));
                        str.append("<a href='" + tempUrl + "'>" + i + "</a>");
                    }
                }
                str.append("...");
                tempUrl = this.submitUrl.replace(TAG, String.valueOf(this.totalPage));
                str.append("<a href='" + tempUrl + "'>" + this.totalPage + "</a>");
            }
        }
    }
    
}