package com.bosssoft.bes.base.commonfield.aspect;

/**
 * 用户基本信息类
 *
 * @author 李旭阳
 * @createdTime 2019/8/22 13:57
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime 2019/8/22 13:57
 *
 */
public class UserInfo {
    private Long userId;

    private Long orgId;

    private Long companyId;

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
}
