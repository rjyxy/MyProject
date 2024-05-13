package top.yxy.boot.fi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Administrator
 */
@Getter
@AllArgsConstructor
public enum ErrorCode {
    //枚举
    //401 没有登录 305 接口类型不匹配
    UNAUTHORIZED(401, "登录失效，请重新登录"),
    INTERNAL_SERVER_ERROR(500, "服务器异常，请稍后再试"),
    CODE_SEND_FAIL(3001, "短信发送失败"),
    SMS_CODE_ERROR(3002, "短信验证码错误"),
    PARAMS_ERROR(3003, "参数异常"),
    USER_NOT_EXIST(3004, "用户不存在"),
    USER_EXIST(3005, "用户已存在"),
    SMS_CODE_EXPIRE(3006, "短信验证码已过期");

    //    定义错误码
    private final int code;
    private final String msg;

}
