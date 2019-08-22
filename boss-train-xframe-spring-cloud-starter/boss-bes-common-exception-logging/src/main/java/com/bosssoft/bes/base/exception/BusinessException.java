package com.bosssoft.bes.base.exception;

/**
 * @ClassName: BusinessException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class BusinessException extends GlobalException {

    private static final long serialVersionUID = 6038530906869496962L;

    public BusinessException(Integer code, String message) {
        super(code, message);
    }

}
