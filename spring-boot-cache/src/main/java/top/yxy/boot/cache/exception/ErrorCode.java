package top.yxy.boot.cache.exception;

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
    UNAUTHORIZED(401,"登录失效，请重新登录"),
    INTERNAL_SERVER_ERROR(500,"服务器异常，请稍后再试"),
    CODE_SEND_FAIL(3001, "短信发送失败"),
    SMS_CODE_ERROR(3002, "短信验证码错误"),
    SMS_CODE_EXPIRE(3003,"验证码已失效"),
    PARAMS_ERROR(3003, "参数异常");

     //    定义错误码
    private  final int code;
    private  final String msg;

}
