package com.mh.api.MhAPI.utils;

public class MHException extends Exception{

    public static String USER_EXISTS="Username already exist";
    public static Integer CODE_USER_EXISTS=1;
    protected Integer code;

    public MHException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
