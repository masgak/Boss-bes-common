package com.bosssoft.bes.base.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * aop设置公共字段增强处理注解
 *
 * @author 李旭阳
 * @createdTime  2019/8/15 11点18分
 * @version 1.0.0
 * @updateBy 李旭阳
 * @updatedTime  2019/8/15 11点18分
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface SetCommonField {
    /**
     * 标注方法类型
     * @return 方法类型字符串
     */
    String methodType();
}
