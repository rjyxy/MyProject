package top.yxy.boot.fi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("拦截器测试 API")
                        .contact(new Contact().name("yxy").email("16422802@qq.com"))
                .version("1.0")
                .description("Knife4j 集成 springdoc-openapi 示例")
                .termsOfService("http://doc.xiaominfo.com")
                .license(new License().name("Apache 2.0")
                        .url("http://doc.xiaominfo.com")));
    }

}