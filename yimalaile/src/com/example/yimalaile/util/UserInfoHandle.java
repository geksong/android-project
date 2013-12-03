package com.example.yimalaile.util;

import com.example.yimalaile.pojo.UserInfo;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-27
 * Time: 上午9:25
 * 用户信息存储
 */
public class UserInfoHandle {
    private static ThreadLocal<UserInfo> userHandle = new ThreadLocal<UserInfo>();
    private static UserInfoHandle handle = new UserInfoHandle();
    private UserInfoHandle() {

    }
    public static UserInfoHandle instance() {
        return handle;
    }

    /**
     * 获取用户信息
     * @return
     */
    public UserInfo getUserInfo() {
        return userHandle.get();
    }

    /**
     * 设置用户信息
     * @param userInfo
     */
    public void setUserInfo(UserInfo userInfo) {
        userHandle.set(userInfo);
    }
}
