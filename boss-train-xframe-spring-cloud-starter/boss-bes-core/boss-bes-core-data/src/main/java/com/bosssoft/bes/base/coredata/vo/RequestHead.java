package com.bosssoft.bes.base.coredata.vo;

/**
 * CommonRequest头部对象
 *
 * @author 李旭阳
 * @createdTime 2019/8/22 9:45
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/22 9:54
 *
 */
public class RequestHead {
    /**
     * 请求的服务版本
     */
    private String version;
    /**
     * 请求的业务类型
     */
    private String businessType;
    /**
     * 请求方设备id
     */
    private String deviceId;
    /**
     * 请求方设备类型
     */
    private Integer deviceType;
    /**
     * 加密标记
     */
    private Integer encryption;

    public RequestHead(){}

    public RequestHead(String version, String businessType, String deviceId, Integer deviceType, Integer encryption) {
        this.version = version;
        this.businessType = businessType;
        this.deviceId = deviceId;
        this.deviceType = deviceType;
        this.encryption = encryption;
    }

    @Override
    public String toString() {
        return "RequestHead{" +
                "version='" + version + '\'' +
                ", businessType='" + businessType + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType=" + deviceType +
                ", encryption=" + encryption +
                '}';
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Integer deviceType) {
        this.deviceType = deviceType;
    }

    public Integer getEncryption() {
        return encryption;
    }

    public void setEncryption(Integer encryption) {
        this.encryption = encryption;
    }

}
