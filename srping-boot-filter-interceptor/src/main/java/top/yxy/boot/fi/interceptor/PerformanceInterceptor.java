package top.yxy.boot.fi.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
@Component
public class PerformanceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    request.setAttribute("startTime", System.currentTimeMillis());
    return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    long startTime = (Long) request.getAttribute("startTime");
    long endTime = System.currentTimeMillis();
    long handleTime = endTime - startTime;
    log.info("接口请求耗时：{} 毫秒",handleTime);
    }
}
