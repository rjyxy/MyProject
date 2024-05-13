package top.yxy.boot.cache.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.yxy.boot.cache.result.Result;
import top.yxy.boot.cache.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public Result<String> loginByPhone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        return Result.ok(authService.loginByPhone(phone, code));
    }
}
