package com.bosssoft.hr.train.logging.annotation;

import java.lang.annotation.*;

/**
 * @author : huangyuhui
 * @date : 2019/8/15 10:15
 * @Description : 自定义日志切面注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ApiLog {
	/*
	String pointcut() default "execution(* *(..))";*
	*/

	/**
	 *附加描述、备注
	 * @return
	 */
	String desc() default "";
}
