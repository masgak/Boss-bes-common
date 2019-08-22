package com.bosssoft.bes.base.exception;

import java.io.Serializable;

/**
 * @ClassName: ServiceException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class ServiceException extends GlobalException implements Serializable {

    private static final long serialVersionUID = -972951620650151817L;

    public ServiceException(Integer code, String message) {
        super(code, message);
    }


}
