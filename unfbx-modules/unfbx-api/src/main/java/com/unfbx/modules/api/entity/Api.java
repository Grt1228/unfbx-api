package com.unfbx.modules.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.unfbx.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_api")
public class Api extends BaseEntity implements Serializable{
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * api名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * icon
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 排序
     */
    @TableField(value = "order_no")
    private Integer orderNo;

    /**
     * 调用方式
     */
    @TableField(value = "method_type")
    private String methodType;

    /**
     * 请求地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 请求类型
     */
    @TableField(value = "request_type")
    private String requestType;

    /**
     * 参数类型
     */
    @TableField(value = "params_type")
    private String paramsType;

    /**
     * 请求参数
     */
    @TableField(value = "params")
    private String params;

    /**
     * 返回值类型
     */
    @TableField(value = "response_type")
    private String responseType;

    /**
     * 成功返回实例
     */
    @TableField(value = "response_success")
    private String responseSuccess;

    /**
     * 失败返回实例
     */
    @TableField(value = "response_error")
    private String responseError;

    /**
     * 单个ip每分钟调用次数，-1不限制
     */
    @TableField(value = "min_frequency")
    private Integer minFrequency;

    /**
     * 单个ip每天调用次数   -1不限制
     */
    @TableField(value = "day_frequency")
    private Integer dayFrequency;

    /**
     * 是否免费 1免费，0收费
     */
    @TableField(value = "free")
    private Boolean free;

    /**
     * 是否需要登录 1不需要，0需要
     */
    @TableField(value = "login")
    private Boolean login;


    private static final long serialVersionUID = 1L;
}