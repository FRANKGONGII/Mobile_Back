package com.example.backend.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonResponse<T> {
    /**
     * custom status code
     */
    private int code;
    /**
     * status message
     */
    private String msg;
    /**
     * data to be returned
     */
    private T data;


    public static <T> CommonResponse<T> success() {
        return success(null);
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(200, "success", data);
    }

    public static <T> CommonResponse<T> error(int code, String msg) {
        return new CommonResponse<>(code, msg, null);
    }

}