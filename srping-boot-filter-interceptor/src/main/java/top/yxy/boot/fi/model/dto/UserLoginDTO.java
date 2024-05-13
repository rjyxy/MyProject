package top.yxy.boot.fi.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户登录")
public class UserLoginDTO {
    @Schema(description = "手机号")
    private String phone;
    @Schema(description = "验证码")
    private String code;
}


