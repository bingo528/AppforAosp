package com.dave.a13aospapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button mBtnBtView,mBtnWifiView;
    Context mContext;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initData();
        initClick();
    }



    /**
     * 初始化view
     */
    private void initView() {
        mBtnBtView = findViewById(R.id.btn_bt);
        mBtnBtView = findViewById(R.id.btn_wifi);
    }
    /**
     * 初始化数据
     */
    private void initData() {

    }

    /**
     * 初始化点击事件
     */
    private void initClick() {
        //mBtnBtView.setOnClickListener(this);

    }


    public void openBtSettings(View view) {
        startActivity(new Intent(this,BtSettingsActivity.class));
    }
}