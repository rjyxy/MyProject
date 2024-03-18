package top.yxy.boot.database;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.yxy.boot.database.mapper"})
public class DataBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseApplication.class, args);
    }
}
