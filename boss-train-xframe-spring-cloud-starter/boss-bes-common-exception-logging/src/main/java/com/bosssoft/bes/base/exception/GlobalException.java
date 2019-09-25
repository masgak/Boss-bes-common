package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

/**
 * 统一异常基类
 *
 * @ClassName: GlobalException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/10 23:28
 * @Version: 1.0.0
 */
public class GlobalException extends RuntimeException {


    private static final long serialVersionUID = -6025952423835016528L;
    /**
     * 异常码
     */
    private Integer code;

    /**
     * 基础数据服务异常
     *
     * @param besDataExceptionEnum
     */
    public GlobalException(BesDataExceptionEnum besDataExceptionEnum) {
        super(besDataExceptionEnum.getMessage());
        this.code = besDataExceptionEnum.getCode();
    }

    /**
     * 考试服务异常
     *
     * @param examExceptionEnum
     */
    public GlobalException(ExamExceptionEnum examExceptionEnum) {
        super(examExceptionEnum.getMessage());
        this.code = examExceptionEnum.getCode();
    }

    /**
     * 试卷服务异常
     *
     * @param paperExceptionEnum
     */
    public GlobalException(PaperExceptionEnum paperExceptionEnum) {
        super(paperExceptionEnum.getMessage());
        this.code = paperExceptionEnum.getCode();
    }

    /**
     * 系统管理异常
     *
     * @param systemManageExceptionEnum
     */
    public GlobalException(SystemManageExceptionEnum systemManageExceptionEnum) {
        super(systemManageExceptionEnum.getMessage());
        this.code = systemManageExceptionEnum.getCode();
    }

    /**
     * 认证服务异常
     *
     * @param authenticationExceptionEnum
     */
    public GlobalException(AuthenticationExceptionEnum authenticationExceptionEnum) {
        super(authenticationExceptionEnum.getMessage());
        this.code = authenticationExceptionEnum.getCode();
    }

    /**
     * CDN服务异常
     *
     * @param cdnExceptionEnum
     */
    public GlobalException(CDNExceptionEnum cdnExceptionEnum) {
        super(cdnExceptionEnum.getMessage());
        this.code = cdnExceptionEnum.getCode();
    }

    /**
     * 网关服务异常
     *
     * @param gatewayExceptionEnum
     */
    public GlobalException(GatewayExceptionEnum gatewayExceptionEnum) {
        super(gatewayExceptionEnum.getMessage());
        this.code = gatewayExceptionEnum.getCode();
    }

    /**
     * 日志服务异常
     *
     * @param logExceptionEnum
     */
    public GlobalException(LogExceptionEnum logExceptionEnum) {
        super(logExceptionEnum.getMessage());
        this.code = logExceptionEnum.getCode();
    }

    /**
     * 系统异常
     *
     * @param systemExceptionEnum
     */
    public GlobalException(SystemExceptionEnum systemExceptionEnum) {
        super(systemExceptionEnum.getMessage());
        this.code = systemExceptionEnum.getCode();
    }

    /**
     * 基础数据服务异常，带异常堆栈信息
     *
     * @param besDataExceptionEnum
     * @param cause
     */
    public GlobalException(BesDataExceptionEnum besDataExceptionEnum, Throwable cause) {
        super(besDataExceptionEnum.getMessage(), cause);
        this.code = besDataExceptionEnum.getCode();
    }

    /**
     * 考试服务异常，带异常堆栈信息
     *
     * @param examExceptionEnum
     * @param cause
     */
    public GlobalException(ExamExceptionEnum examExceptionEnum, Throwable cause) {
        super(examExceptionEnum.getMessage(), cause);
        this.code = examExceptionEnum.getCode();
    }

    /**
     * 试卷服务异常，带异常堆栈信息
     *
     * @param paperExceptionEnum
     * @param cause
     */
    public GlobalException(PaperExceptionEnum paperExceptionEnum, Throwable cause) {
        super(paperExceptionEnum.getMessage(), cause);
        this.code = paperExceptionEnum.getCode();
    }

    /**
     * 系统管理异常，带异常堆栈信息
     *
     * @param systemManageExceptionEnum
     * @param cause
     */
    public GlobalException(SystemManageExceptionEnum systemManageExceptionEnum, Throwable cause) {
        super(systemManageExceptionEnum.getMessage(), cause);
        this.code = systemManageExceptionEnum.getCode();
    }

    /**
     * 认证服务异常，带异常堆栈信息
     *
     * @param authenticationExceptionEnum
     * @param cause
     */
    public GlobalException(AuthenticationExceptionEnum authenticationExceptionEnum, Throwable cause) {
        super(authenticationExceptionEnum.getMessage(), cause);
        this.code = authenticationExceptionEnum.getCode();
    }

    /**
     * CDN服务异常，带异常堆栈信息
     *
     * @param cdnExceptionEnum
     * @param cause
     */
    public GlobalException(CDNExceptionEnum cdnExceptionEnum, Throwable cause) {
        super(cdnExceptionEnum.getMessage(), cause);
        this.code = cdnExceptionEnum.getCode();
    }

    /**
     * 网关服务异常，带异常堆栈信息
     *
     * @param gatewayExceptionEnum
     * @param cause
     */
    public GlobalException(GatewayExceptionEnum gatewayExceptionEnum, Throwable cause) {
        super(gatewayExceptionEnum.getMessage(), cause);
        this.code = gatewayExceptionEnum.getCode();
    }

    /**
     * 日志服务异常，带异常堆栈信息
     *
     * @param logExceptionEnum
     * @param cause
     */
    public GlobalException(LogExceptionEnum logExceptionEnum, Throwable cause) {
        super(logExceptionEnum.getMessage(), cause);
        this.code = logExceptionEnum.getCode();
    }

    /**
     * 系统异常，带异常堆栈信息
     *
     * @param systemExceptionEnum
     * @param cause
     */
    public GlobalException(SystemExceptionEnum systemExceptionEnum, Throwable cause) {
        super(systemExceptionEnum.getMessage(), cause);
        this.code = systemExceptionEnum.getCode();
    }

    /**
     * 手动抛异常，带异常堆栈信息
     *
     * @param code
     * @param message
     * @param cause
     */
    public GlobalException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * 手动抛异常
     *
     * @param code
     * @param message
     */
    public GlobalException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * 统一异常
     *
     * @param e
     */
    public GlobalException(GlobalException e) {
        super(e.getMessage());
        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
