package com.bosssoft.bes.base.configuration;

import com.bosssoft.bes.base.properties.EmailProperties;
import com.bosssoft.bes.base.service.EmailService;
import com.bosssoft.bes.base.utils.EmailUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: EmailAutoConfiguration
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/16 16:14
 * @Version: 1.0.0
 */
@Configuration
@ConditionalOnClass(EmailService.class)
@EnableConfigurationProperties(EmailProperties.class)
public class EmailAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean(EmailService.class)
    public EmailService emailService(EmailProperties emailProperties){
        EmailService emailService = new EmailService(emailProperties);
        return emailService;
    }

    @Bean
    @ConditionalOnMissingBean(EmailUtils.class)
    public EmailUtils emailUtils(){
        EmailUtils emailUtils = new EmailUtils();

        return emailUtils;
    }

}
