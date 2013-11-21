package com.example.yimalaile.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.example.yimalaile.R;

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
    }
}