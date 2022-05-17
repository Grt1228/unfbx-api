package com.unfbx.common.core.domain;

import com.unfbx.common.core.enums.OrderByFlag;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PageRequest {
    @Min(value = 1,message = "分页参数异常")
    private Integer pageNum;
    @Max(value = 1000, message = "分页查询每页最多1000条数据")
    private Integer pageSize;

    private String orderBy;

    private int orderByFlag;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        if(StringUtils.isBlank(orderBy)){
            return "";
        }
        return orderBy + " " + OrderByFlag.getStr(orderByFlag);
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public int getOrderByFlag() {
        return orderByFlag;
    }

    public void setOrderByFlag(int orderByFlag) {
        this.orderByFlag = orderByFlag;
    }
}

