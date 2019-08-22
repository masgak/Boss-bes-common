package com.bosssoft.bes.base.exception;

import com.bosssoft.bes.base.enums.*;

/**
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
     * @param besDataExceptionEnum
     */
    public GlobalException(BesDataExceptionEnum besDataExceptionEnum){
        super(besDataExceptionEnum.getMessage());
        this.code = besDataExceptionEnum.getCode();
    }

    /**
     * 考试服务异常
     * @param examExceptionEnum
     */
    public GlobalException(ExamExceptionEnum examExceptionEnum){
        super(examExceptionEnum.getMessage());
        this.code = examExceptionEnum.getCode();
    }

    /**
     * 试卷服务异常
     * @param paperExceptionEnum
     */
    public GlobalException(PaperExceptionEnum paperExceptionEnum){
        super(paperExceptionEnum.getMessage());
        this.code = paperExceptionEnum.getCode();
    }

    /**
     * 系统管理异常
     * @param systemManageExceptionEnum
     */
    public GlobalException(SystemManageExceptionEnum systemManageExceptionEnum){
        super(systemManageExceptionEnum.getMessage());
        this.code = systemManageExceptionEnum.getCode();
    }

    /**
     * 认证服务异常
     * @param authenticationExceptionEnum
     */
    public GlobalException(AuthenticationExceptionEnum authenticationExceptionEnum){
        super(authenticationExceptionEnum.getMessage());
        this.code = authenticationExceptionEnum.getCode();
    }

    /**
     * CDN服务异常
     * @param cdnExceptionEnum
     */
    public GlobalException(CDNExceptionEnum cdnExceptionEnum){
        super(cdnExceptionEnum.getMessage());
        this.code = cdnExceptionEnum.getCode();
    }

    /**
     * 网关服务异常
     * @param gatewayExceptionEnum
     */
    public GlobalException(GatewayExceptionEnum gatewayExceptionEnum){
        super(gatewayExceptionEnum.getMessage());
        this.code = gatewayExceptionEnum.getCode();
    }

    /**
     * 日志服务异常
     * @param logExceptionEnum
     */
    public GlobalException(LogExceptionEnum logExceptionEnum){
        super(logExceptionEnum.getMessage());
        this.code = logExceptionEnum.getCode();
    }

    /**
     * 系统异常
     * @param systemExceptionEnum
     */
    public GlobalException(SystemExceptionEnum systemExceptionEnum){
        super(systemExceptionEnum.getMessage());
        this.code = systemExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
