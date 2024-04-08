package top.yxy.boot.exception.service;

import org.springframework.stereotype.Service;
import top.yxy.boot.exception.enums.ErrorCode;
import top.yxy.boot.exception.exception.ServerException;
/**
 * @author Administrator
 */
@Service
public class MyService {
    //未登录异常
    public void unAuthorizedError(){
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    }

    //服务器异常
    public void serverError(){
        throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
