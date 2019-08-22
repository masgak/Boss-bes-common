package com.bosssoft.bes.base.enums;

public enum SystemExceptionEnum {
    SYSTEM_ERROR(10000,"系统异常"),
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
