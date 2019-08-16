package com.bosssoft.hr.train.aspect;

import java.sql.Timestamp;

/**
 * 封装所有需要设置的公共字段类
 *
 * @author 李旭阳
 * @createdTime 2019/8/15 13点38分
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/15 13点41分
 *
 */
public class CommonField {
    /**
     * 组织机构id
     */
    private Long orgId;
    /**
     * 公司id
     */
    private Long companyId;
    /**
     * 创建人id
     */
    private Long createdBy;
    /**
     * 创建时间
     */
    private Timestamp createdTime;
    /**
     * 最后修改人id
     */
    private Long updatedBy;
    /**
     * 最后修改时间
     */
    private Timestamp updatedTime;
    /**
     * 版本标识
     */
    private Long version;

    public CommonField(){}

    @Override
    public String toString() {
        return "CommonField{" +
                "orgId=" + orgId +
                ", companyId=" + companyId +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                ", version=" + version +
                '}';
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Timestamp createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Timestamp getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Timestamp updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
