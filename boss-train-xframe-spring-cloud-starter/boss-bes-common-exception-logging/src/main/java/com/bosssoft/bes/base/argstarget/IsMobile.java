package com.bosssoft.bes.base.argstarget;

import com.bosssoft.bes.base.validator.IsMobileValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author lujinshan
 */
//说明该注解将被包含在javadoc中
@Documented
// 注解的作用目标 类上、方法上、属性上
@Target({ElementType.FIELD, ElementType.PARAMETER})
// 注解的保留位置　　
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {IsMobileValidator.class }) // 与约束注解关联的验证器
public @interface IsMobile {

    boolean required() default true;

    String message() default "手机号不正确";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}