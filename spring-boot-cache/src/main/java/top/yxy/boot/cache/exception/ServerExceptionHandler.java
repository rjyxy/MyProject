package top.yxy.boot.cache.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.yxy.boot.cache.result.Result;

/**
 * @author Administrator
 */
@Slf4j
@RestControllerAdvice
public class ServerExceptionHandler {
    /**处理自定义异常
     * @param  e 异常
     * @return  Result*/
    @ExceptionHandler(value = ServerException.class)
    public Result<?> handleServerException(ServerException e){
        return Result.error(e.getCode(),e.getMsg());
    }

    @ExceptionHandler(value = Exception.class)
    public Result<?> handleException(Exception e){
        return Result.error(e.getMessage());
    }
}
