package com.gin.enums;

/**
 * Created by Jean .
 * 2018/8/3
 * 返回
 */
public enum ResultEnum {
    UNKOWN_ERROR(-1, "未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100, "你可能还在上小学"),
    MIDDLE_SCHOOL(101, "你可能在上初中"),
    ;

    /** 错误码 **/
    private Integer code;
    /** 错误信息 **/
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
