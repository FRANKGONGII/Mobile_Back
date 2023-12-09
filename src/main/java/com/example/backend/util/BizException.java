package com.example.backend.util;

import lombok.Getter;

@Getter
public class BizException extends RuntimeException {
    private final int code;
    private final String message;

    public BizException(String msg) {
        this.code = 500;
        this.message = msg;
    }

    public BizException(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

}