package com.unfbx.common.core.enums;

public enum OrderByFlag {
    ASC(1,"asc"),
    DESC(2,"desc"),
//    ASC_NULLS_LAST(3,"asc"),
//    ASC_NULLS_FIRST(4,"asc"),
//    DESC_NULLS_LAST(5,"desc"),
//    DESC_NULLS_FIRST(6,"desc"),
    ;

    private int code;
    private String value;
    OrderByFlag(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    public static String getStr(int code ){
        for (OrderByFlag value : OrderByFlag.values()) {
            if(code == value.code){
                return value.getValue();
            }
        }
        return OrderByFlag.DESC.getValue();
    }
}
