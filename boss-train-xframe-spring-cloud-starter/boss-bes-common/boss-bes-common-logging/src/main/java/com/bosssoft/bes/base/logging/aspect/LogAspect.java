package com.bosssoft.bes.base.logging.aspect;

import com.alibaba.fastjson.JSON;
import com.bosssoft.bes.base.logging.annotation.ApiLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author : huangyuhui
 * @date : 2019/8/15
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
	private static  String url;
	/**
	 * 接口的说明信息
	 */
	private static String description;
	/**
	 * 请求的方法
	 */
	private static String httpMethod;
	/**
	 * 被请求的方法路径：包名+方法名
	 */
	private static String classMethod;
	/**
	 * 请求方的IP
	 */
	private static String ip;
	/**
	 * 请求入参
	 */
	private static String requestArgs;
	/**
	 *响应出参
	 */
	private static String responseArgs;
	/**
	 *请求耗时
	 */
	private static Long timeConsuming;

	/**
	 * 切入点
	 */
	@Pointcut("@annotation(com.bosssoft.bes.base.logging.annotation.ApiLog)")
	public void pointcut(){}

	/**
	 * 环绕处理
	 * @param proceedingJoinPoint 处理节点
	 * @return 返回方法返参
	 */
	@Around("pointcut()")
	public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
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
	 * @param joinPoint 连接点
	 */
	@Before("pointcut()")
	public void doBefore(JoinPoint joinPoint){
		url=request.getRequestURL().toString();
		description=getAspectLogDescription(joinPoint);
		httpMethod=request.getMethod();
		classMethod=joinPoint.getSignature().getDeclaringTypeName()+"."
				+joinPoint.getSignature().getName();
		ip=request.getRemoteAddr();
		requestArgs=JSON.toJSONString(joinPoint.getArgs());

		LOGGER.info("==============================Start==============================");
		LOGGER.info("URL							:	{}",url);
		LOGGER.info("Descrption				:	{}",description);
		LOGGER.info("HTTP Method			:	{}",httpMethod);
		LOGGER.info("Class Method			: 	{}",classMethod);
		LOGGER.info("IP				       		: 	{}",ip);
		LOGGER.info("Request Args			:	{}",requestArgs);
	}


	/**
	 * 后置处理
	 */
	@After("pointcut()")
	public void doAfter(){
		LOGGER.info("==============================End===============================");
	}

	/**
	 * 获取注解的desc，即方法的描述
	 * @param joinPoint 连接点
	 * @return desc的内容
	 */
	private String getAspectLogDescription (JoinPoint joinPoint){
		Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
		ApiLog apiLog=method.getAnnotation(ApiLog.class);
		return apiLog.desc();
	}
}
