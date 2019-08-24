package com.bosssoft.bes.base.commonfield;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true,proxyTargetClass = true)
public class CommonFieldApplication {
    public static void main(String[] args){
        SpringApplication.run(CommonFieldApplication.class,args);
    }
}
