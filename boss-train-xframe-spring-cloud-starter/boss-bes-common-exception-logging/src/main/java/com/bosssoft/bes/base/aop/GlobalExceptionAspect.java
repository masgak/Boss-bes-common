package com.bosssoft.bes.base.aop;

import com.bosssoft.bes.base.resolver.GlobalExceptionResolver;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 全局异常切面
 * @ClassName: ParamCheckAop
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/12 13:40
 * @Version: 1.0.0
 */
@Component
@Aspect
public class GlobalExceptionAspect {
    private final static Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionAspect.class);

    @Autowired
    private GlobalExceptionResolver globalExceptionResolver;

    @Pointcut(value = "@annotation(com.bosssoft.bes.base.annotation.GlobalExceptionLog)")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {

    }

    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, RuntimeException e) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //创建时间
        LOGGER.error("dateTime={}" + dateFormat.format(new Date()));
        //URL
        LOGGER.error("url={}", request.getRequestURL());
        //method
        LOGGER.error("method={}", request.getMethod());
        //ip
        LOGGER.error("ip={}", request.getRemoteAddr());
        //class_method
        LOGGER.error("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "," + joinPoint.getSignature().getName());
        //args[]
        LOGGER.error("args={}", joinPoint.getArgs());
        //异常信息
        LOGGER.error("errMessage={}" + e);
    }

}
