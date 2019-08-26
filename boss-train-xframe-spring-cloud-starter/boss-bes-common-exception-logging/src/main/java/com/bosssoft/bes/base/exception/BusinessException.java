package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

import java.io.Serializable;

/**
 * 业务异常
 * @ClassName: BusinessException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class BusinessException extends GlobalException implements Serializable {


    private static final long serialVersionUID = 7990151765604765170L;

    /**
     * 基础数据服务异常
     * @param besDataExceptionEnum
     */
    public BusinessException(BesDataExceptionEnum besDataExceptionEnum) {
        super(besDataExceptionEnum);
    }

    /**
     * 考试服务异常
     * @param examExceptionEnum
     */
    public BusinessException(ExamExceptionEnum examExceptionEnum) {
        super(examExceptionEnum);
    }

    /**
     * 试卷服务异常
     * @param paperExceptionEnum
     */
    public BusinessException(PaperExceptionEnum paperExceptionEnum) {
        super(paperExceptionEnum);
    }

    /**
     * 系统管理异常
     * @param systemManageExceptionEnum
     */
    public BusinessException(SystemManageExceptionEnum systemManageExceptionEnum) {
        super(systemManageExceptionEnum);
    }

    /**
     * 认证服务异常
     * @param authenticationExceptionEnum
     */
    public BusinessException(AuthenticationExceptionEnum authenticationExceptionEnum) {
        super(authenticationExceptionEnum);
    }

    /**
     * CDN服务异常
     * @param cdnExceptionEnum
     */
    public BusinessException(CDNExceptionEnum cdnExceptionEnum) {
        super(cdnExceptionEnum);
    }

    /**
     * 网关异常
     * @param gatewayExceptionEnum
     */
    public BusinessException(GatewayExceptionEnum gatewayExceptionEnum) {
        super(gatewayExceptionEnum);
    }

    /**
     * 日志异常
     * @param logExceptionEnum
     */
    public BusinessException(LogExceptionEnum logExceptionEnum) {
        super(logExceptionEnum);
    }

    /**
     * 系统异常
     * @param systemExceptionEnum
     */
    public BusinessException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum);
    }
}
