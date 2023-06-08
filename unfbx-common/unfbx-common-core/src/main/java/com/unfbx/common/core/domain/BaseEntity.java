package com.unfbx.common.core.domain;

import java.util.Date;

public class BaseEntity {
    /**
     * 状态：1正常，0禁用
     */
    private Integer status;

    /**
     * 删除：1正常，0删除
     */
    private Integer deleted;

    private Date createTime;

    private Date modifyTime;

    private String createUser;

    private String modifyUser;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 状态：1正常，0禁用
     */
    public enum Status {
        NORMAL(1),
        DISABLED(0),
        ;
        private int code;

        Status(int code) {
            this.code = code;
        }

        public int code() {
            return code;
        }
    }

    /**
     * 删除：1正常，0删除
     */
    public enum Deleted {
        NORMAL(1),
        DELETED(0),
        ;
        private int code;

        Deleted(int code) {
            this.code = code;
        }

        public int code() {
            return code;
        }
    }
}
