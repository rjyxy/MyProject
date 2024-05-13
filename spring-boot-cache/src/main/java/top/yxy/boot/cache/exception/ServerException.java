package top.yxy.boot.cache.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Administrator
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServerException extends RuntimeException{
    private  final int code;
    private  final String msg;

    public ServerException(String msg){
        super(msg);
        this.code = ErrorCode.INTERNAL_SERVER_ERROR.getCode();
        //生成的错误码永远是500
        this.msg = msg;
    }

    /**码跟消息自定义*/
    public ServerException(ErrorCode errorCode){
        this.code = errorCode.getCode();
        this.msg = errorCode.getMsg();
    }

}
