package top.yxy.boot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.yxy.boot.mybatis.mapper"})
public class MybatisApplication {
    public static void main(String[] args) {
    SpringApplication.run(MybatisApplication.class,args);
    }
}
