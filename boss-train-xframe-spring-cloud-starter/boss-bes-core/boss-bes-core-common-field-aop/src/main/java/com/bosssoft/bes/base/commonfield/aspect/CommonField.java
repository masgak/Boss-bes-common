package com.bosssoft.bes.base.commonfield.aspect;

import java.sql.Timestamp;
import java.util.List;

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
     * 用户ID
     */
    private Long userId;
    /**
     * 组织机构id
     */
    private Long orgId;
    /**
     * 公司id
     */
    private Long companyId;

    private Boolean manager;

    private Byte managerLevel;

    private List<RoleSimpleInfo> roles;
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

    @Override
    public String toString() {
        return "CommonField{" +
                "userId=" + userId +
                ", orgId=" + orgId +
                ", companyId=" + companyId +
                ", manager=" + manager +
                ", managerLevel=" + managerLevel +
                ", roles=" + roles +
                ", createdBy=" + createdBy +
                ", createdTime=" + createdTime +
                ", updatedBy=" + updatedBy +
                ", updatedTime=" + updatedTime +
                '}';
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Boolean getManager() {
        return manager;
    }

    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public Byte getManagerLevel() {
        return managerLevel;
    }

    public void setManagerLevel(Byte managerLevel) {
        this.managerLevel = managerLevel;
    }

    public List<RoleSimpleInfo> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleSimpleInfo> roles) {
        this.roles = roles;
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
}
