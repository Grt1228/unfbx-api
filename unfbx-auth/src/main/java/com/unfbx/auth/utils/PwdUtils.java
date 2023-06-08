package com.unfbx.auth.utils;


import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import org.apache.commons.lang3.StringUtils;

public class PwdUtils {

    /**
     * md5 加密
     *
     * @param pwd
     * @return
     */
    public static String md5Asc(String pwd) {
        return md5Asc(pwd, null);
    }

    /**
     * md5 加密
     *
     * @param pwd
     * @param salt
     * @return
     */
    public static String md5Asc(String pwd, String salt) {
        if (StringUtils.isBlank(pwd)) return "";
        MD5 md5 = SecureUtil.md5();
        if (StringUtils.isNotBlank(salt)) {
            md5.setSalt(salt.getBytes());
            md5.setSaltPosition(2);
        }
        return md5.digestHex(pwd);
    }
}
