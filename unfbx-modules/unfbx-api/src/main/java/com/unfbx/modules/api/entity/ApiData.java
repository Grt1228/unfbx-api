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
@TableName(value = "tb_api_data")
public class ApiData extends BaseEntity implements Serializable {
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
     * 次数
     */
    @TableField(value = "num")
    private Integer num;

    /**
     * 数据日期
     */
    @TableField(value = "data_date")
    private Date dataDate;

    private static final long serialVersionUID = 1L;
}