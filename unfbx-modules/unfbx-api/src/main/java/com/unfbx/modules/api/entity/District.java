package com.unfbx.modules.api.entity;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
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
@TableName(value = "tb_district")
public class District extends BaseEntity implements Serializable {
  @TableId(value = "id", type = IdType.AUTO)
  private Integer id;

  /**
   * 高德查询的数据
   */
  @TableField(value = "data", typeHandler = FastjsonTypeHandler.class)
  private JSONObject data;

  /**
   * 获取数据的时间
   */
  @TableField(value = "date_node")
  private Date dateNode;

  private static final long serialVersionUID = 1L;
}