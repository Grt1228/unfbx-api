package com.unfbx.modules.api.entity;

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
@EqualsAndHashCode(callSuper=true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_api_log")
public class ApiLog extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * api主键id
     */
    @TableField(value = "api_id")
    private Integer apiId;

    /**
     * api名称
     */
    @TableField(value = "api_name")
    private String apiName;

    /**
     * ip
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * 返回code
     */
    @TableField(value = "resp_code")
    private String respCode;

    /**
     * 返回信息
     */
    @TableField(value = "resp_msg")
    private String respMsg;

    /**
     * 状态：1成功，0失败
     */
    @TableField(value = "success")
    private Boolean success;

    private static final long serialVersionUID = 1L;
}