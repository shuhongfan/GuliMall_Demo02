package com.shf.gulimail.modules.product.exception;

import com.shf.gulimail.common.exception.ErrorCode;
import com.shf.gulimail.common.utils.Result;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(basePackages = "com.shf.gulimail.modules.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleVaildException(MethodArgumentNotValidException ex){
        System.out.println("数据校验出现问题"+ ex.getMessage()+"，异常类型："+ ex.getClass());
        BindingResult result = ex.getBindingResult();
        HashMap<String, String> map = new HashMap<>();
        if (result.hasErrors()){
            result.getFieldErrors().forEach(item->{
                String defaultMessage = item.getDefaultMessage();
                String field = item.getField();
                map.put(field, defaultMessage);
            });

        } else {

        }
        return new Result().error(400,"提交的数据不合法").ok(map);
    }

    @ExceptionHandler(value = Throwable.class)
    public Result handleException(Throwable throwable){
        return new Result().error(ErrorCode.INTERNAL_SERVER_ERROR );
    }
}
