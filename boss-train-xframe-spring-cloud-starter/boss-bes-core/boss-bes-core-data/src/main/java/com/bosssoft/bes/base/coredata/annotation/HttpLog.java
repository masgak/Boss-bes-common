package com.bosssoft.bes.base.coredata.annotation;

import java.lang.annotation.*;

/**
 * @author : lujinshan
 * @date : 2019/8/25 10:15
 * @Description : 自定义日志切面注解，只切controller的
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface HttpLog {
	/**
	 *附加描述、备注
	 * @return
	 */
	String desc() default "";
}
