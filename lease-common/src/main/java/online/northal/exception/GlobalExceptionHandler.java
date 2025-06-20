package online.northal.exception;

import online.northal.result.ActionResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ActionResult<String> handle(Exception exception) {
        exception.printStackTrace();
        return ActionResult.fail(exception.getMessage(), "系统异常，请稍后再试");
    }
}
