package com.example.backend.Controller;

import com.example.backend.util.BizException;
import com.example.backend.util.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BizException.class)
    public CommonResponse<?> handleBaseException(BizException e) {
        log.error("Biz Exception", e);
        return CommonResponse.error(e.getCode(),e.getMessage());
    }
}
