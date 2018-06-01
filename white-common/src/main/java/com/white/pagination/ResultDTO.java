package com.white.pagination;

import java.io.Serializable;

/**
 * 结果集
 *
 * @author: White
 * @date: 2018/6/1
 */
public class ResultDTO<T> implements Serializable {
    private static final String SUCCESS = "success";
    private static final String FAILURE = "failure";
    //状态
    private String status;
    //错误代码
    private String code;
    //错误信息
    private String message;
    //数据
    private T result;

    public static <T> ResultDTO<T> reject(String code, String message, T result) {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setStatus(FAILURE);
        resultDTO.setCode(code);
        resultDTO.setMessage(message);
        resultDTO.setResult(result);
        return resultDTO;
    }

    public static <T> ResultDTO<T> reject(String code, String message) {
        return reject(code, message, (T) null);
    }

    public static <T> ResultDTO<T> reject(String message) {
        return reject(null, message, (T) null);
    }

    public static <T> ResultDTO<T> success() {
        ResultDTO<T> resultDTO = new ResultDTO<>();
        resultDTO.setStatus(SUCCESS);
        return resultDTO;
    }

    public static <T> ResultDTO<T> success(T result) {
        ResultDTO<T> resultDTO = new ResultDTO<T>();
        resultDTO.setStatus(SUCCESS);
        resultDTO.setResult(result);
        return resultDTO;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}

