package com.unfbx.modules.ippool.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.unfbx.common.core.domain.BaseEntity;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_proxy_host")
public class ProxyHost extends BaseEntity implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * ip
     */
    @TableField(value = "ip")
    private String ip;

    /**
     * 端口
     */
    @TableField(value = "port")
    private String port;

    /**
     * 代理类型:http,https
     */
    @TableField(value = "type")
    private String type;

    /**
     * 地区
     */
    @TableField(value = "area")
    private String area;
    /**
     * 获取时间
     */
    @TableField(value = "verify_time")
    private LocalDateTime verifyTime;

    private static final long serialVersionUID = 1L;

    public enum Type {
        HTTP("http"),
        HTTPS("https"),
        ;
        private String code;

        Type(String code) {
            this.code = code;
        }

        public String code() {
            return code;
        }
    }
}