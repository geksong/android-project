package com.example.yimalaile.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import com.example.yimalaile.R;
import com.example.yimalaile.constants.Constants;
import com.example.yimalaile.constants.DatePattern;
import com.example.yimalaile.util.DateChangeUtil;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-21
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */
public class CollectUserInfoActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.usr_info_collect);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
        final Button button = (Button)findViewById(R.id.user_date_btn);
        button.setText(DateChangeUtil.getDateString(new Date(), DatePattern.YYYY_MM_DD));
        Date nowDate = new Date();
        final DatePickerDialog dpd = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(i, i2, i3);
                button.setText(DateChangeUtil.getDateString(calendar.getTime(), DatePattern.YYYY_MM_DD));
            }
        }, DateChangeUtil.getYear(nowDate), DateChangeUtil.getMonthOfYear(nowDate), DateChangeUtil.getDayOfMonth(nowDate));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dpd.show();
            }
        });
        String appPath = getApplicationContext().getFilesDir().getPath();
        final File file = new File(appPath, Constants.USERINFO_FILE_NAME);
        Button sureButton = (Button)findViewById(R.id.user_sure_btn);
        final EditText userNameText = (EditText)findViewById(R.id.user_name_text);
        View.OnClickListener sureOnClickListener = new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                FileWriter fis = null;
                BufferedWriter bos = null;
                try {
                    String userName = userNameText.getText().toString();
                    String dateTime = String.valueOf(button.getText());
                    int timeSec = DateChangeUtil.getSeconds(DateChangeUtil.stringToDate(dateTime, DatePattern.YYYY_MM_DD));
                    fis = new FileWriter(file);
                    bos = new BufferedWriter(fis);
                    String data = userName + "&&" + timeSec;
                    bos.write(data);
                }catch(Exception e) {
                    Log.e("CollectUserInfoActivity",e.getMessage());
                }finally {
                    try {
                        fis.close();
                        bos.close();
                    }catch(Exception e) {
                        Log.e("CollectUserInfoActivity", e.getMessage());
                    }
                    finish();
                }
            }
        };
        sureButton.setOnClickListener(sureOnClickListener);
    }
}