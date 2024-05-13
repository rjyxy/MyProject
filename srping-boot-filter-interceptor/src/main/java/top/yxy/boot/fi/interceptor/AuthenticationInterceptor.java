package top.yxy.boot.fi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import top.yxy.boot.fi.utils.JwtUtil;
@Slf4j
@Component
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        检查请求头中是否有 tocken
        String token = request.getHeader("Authorization");
        if (token != null){
            boolean validate = JwtUtil.validate(token);
            if (validate){
                return true;
            }else {
                log.info("token 失效");
                return  false;
            }
        }else {
            //        没有token,用户登陆了，就放行
            //        没有token,用户登录，拦截
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }


    }
}
