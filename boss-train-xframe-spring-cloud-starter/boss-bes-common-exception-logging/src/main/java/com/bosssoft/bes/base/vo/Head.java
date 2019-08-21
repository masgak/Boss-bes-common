package com.bosssoft.bes.base.vo;

import java.io.Serializable;

/**
 * @ClassName: Head
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/12 9:54
 * @Version: 1.0.0
 */
public class Head implements Serializable {
    private String version;
    private String code;
    private String message;
    private Integer encryption;

    public Head() {
    }

    public Head(String version, String code, String message, Integer encryption) {
        this.version = version;
        this.code = code;
        this.message = message;
        this.encryption = encryption;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getEncryption() {
        return encryption;
    }

    public void setEncryption(Integer encryption) {
        this.encryption = encryption;
    }
}
