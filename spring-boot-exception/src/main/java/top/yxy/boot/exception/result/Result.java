package top.yxy.boot.exception.result;

import lombok.Getter;
import lombok.Setter;
import top.yxy.boot.exception.enums.ErrorCode;

/**
 * @author Administrator
 */
@Setter
@Getter
public class Result<T> {
    private int code = 200;
    private String msg = "success";
    private T data;

    /**静态方法*/
    //成功返回没有值
    public static <T> Result<T> ok(){
    return new Result<>();
    }

    //成功返回有值
    public static <T> Result<T> ok(T data){
        Result<T> rs = new Result<>();
        rs.setData(data);
        return rs;
    }

    /*重载**/

    public static <T> Result<T> error(String msg) {
        Result<T> rs = new Result<>();
        rs.setMsg(msg);
        return rs;
    }


    public static <T> Result<T> error() {
        Result<T> rs = new Result<>();
        rs.setMsg(ErrorCode.INTERNAL_SERVER_ERROR.getMsg());
        return rs;
    }

    public static <T> Result<T> error(int code,String msg) {
        Result<T> rs= new Result<>();
        rs.setCode(code);
        rs.setMsg(msg);
        return rs;
    }

}
