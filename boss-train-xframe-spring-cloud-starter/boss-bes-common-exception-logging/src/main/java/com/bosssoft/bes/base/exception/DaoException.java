package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

import java.io.Serializable;

/**
 * Dao异常
 * @ClassName: DaoException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class DaoException extends GlobalException implements Serializable {

    private static final long serialVersionUID = 3226291936213114105L;

    /**
     * 基础数据服务异常
     * @param besDataExceptionEnum
     */
    public DaoException(BesDataExceptionEnum besDataExceptionEnum) {
        super(besDataExceptionEnum);
    }

    /**
     * 考试服务异常
     * @param examExceptionEnum
     */
    public DaoException(ExamExceptionEnum examExceptionEnum) {
        super(examExceptionEnum);
    }

    /**
     * 试卷服务异常
     * @param paperExceptionEnum
     */
    public DaoException(PaperExceptionEnum paperExceptionEnum) {
        super(paperExceptionEnum);
    }

    /**
     * 系统管理异常
     * @param systemManageExceptionEnum
     */
    public DaoException(SystemManageExceptionEnum systemManageExceptionEnum) {
        super(systemManageExceptionEnum);
    }

    /**
     * 认证服务异常
     * @param authenticationExceptionEnum
     */
    public DaoException(AuthenticationExceptionEnum authenticationExceptionEnum) {
        super(authenticationExceptionEnum);
    }

    /**
     * CDN服务异常
     * @param cdnExceptionEnum
     */
    public DaoException(CDNExceptionEnum cdnExceptionEnum) {
        super(cdnExceptionEnum);
    }

    /**
     * 网关异常
     * @param gatewayExceptionEnum
     */
    public DaoException(GatewayExceptionEnum gatewayExceptionEnum) {
        super(gatewayExceptionEnum);
    }

    /**
     * 日志异常
     * @param logExceptionEnum
     */
    public DaoException(LogExceptionEnum logExceptionEnum) {
        super(logExceptionEnum);
    }

    /**
     * 系统异常
     * @param systemExceptionEnum
     */
    public DaoException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum);
    }
}
