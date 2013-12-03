package com.example.yimalaile.customexception;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-27
 * Time: 上午9:37
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoLoadException extends Throwable {
    public UserInfoLoadException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
