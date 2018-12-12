package com.sundaysee.hrm.tag;

import com.sundaysee.hrm.utils.HrmConstants;

/**
 * 分页实体类
 */
public class PageModel {

    //分页总数
    private int recordCount;
    //当前页面
    private int pageIndex;
    //每页分多少条记录
    private int pageSize = HrmConstants.PAGE_DEFUALT_SIZE;
    //总页数
    private int totalSize;

    public int getRecordCount() {
        this.recordCount = this.recordCount <= 0 ? 0:this.recordCount;
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getPageIndex() {
        this.pageIndex = this.pageIndex <= 0 ? 1 : this.pageIndex;
        //判断当前页是否超过总页数，如果超过就默认最后一页为当前页
        this.pageIndex = this.pageIndex >= this.getTotalSize() ? this.getTotalSize() : this.pageIndex;
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        this.pageSize = this.pageSize <= HrmConstants.PAGE_DEFUALT_SIZE ? HrmConstants.PAGE_DEFUALT_SIZE : this.pageSize;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getTotalSize() {
        if(this.getRecordCount() <= 0) {
            totalSize = 0;
        } else {
            totalSize = (this.getRecordCount() - 1) / this.getPageSize() + 1;
        }
        return totalSize;
    }

    public int getFirstLimitParam() {
        return (this.getPageIndex() - 1) * this.getPageSize();
    }

    
}