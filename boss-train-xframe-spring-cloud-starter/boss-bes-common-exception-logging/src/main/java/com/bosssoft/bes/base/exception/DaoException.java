package com.bosssoft.bes.base.exception;

import java.io.Serializable;

/**
 * @ClassName: DaoException
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/22 9:51
 * @Version: 1.0.0
 */
public class DaoException extends GlobalException implements Serializable {


    private static final long serialVersionUID = 9132331078500544110L;

    public DaoException(Integer code, String message) {
        super(code, message);
    }
}
