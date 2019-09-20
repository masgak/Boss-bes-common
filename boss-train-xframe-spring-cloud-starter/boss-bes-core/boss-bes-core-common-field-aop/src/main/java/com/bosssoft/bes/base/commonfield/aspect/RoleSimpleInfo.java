package com.bosssoft.bes.base.commonfield.aspect;

/**
 * 角色表简略信息
 */
public class RoleSimpleInfo {
    protected Long id;

    protected Long orgId;

    protected Long companyId;

    protected String roleName;

    @Override
    public String toString() {
        return "RoleSimpleInfo{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", companyId=" + companyId +
                ", roleName='" + roleName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
