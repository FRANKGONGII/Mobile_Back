package com.example.backend.Controller;

import com.example.backend.util.BizException;
import com.example.backend.util.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@RestControllerAdvice
public class BusinessExceptionHandler {
    @ExceptionHandler(BizException.class)
    public ResponseEntity<CommonResponse<?>> handleBaseException(BizException e) {
        log.error("Biz Exception", e);
        return ResponseEntity.status(e.getCode()).body(CommonResponse.error(e.getCode(),e.getMessage()));
    }
}
