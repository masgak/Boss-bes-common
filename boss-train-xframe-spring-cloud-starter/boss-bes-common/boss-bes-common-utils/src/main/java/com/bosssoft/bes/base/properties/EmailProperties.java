package com.bosssoft.bes.base.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ClassName: EmailProperties
 * @Description: TODO
 * @Author: lujinshan
 * @Date: 2019/8/16 16:03
 * @Version: 1.0.0
 */
@Data
@ConfigurationProperties(prefix = "bosssoft.email")
public class EmailProperties {
    /**
     * 邮箱主机
     */
    private String host;

    /**
     *端口
     */
    private Integer port;
    /**
     *用户名
     */
    private String userName;
    /**
     *QQ邮箱开启SMTP的授权码
     */
    private String password;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
