package top.yxy.boot.fi.result;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseResult {
    private Integer code;
    private String msg;
    private Object data;

    public static ResponseResult error(Integer code, String msg) {
        return ResponseResult.builder()
                .code(code)
                .msg(msg)
                .data(null)
                .build();
    }

    public static ResponseResult error(String msg) {
        return ResponseResult.builder()
                .code(400)
                .msg(msg)
                .data(null)
                .build();
    }

    public static ResponseResult ok(Object data) {
        return ResponseResult.builder()
                .code(200)
                .msg("操作成功")
                .data(data)
                .build();
    }


    public static ResponseResult ok() {
        return ResponseResult.ok(null);
    }
}
