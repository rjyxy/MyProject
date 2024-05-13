package top.yxy.boot.fi.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebFilter(filterName = "customFilter",urlPatterns = {"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("CustomFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("CustomFilter 处理接口请求之前之前做了一些处理，比如禁词处理");
        chain.doFilter(request, response);
        log.info("CustomFilter 处理接口请求之后，做一些响应的处理");
    }

    @Override
    public void destroy() {
        log.info("CustomFilter 销毁");
    }
}
