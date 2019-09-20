package com.bosssoft.bes.base.configuration;

import com.bosssoft.bes.base.commonfield.aspect.CommonFieldAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @ClassName: CommonAutoConfiguration
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/26 9:04
 * @Version: 1.0.0
 */
@Configuration
public class CommonAutoConfiguration {

    @Resource
    private  RedisTemplate redisTemplate;

    @Bean
    @ConditionalOnClass(CommonFieldAspect.class)
    @ConditionalOnMissingBean(CommonFieldAspect.class)
    public CommonFieldAspect commonFieldAspect() {

        return  new CommonFieldAspect(redisTemplate);
    }

}
