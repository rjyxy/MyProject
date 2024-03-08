package top.yxy.boot.quickstart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

/**
 * @author Administrator
 */
@SpringBootApplication
@Slf4j
public class HelloWorldApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(HelloWorldApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("启动成功");
        log.info("测试地址：http://localhost:{}/swagger-ui.html", env.getProperty("server.port"));
    }
}