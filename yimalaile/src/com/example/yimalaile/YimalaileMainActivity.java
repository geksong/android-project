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

import java.io.File;
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
            EditText dateEdit = (EditText)findViewById(R.id.date_edit);
            String nowTime = DateChangeUtil.getDateString(new Date(), DatePattern.YYYY_MM_DD);
            dateEdit.setText(nowTime);
        }else {
            //启动用户信息收集activity
            Intent intent = new Intent(this, CollectUserInfoActivity.class);
            startActivity(intent);
        }
    }
}
