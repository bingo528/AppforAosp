package com.dave.a13aospapplication;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.Manifest;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
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
        Log.d(TAG,"testlife MainActivity onCreate");
        initView();
        initData();
        initClick();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"testlife MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"testlife MainActivity onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"testlife MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"testlife MainActivity onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"testlife MainActivity onRestart");
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
            String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE
                    , Manifest.permission.READ_EXTERNAL_STORAGE
                    ,Manifest.permission.BLUETOOTH_CONNECT
                    , Manifest.permission.CHANGE_WIFI_STATE
                    ,Manifest.permission.ACCESS_FINE_LOCATION
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

    public void openWifiSettings(View view) {
        startActivity(new Intent(this,WifiSettingsActivity.class));
    }

    public void testLifeActivity(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }
}