package top.yxy.boot.fi.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.yxy.boot.fi.constant.Constant;
import top.yxy.boot.fi.interceptor.*;

/**
 * @author Administrator
 */
@Configuration
@AllArgsConstructor
public class SpringMvcConfig implements WebMvcConfigurer {
    private final AuthInterceptor authInterceptor;
    private final UploadInterceptor uploadInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(authInterceptor)
                .addPathPatterns(Constant.AUTH_LOGOUT, Constant.AUTH_INFO);

        registry
                .addInterceptor(uploadInterceptor)
                .addPathPatterns(Constant.COMMON_UPLOAD);
    }
}