package online.northal.result;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ActionResult<T> implements Serializable {
    /** 状态码 */
    @Schema(description = "状态码", example = "200")
    private Integer code;

    /** 返回数据 */
    @Schema(description = "返回的数据对象")
    private T data;

    /** 返回提示信息 */
    @Schema(description = "返回信息", example = "操作成功")
    private String message;


    public static <T>ActionResult<T> success() {
        return ActionResult.<T>builder()
                .code(200)
                .data(null)
                .message("操作成功")
                .build();
    }


    public static <T>ActionResult<T> success(T data) {
        return ActionResult.<T>builder()
                .code(200)
                .data(data)
                .message("操作成功")
                .build();
    }

    public static <T>ActionResult<T> success(T data, String message) {
        return ActionResult.<T>builder()
                .code(200)
                .data(data)
                .message(message)
                .build();
    }

    public static <T>ActionResult<T> success(Integer code, T data, String message) {
        return ActionResult.<T>builder()
                .code(code)
                .data(data)
                .message(message)
                .build();
    }

    public static <T>ActionResult<T> fail() {
        return ActionResult.<T>builder()
                .code(500)
                .data(null)
                .message("操作失败")
                .build();
    }

    public static <T>ActionResult<T> fail(T data, String message) {
        return ActionResult.<T>builder()
                .code(500)
                .data(data)
                .message(message)
                .build();
    }

    public static <T>ActionResult<T> fail(Integer code, String message) {
        return ActionResult.<T>builder()
                .code(code)
                .data(null)
                .message(message)
                .build();
    }

    public static <T>ActionResult<T> fail(String message) {
        return ActionResult.<T>builder()
                .code(500)
                .data(null)
                .message(message)
                .build();
    }

    public static <T>ActionResult<T> fail(Integer code, T data, String message) {
        return ActionResult.<T>builder()
                .code(code)
                .data(data)
                .message(message)
                .build();
    }
}
