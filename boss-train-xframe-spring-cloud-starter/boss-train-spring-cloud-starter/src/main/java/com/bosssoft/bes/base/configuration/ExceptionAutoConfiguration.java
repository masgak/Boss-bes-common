package com.bosssoft.bes.base.configuration;

import com.bosssoft.bes.base.aop.GlobalExceptionAspect;
import com.bosssoft.bes.base.exception.GlobalException;
import com.bosssoft.bes.base.resolver.GlobalExceptionResolver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: ExceptionAutoConfiguration
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/15 16:11
 * @Version: 1.0.0
 */
@Configuration
public class ExceptionAutoConfiguration {

    @Bean
    @ConditionalOnClass(GlobalExceptionAspect.class)
    @ConditionalOnMissingBean(GlobalExceptionAspect.class)
    public GlobalExceptionAspect globalExceptionAspect() {

        return  new GlobalExceptionAspect();
    }

    @Bean
    @ConditionalOnClass(GlobalExceptionResolver.class)
    @ConditionalOnMissingBean(GlobalException.class)
    public GlobalExceptionResolver globalExceptionResolver(){
        return new GlobalExceptionResolver();
    }
}
