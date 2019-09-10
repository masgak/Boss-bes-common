package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

import java.io.Serializable;

/**
 * service异常
 * @ClassName: ServiceException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class ServiceException extends GlobalException implements Serializable {

    private static final long serialVersionUID = 3145609292357116034L;

    /**
     * 基础数据服务异常
     * @param besDataExceptionEnum
     */
    public ServiceException(BesDataExceptionEnum besDataExceptionEnum) {
        super(besDataExceptionEnum);
    }

    /**
     * 考试服务异常
     * @param examExceptionEnum
     */
    public ServiceException(ExamExceptionEnum examExceptionEnum) {
        super(examExceptionEnum);
    }

    /**
     * 试卷服务异常
     * @param paperExceptionEnum
     */
    public ServiceException(PaperExceptionEnum paperExceptionEnum) {
        super(paperExceptionEnum);
    }

    /**
     * 系统管理异常
     * @param systemManageExceptionEnum
     */
    public ServiceException(SystemManageExceptionEnum systemManageExceptionEnum) {
        super(systemManageExceptionEnum);
    }

    /**
     * 认证服务异常
     * @param authenticationExceptionEnum
     */
    public ServiceException(AuthenticationExceptionEnum authenticationExceptionEnum) {
        super(authenticationExceptionEnum);
    }

    /**
     * CDN服务异常
     * @param cdnExceptionEnum
     */
    public ServiceException(CDNExceptionEnum cdnExceptionEnum) {
        super(cdnExceptionEnum);
    }

    /**
     * 网关异常
     * @param gatewayExceptionEnum
     */
    public ServiceException(GatewayExceptionEnum gatewayExceptionEnum) {
        super(gatewayExceptionEnum);
    }

    /**
     * 日志异常
     * @param logExceptionEnum
     */
    public ServiceException(LogExceptionEnum logExceptionEnum) {
        super(logExceptionEnum);
    }

    /**
     * 系统异常
     * @param systemExceptionEnum
     */
    public ServiceException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum);
    }

    /**
     * 用于ServiceException传递DaoException
     * @param daoException
     */
    public ServiceException(DaoException daoException){
        super(daoException);
    }
}
