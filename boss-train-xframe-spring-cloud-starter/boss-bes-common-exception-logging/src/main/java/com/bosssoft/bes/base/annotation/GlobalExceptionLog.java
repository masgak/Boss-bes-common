package com.bosssoft.bes.base.annotation;

import java.lang.annotation.*;

/**
 * 统一异常注解
 * @author lujinshan
 * @date Created on 2019.08.12
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GlobalExceptionLog {
    /**
     * 设置默认值
     */
    String value() default "";
}
