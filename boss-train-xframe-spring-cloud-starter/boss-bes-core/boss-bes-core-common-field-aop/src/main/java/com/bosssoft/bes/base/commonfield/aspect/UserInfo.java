package com.bosssoft.bes.base.commonfield.aspect;

import java.io.Serializable;
import java.util.List;

/**
 *
 *
 * @author 李旭阳
 * @createdTime 2019/9/20 14:53
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/9/20 14:53
 *
 */
public class UserInfo implements Serializable {
    protected Long id;

    protected Long companyId;

    protected Long orgId;

    protected Boolean manager;

    protected Byte managerLevel;

    protected List<RoleSimpleInfo> roles;

    public UserInfo() {
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", orgId=" + orgId +
                ", manager=" + manager +
                ", managerLevel=" + managerLevel +
                ", roles=" + roles +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
}
