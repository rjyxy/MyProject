package top.yxy.boot.mp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.yxy.boot.mp.mapper"})
public class SpringBootMpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMpApplication.class, args);
    }

}
