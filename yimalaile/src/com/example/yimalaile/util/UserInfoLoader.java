package com.example.yimalaile.util;

import com.example.yimalaile.customexception.IOCloseException;
import com.example.yimalaile.customexception.UserInfoLoadException;
import com.example.yimalaile.pojo.UserInfo;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-27
 * Time: 上午9:33
 * 用户信息读取写入
 */
public class UserInfoLoader {
    /**
     * 用户信息读取
     * @param file
     * @return
     * @throws UserInfoLoadException
     * @throws IOCloseException
     */
    public static UserInfo load(File file) throws UserInfoLoadException, IOCloseException{
        FileReader fir = null;
        BufferedReader br = null;
        try {
            fir = new FileReader(file);
            br = new BufferedReader(fir);
            String res = br.readLine();
            UserInfo userInfo = new UserInfo();
            userInfo.setName(res.split("&&")[0]);
            userInfo.setLastStopTime(Integer.parseInt(res.split("&&")[1]));
            return userInfo;
        }catch(Exception e) {
            throw new UserInfoLoadException("用户信息读取异常", e);
        }finally {
            try {
                if(null != fir) {
                    fir.close();
                }
                if(null != br) {
                    br.close();
                }
            }catch(IOException e1) {
                throw new IOCloseException("IO流关闭异常", e1);
            }
        }
    }

    /**
     * 用户信息写入
     * @param userInfo
     * @param file
     */
    public static void write(UserInfo userInfo, File file) throws UserInfoLoadException, IOCloseException{
        FileWriter fiw = null;
        BufferedWriter bw = null;
        try {
            fiw = new FileWriter(file);
            bw = new BufferedWriter(fiw);
            String res = userInfo.getName() + "&&" + userInfo.getLastStopTime();
            bw.write(res);
            bw.flush();
        }catch(Exception e) {
            throw new UserInfoLoadException("用户信息写入异常", e);
        }finally {
            try {
                if(null != fiw) {
                    fiw.close();
                }
                if(null != bw) {
                    bw.close();
                }
            }catch(IOException e1) {
                throw new IOCloseException("IO流关闭异常", e1);
            }
        }
    }
}
