package com.bosssoft.bes.base.enums;

/**
 * @ClassName: CDNExceptionEnum
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 13:55
 * @Version: 1.0.0
 */
public class CDNExceptionEnum {
    ;

    /**
     * 异常码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    CDNExceptionEnum(Integer code, String message) {
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
