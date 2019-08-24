package com.bosssoft.bes.base.enums;

public enum SystemExceptionEnum {
    SYSTEM_ERROR(10000,"系统异常"),
    SYSTEM_BASE_COMMON_FIELD_USER_NOT_FOUND_ON_CACHE(10001,"缓存未找到用户信息"),
    SYSTEM_BASE_COMMON_FIELD_REQUEST_PARSE_ERROR(10002,"请求解析错误,未找到token"),
    SYSTEM_BASE_COMMON_FIELD_SET_ERROR(10003,"公共字段设值过程出错"),
    SYSTEM_BASE_COMMON_FIELD_USER_NOT_FOUND_ON_REQUEST(10004,"请求对象中未找到用户id"),
    SYSTEM_ARGS_ERROR(20000,"系统参数异常");

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    SystemExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
