package top.yxy.boot.fi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.yxy.boot.fi.enums.ErrorCode;
import top.yxy.boot.fi.model.vo.UserInfoVO;
import top.yxy.boot.fi.model.vo.UserLoginVO;
import top.yxy.boot.fi.result.Result;
import top.yxy.boot.fi.utils.JwtUtil;

import java.time.LocalDate;

@RestController
@RequestMapping("/auth")
@Tag(name = "认证接口")
@AllArgsConstructor
public class AuthController {
    @PostMapping("/login")
    @Operation(summary = "手机号登录")
    public Result<UserLoginVO> loginByPhone(@RequestParam("phone") String phone, @RequestParam("code") String code) {
        // 实际应该从数据库查询对比
        if ("18851683576".equals(phone) && "123456".equals(code)) {
            UserLoginVO userLoginVO = UserLoginVO.builder().id(1).phone(phone).nickname("sherry").build();
            // 生成 jwt，然后放在 vo 中返回给客户端
            userLoginVO.setAccessToken(JwtUtil.createToken(1, "sherry"));
            return Result.ok(userLoginVO);
        }
        return Result.error(ErrorCode.UNAUTHORIZED);
    }
    @PostMapping("/logout")
    @Operation(summary = "登出")
    public Result<Object> logout() {
        return Result.ok("退出登录");
    }
    @GetMapping("/info")
    @Operation(summary = "用户信息")
    public Result<Object> userInfo() {
        UserInfoVO userInfoVO = UserInfoVO.builder()
                .id(1)
                .phone("18851683576")
                .nickname("sherry")
                .avatar("https://spring-boot-learning.oss-cn-beijing.aliyuncs.com/images/img1.png")
                .sign("sherry")
                .birthday(LocalDate.of(2024, 5, 6))
                .build();
        return Result.ok(userInfoVO);
    }
}
