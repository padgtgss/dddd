package com.util.exception;

/**
 * @Description: BaseBusinessException
 * @Author: lin.shi
 * @CreateTime: 2017-04-28 14:41
 */
public class BaseBusinessException extends RuntimeException {
    public static final int defaultExceptionCode = 508;
    public static final String defaultExceptionMessage = "系统内部异常";
    private int code;
    private String message;

    public BaseBusinessException() {
        super();
    }

    public BaseBusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseBusinessException(String message) {
        this.code = defaultExceptionCode;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
