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
     * 1-高匿，2-普匿，3-不匿
     */
    @TableField(value = "anonymous")
    private Integer anonymous;

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

    /**
     * 1-高匿，2-普匿，3-不匿
     */
    public enum Anonymous {
        HIGH(1,"高匿"),
        ORDINARY(2,"普匿"),
        NOT(3,"不匿"),
        ;
        private int code;
        private String value;

        Anonymous(int code,String value) {
            this.code = code;
            this.value = value;
        }

        public int code() {
            return code;
        }

        public String value() {
            return value;
        }
    }
}