package com.unfbx.auth.entity;

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

/**
    * 用户表
    */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "unfbx_user")
public class User extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;

    @TableField(value = "icon")
    private String icon;

    @TableField(value = "email")
    private String email;

    @TableField(value = "phone")
    private String phone;

    private static final long serialVersionUID = 1L;
}