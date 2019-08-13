package com.bosssoft.hr.train.exception;

import java.io.Serializable;

/**
 * @ClassName: GlobalException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/10 23:28
 * @Version: 1.0.0
 */
public class GlobalException extends RuntimeException implements Serializable {


    private static final long serialVersionUID = -5279026448701847887L;

    private Integer code;

    public GlobalException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
