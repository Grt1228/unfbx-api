package com.unfbx.modules.ippool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.unfbx.common.core.domain.BaseEntity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_ip_origin")
public class IpOrigin extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ip代理池地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * 代理池网站名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 代理池网站名称
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 调用方法
     */
    @TableField(value = "method")
    private String method;

    private static final long serialVersionUID = 1L;
}