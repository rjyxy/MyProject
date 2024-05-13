package top.yxy.boot.fi.controller;

import cn.hutool.json.JSONObject;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yxy.boot.fi.constant.Constant;
import top.yxy.boot.fi.utils.JwtUtil;

@RestController
@Slf4j
public class TestController {
    @GetMapping("/test")
    public String test(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JSONObject payload = JwtUtil.getPayload(token);
        log.info("userId:{}",payload.get(Constant.USER_ID));
        log.info("nickname:{}",payload.get(Constant.NICKNAME));

        return "hello world";
    }
}
