package com.dave.a13aospapplication;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.Manifest;
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
        // Android 6.0动态请求权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION
                    ,Manifest.permission.BLUETOOTH_CONNECT
                    ,Manifest.permission.BLUETOOTH
                    , Manifest.permission.ACCESS_COARSE_LOCATION};
            for (String str : permissions) {
                if (checkSelfPermission(str) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(permissions, 111);
                    break;
                }
            }
        }

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