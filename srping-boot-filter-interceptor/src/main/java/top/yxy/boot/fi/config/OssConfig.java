package top.yxy.boot.fi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author mqxu
 * @description OssConfig
 **/
@Configuration
@PropertySource("classpath:aliyun-oss.properties")
@ConfigurationProperties(prefix = "aliyun-oss")
@Data
public class OssConfig {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String dir;
    private String host;
}