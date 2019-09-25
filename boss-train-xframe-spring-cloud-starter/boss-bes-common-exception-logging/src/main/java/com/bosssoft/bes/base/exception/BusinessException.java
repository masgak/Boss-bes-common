package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

import java.io.Serializable;

/**
 * 业务异常
 *
 * @ClassName: BusinessException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class BusinessException extends GlobalException implements Serializable {
    /**
     * 基础数据服务异常
     *
     * @param besDataExceptionEnum
     */
    public BusinessException(BesDataExceptionEnum besDataExceptionEnum) {
        super(besDataExceptionEnum);
    }

    /**
     * 考试服务异常
     *
     * @param examExceptionEnum
     */
    public BusinessException(ExamExceptionEnum examExceptionEnum) {
        super(examExceptionEnum);
    }

    /**
     * 试卷服务异常
     *
     * @param paperExceptionEnum
     */
    public BusinessException(PaperExceptionEnum paperExceptionEnum) {
        super(paperExceptionEnum);
    }

    /**
     * 系统管理异常
     *
     * @param systemManageExceptionEnum
     */
    public BusinessException(SystemManageExceptionEnum systemManageExceptionEnum) {
        super(systemManageExceptionEnum);
    }

    /**
     * 认证服务异常
     *
     * @param authenticationExceptionEnum
     */
    public BusinessException(AuthenticationExceptionEnum authenticationExceptionEnum) {
        super(authenticationExceptionEnum);
    }

    /**
     * CDN服务异常
     *
     * @param cdnExceptionEnum
     */
    public BusinessException(CDNExceptionEnum cdnExceptionEnum) {
        super(cdnExceptionEnum);
    }

    /**
     * 网关服务异常
     *
     * @param gatewayExceptionEnum
     */
    public BusinessException(GatewayExceptionEnum gatewayExceptionEnum) {
        super(gatewayExceptionEnum);
    }

    /**
     * 日志服务异常
     *
     * @param logExceptionEnum
     */
    public BusinessException(LogExceptionEnum logExceptionEnum) {
        super(logExceptionEnum);
    }

    /**
     * 系统异常
     *
     * @param systemExceptionEnum
     */
    public BusinessException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum);
    }

    /**
     * 基础数据服务异常，带异常堆栈信息
     *
     * @param besDataExceptionEnum
     * @param cause
     */
    public BusinessException(BesDataExceptionEnum besDataExceptionEnum, Throwable cause) {
        super(besDataExceptionEnum, cause);
    }

    /**
     * 考试服务异常，带异常堆栈信息
     *
     * @param examExceptionEnum
     * @param cause
     */
    public BusinessException(ExamExceptionEnum examExceptionEnum, Throwable cause) {
        super(examExceptionEnum, cause);
    }

    /**
     * 试卷服务异常，带异常堆栈信息
     *
     * @param paperExceptionEnum
     * @param cause
     */
    public BusinessException(PaperExceptionEnum paperExceptionEnum, Throwable cause) {
        super(paperExceptionEnum, cause);
    }

    /**
     * 系统管理异常，带异常堆栈信息
     *
     * @param systemManageExceptionEnum
     * @param cause
     */
    public BusinessException(SystemManageExceptionEnum systemManageExceptionEnum, Throwable cause) {
        super(systemManageExceptionEnum, cause);
    }

    /**
     * 认证服务异常，带异常堆栈信息
     *
     * @param authenticationExceptionEnum
     * @param cause
     */
    public BusinessException(AuthenticationExceptionEnum authenticationExceptionEnum, Throwable cause) {
        super(authenticationExceptionEnum, cause);
    }

    /**
     * CDN服务异常，带异常堆栈信息
     *
     * @param cdnExceptionEnum
     * @param cause
     */
    public BusinessException(CDNExceptionEnum cdnExceptionEnum, Throwable cause) {
        super(cdnExceptionEnum, cause);
    }

    /**
     * 网关服务异常，带异常堆栈信息
     *
     * @param gatewayExceptionEnum
     * @param cause
     */
    public BusinessException(GatewayExceptionEnum gatewayExceptionEnum, Throwable cause) {
        super(gatewayExceptionEnum, cause);
    }

    /**
     * 日志服务异常，带异常堆栈信息
     *
     * @param logExceptionEnum
     * @param cause
     */
    public BusinessException(LogExceptionEnum logExceptionEnum, Throwable cause) {
        super(logExceptionEnum, cause);
    }

    /**
     * 系统异常，带异常堆栈信息
     *
     * @param systemExceptionEnum
     * @param cause
     */
    public BusinessException(SystemExceptionEnum systemExceptionEnum, Throwable cause) {
        super(systemExceptionEnum, cause);
    }

    /**
     * 手动抛异常，带异常堆栈信息
     *
     * @param code
     * @param message
     * @param cause
     */
    public BusinessException(Integer code, String message, Throwable cause) {
        super(code, message, cause);
    }

    /**
     * 手动抛异常
     *
     * @param code
     * @param message
     */
    public BusinessException(Integer code, String message) {
        super(code, message);
    }

    /**
     * 统一异常
     *
     * @param e
     */
    public BusinessException(GlobalException e) {
        super(e);
    }
}
