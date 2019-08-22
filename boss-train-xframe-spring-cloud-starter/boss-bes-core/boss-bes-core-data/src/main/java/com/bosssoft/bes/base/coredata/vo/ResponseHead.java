package com.bosssoft.bes.base.coredata.vo;

import java.io.Serializable;

/**
 * CommonResponse头部对象
 *
 * @author 卢金山
 * @createdTime 2019/8/12 9:54
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/22 9:57
 *
 */
public class ResponseHead implements Serializable {
    /**
     * 作响应的服务版本
     */
    private String version;
    /**
     * 应答码
     */
    private String code;
    /**
     * 应答消息
     */
    private String message;
    /**
     * 加密标记
     */
    private Integer encryption;

    public ResponseHead() {
    }

    public ResponseHead(String version, String code, String message, Integer encryption) {
        this.version = version;
        this.code = code;
        this.message = message;
        this.encryption = encryption;
    }

    @Override
    public String toString() {
        return "ResponseHead{" +
                "version='" + version + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", encryption=" + encryption +
                '}';
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
