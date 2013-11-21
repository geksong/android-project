package com.example.yimalaile;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.EditText;
import com.example.yimalaile.constants.DatePattern;
import com.example.yimalaile.util.DateChangeUtil;

import java.util.Date;

public class YimalaileMainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        setContentView(R.layout.main);
        getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title);
        EditText dateEdit = (EditText)findViewById(R.id.date_edit);
        String nowTime = DateChangeUtil.getDateString(new Date(), DatePattern.YYYY_MM_DD);
        dateEdit.setText(nowTime);
    }
}
