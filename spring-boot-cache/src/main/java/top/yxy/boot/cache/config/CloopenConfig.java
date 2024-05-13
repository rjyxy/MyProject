package top.yxy.boot.cache.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


@Data
@Configuration
@ConfigurationProperties(prefix = "yxy.sms.ccp")
public class CloopenConfig {

    private String serverIp;
    private String port;
    private String accountSId;
    private String accountToken;
    private String appId;
    private String templateId;
}