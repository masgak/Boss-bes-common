package com.bosssoft.bes.base.configuration;

import com.bosssoft.bes.base.coredata.aspect.HttpLogAspect;
import com.bosssoft.bes.base.logging.aspect.LogAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 日志类自动装配
 * @ClassName: LogAutoConfiguration
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/21 13:44
 * @Version: 1.0.0
 */
@Configuration
public class LogAutoConfiguration {

//    @Bean
//    @ConditionalOnMissingBean(ApiLog.class)
//    public ApiLog ApiLog(){
//        return   ApiLog();
//    }

    @Bean
    @ConditionalOnClass(LogAspect.class)
    @ConditionalOnMissingBean(LogAspect.class)
    public LogAspect logAspect(){
        return  new LogAspect();
    }


    @Bean
    @ConditionalOnClass(HttpLogAspect.class)
    @ConditionalOnMissingBean(HttpLogAspect.class)
    public HttpLogAspect httpLogAspect(){
        return  new HttpLogAspect();
    }
}
