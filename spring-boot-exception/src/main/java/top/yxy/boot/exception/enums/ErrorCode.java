package top.yxy.boot.exception.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
    UNKNOWN_ERROR(999,"未知错误");

     //    定义错误码
    private  final int code;
    private  final String msg;

}
