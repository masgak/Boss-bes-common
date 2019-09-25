package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

import java.io.Serializable;

/**
 * service异常
 *
 * @ClassName: ServiceException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class ServiceException extends GlobalException implements Serializable {
    /**
     * 基础数据服务异常
     *
     * @param besDataExceptionEnum
     */
    public ServiceException(BesDataExceptionEnum besDataExceptionEnum) {
        super(besDataExceptionEnum);
    }

    /**
     * 考试服务异常
     *
     * @param examExceptionEnum
     */
    public ServiceException(ExamExceptionEnum examExceptionEnum) {
        super(examExceptionEnum);
    }

    /**
     * 试卷服务异常
     *
     * @param paperExceptionEnum
     */
    public ServiceException(PaperExceptionEnum paperExceptionEnum) {
        super(paperExceptionEnum);
    }

    /**
     * 系统管理异常
     *
     * @param systemManageExceptionEnum
     */
    public ServiceException(SystemManageExceptionEnum systemManageExceptionEnum) {
        super(systemManageExceptionEnum);
    }

    /**
     * 认证服务异常
     *
     * @param authenticationExceptionEnum
     */
    public ServiceException(AuthenticationExceptionEnum authenticationExceptionEnum) {
        super(authenticationExceptionEnum);
    }

    /**
     * CDN服务异常
     *
     * @param cdnExceptionEnum
     */
    public ServiceException(CDNExceptionEnum cdnExceptionEnum) {
        super(cdnExceptionEnum);
    }

    /**
     * 网关服务异常
     *
     * @param gatewayExceptionEnum
     */
    public ServiceException(GatewayExceptionEnum gatewayExceptionEnum) {
        super(gatewayExceptionEnum);
    }

    /**
     * 日志服务异常
     *
     * @param logExceptionEnum
     */
    public ServiceException(LogExceptionEnum logExceptionEnum) {
        super(logExceptionEnum);
    }

    /**
     * 系统异常
     *
     * @param systemExceptionEnum
     */
    public ServiceException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum);
    }

    /**
     * 基础数据服务异常，带异常堆栈信息
     *
     * @param besDataExceptionEnum
     * @param cause
     */
    public ServiceException(BesDataExceptionEnum besDataExceptionEnum, Throwable cause) {
        super(besDataExceptionEnum, cause);
    }

    /**
     * 考试服务异常，带异常堆栈信息
     *
     * @param examExceptionEnum
     * @param cause
     */
    public ServiceException(ExamExceptionEnum examExceptionEnum, Throwable cause) {
        super(examExceptionEnum, cause);
    }

    /**
     * 试卷服务异常，带异常堆栈信息
     *
     * @param paperExceptionEnum
     * @param cause
     */
    public ServiceException(PaperExceptionEnum paperExceptionEnum, Throwable cause) {
        super(paperExceptionEnum, cause);
    }

    /**
     * 系统管理异常，带异常堆栈信息
     *
     * @param systemManageExceptionEnum
     * @param cause
     */
    public ServiceException(SystemManageExceptionEnum systemManageExceptionEnum, Throwable cause) {
        super(systemManageExceptionEnum, cause);
    }

    /**
     * 认证服务异常，带异常堆栈信息
     *
     * @param authenticationExceptionEnum
     * @param cause
     */
    public ServiceException(AuthenticationExceptionEnum authenticationExceptionEnum, Throwable cause) {
        super(authenticationExceptionEnum, cause);
    }

    /**
     * CDN服务异常，带异常堆栈信息
     *
     * @param cdnExceptionEnum
     * @param cause
     */
    public ServiceException(CDNExceptionEnum cdnExceptionEnum, Throwable cause) {
        super(cdnExceptionEnum, cause);
    }

    /**
     * 网关服务异常，带异常堆栈信息
     *
     * @param gatewayExceptionEnum
     * @param cause
     */
    public ServiceException(GatewayExceptionEnum gatewayExceptionEnum, Throwable cause) {
        super(gatewayExceptionEnum, cause);
    }

    /**
     * 日志服务异常，带异常堆栈信息
     *
     * @param logExceptionEnum
     * @param cause
     */
    public ServiceException(LogExceptionEnum logExceptionEnum, Throwable cause) {
        super(logExceptionEnum, cause);
    }

    /**
     * 系统异常，带异常堆栈信息
     *
     * @param systemExceptionEnum
     * @param cause
     */
    public ServiceException(SystemExceptionEnum systemExceptionEnum, Throwable cause) {
        super(systemExceptionEnum, cause);
    }

    /**
     * 手动抛异常，带异常堆栈信息
     *
     * @param code
     * @param message
     * @param cause
     */
    public ServiceException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }

    /**
     * 手动抛异常
     *
     * @param code
     * @param message
     */
    public ServiceException(Integer code, String message) {
        super(code, message);
    }

    /**
     * 统一异常
     *
     * @param e
     */
    public ServiceException(GlobalException e) {
        super(e);
    }
}
