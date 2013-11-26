package com.example.yimalaile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.EditText;
import com.example.yimalaile.activity.CollectUserInfoActivity;
import com.example.yimalaile.constants.Constants;
import com.example.yimalaile.constants.DatePattern;
import com.example.yimalaile.util.DateChangeUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

public class YimalaileMainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String appPath = getApplicationContext().getFilesDir().getAbsolutePath();
        File userInfoFile = new File(appPath, Constants.USERINFO_FILE_NAME);
        if(userInfoFile.exists()) {
            Log.i("YimalaileMainActivity", "当前应用路径:" + appPath);
            requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
            setContentView(R.layout.main);
            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
            FileReader fir = null;
            BufferedReader br = null;
            try {
                fir = new FileReader(userInfoFile);
                br = new BufferedReader(fir);
                String userinfo = br.readLine();
                if(null == userinfo) {
                    userInfoFile.delete();
                    //启动用户信息收集activity
                    Intent intent = new Intent(this, CollectUserInfoActivity.class);
                    startActivity(intent);
                    return;
                }
                int time = Integer.parseInt(userinfo.split("&&")[1]);
                Date dat = DateChangeUtil.getDateFromSeconds(time);
                EditText dateEdit = (EditText)findViewById(R.id.date_edit);
                String lastEndTime = DateChangeUtil.getDateString(dat, DatePattern.YYYY_MM_DD);
                dateEdit.setText(lastEndTime);

            }catch(Exception e) {
                Log.e("YimalaileMainActivity", e.getMessage());
            }finally {
                try {
                    if(null != fir) {
                        fir.close();
                    }
                    if(null != br) {
                        br.close();
                    }
                }catch(Exception e1) {
                    Log.e("YimalaileMainActivity", e1.getMessage());
                }
            }
        }else {
            //启动用户信息收集activity
            Intent intent = new Intent(this, CollectUserInfoActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        String appPath = getApplicationContext().getFilesDir().getAbsolutePath();
        File userInfoFile = new File(appPath, Constants.USERINFO_FILE_NAME);
        try {
            if(userInfoFile.exists()) {
                FileReader fir = new FileReader(userInfoFile);
                BufferedReader br = new BufferedReader(fir);
                String userinfo = br.readLine();
                Integer timeSec = Integer.parseInt(userinfo.split("&&")[1]);
                Date date = DateChangeUtil.getDateFromSeconds(timeSec);
                Log.i("YimalaileMainActivity", date.toString());
                // TODO
            }
        }catch(Exception e) {
            Log.e("YimalaileMainActivity", "用户信息文件读取错误" + e.getMessage());
        }
    }
}
