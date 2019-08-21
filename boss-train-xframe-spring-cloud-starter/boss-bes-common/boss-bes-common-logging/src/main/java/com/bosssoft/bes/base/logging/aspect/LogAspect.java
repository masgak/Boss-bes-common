package com.bosssoft.bes.base.logging.aspect;

import com.alibaba.fastjson.JSON;
import com.bosssoft.bes.base.logging.annotation.ApiLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author : huangyuhui
 * @date : 2019/8/15 0015
 * @Description : 日志切面类
 */
@Aspect
@Component
public class LogAspect {

	/**
	 * 请求
	 */
	@Resource
	private HttpServletRequest request;
	/**
	 *	日志记录Logger
	 */
	private static final Logger LOGGER= LoggerFactory.getLogger(LogAspect.class);
	/**
	 * 请求接口地址
	 */
	private String url;
	/**
	 * 接口的说明信息
	 */
	private String description;
	/**
	 * 请求的方法
	 */
	private String httpMethod;
	/**
	 * 被请求的方法路径：包名+方法名
	 */
	private String classMethod;
	/**
	 * 请求方的IP
	 */
	private String ip;
	/**
	 * 请求入参
	 */
	private String requestArgs;
	/**
	 *响应出参
	 */
	private String responseArgs;
	/**
	 *请求耗时
	 */
	private Long timeConsuming;


	/**
	 * 环绕处理
	 * @param proceedingJoinPoint 处理节点
	 * @param al 注解
	 * @return
	 * @throws Throwable
	 */
	@Around("@annotation(al)")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint, ApiLog al) throws Throwable{
		System.out.println("测试");
		Long startTime=System.currentTimeMillis();
		Object result=proceedingJoinPoint.proceed();
		responseArgs=JSON.toJSONString(result);
		LOGGER.info("Response Args		:	{}", responseArgs);
		Long endTime=System.currentTimeMillis();
		timeConsuming=endTime-startTime;
		LOGGER.info("Time-Consuming	:	{}ms",JSON.toJSONString(timeConsuming));
		return result;
	}

	/**
	 * 前置处理
	 * @param joinPoint
	 * @param al
	 */
	@Before("@annotation(al)")
	public void doBefore(JoinPoint joinPoint,ApiLog al){
		url=request.getRequestURL().toString();
		description=al.desc();
		httpMethod=request.getMethod();
		classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."
									+joinPoint.getSignature().getName();
		ip=request.getRemoteAddr();
		requestArgs=JSON.toJSONString(joinPoint.getArgs());

		LOGGER.info("==========================Start==========================");
		LOGGER.info("URL							:	{}",url);
		LOGGER.info("Descrption				:	{}",description);
		LOGGER.info("HTTP Method			:	{}",httpMethod);
		LOGGER.info("Class Method			: 	{}",classMethod);
		LOGGER.info("IP							: 	{}",ip);
		LOGGER.info("Request Args			:	{}",requestArgs);
	}


	/**
	 * 后置处理
	 * @param al
	 */
	@After("@annotation(al)")
	public void doAfter(ApiLog al){
		LOGGER.info("==========================End===========================");
	}
}
