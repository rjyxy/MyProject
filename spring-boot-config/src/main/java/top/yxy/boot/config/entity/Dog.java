package top.yxy.boot.config.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 */
@Data
@Component
public class Dog {
    @Value("${person.dog.name}")
    private String name;

    @Value("${person.dog.age}")
    private Integer age;
}
