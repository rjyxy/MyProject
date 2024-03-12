package top.yxy.boot.config.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Data
@Component
@ConfigurationProperties(prefix = "family")  //整体前缀
@PropertySource(value = {"classpath:family.properties"})
public class Family {

    //    @Value("${family.family-name}")
    private String familyName;

    //    @Value("${family.father}")
    private String father;

    //    @Value("${family.mother}")
    private String mother;

    //    @Value("${family.child}")
    private String child;
}