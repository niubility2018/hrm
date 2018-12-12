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
        super.doTag();
    }
    
}