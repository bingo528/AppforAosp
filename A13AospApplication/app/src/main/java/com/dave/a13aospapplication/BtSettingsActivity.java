package com.dave.a13aospapplication;

import static android.app.PendingIntent.getActivity;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.Manifest;
import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BtSettingsActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "BtSettingsActivity";
    final int REQUEST_CODE = 1;
    final int REQUEST_ENABLE_BT  = 555;
    int REQUEST_DISABLE_BT  = 666;
    BluetoothAdapter mBluetoothAdapter;
    ToggleButton mOperateBt;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mContext = this;
        setContentView(R.layout.activity_bt_settings);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        mOperateBt = (ToggleButton) findViewById(R.id.operateBt);
        mOperateBt.setOnCheckedChangeListener(this);

    }


    /**
     * 操作蓝牙 开关
     * @param btAction
     * @param REQUEST_BT_CODE
     */
    public void operateBt(String btAction,int REQUEST_BT_CODE) {
        Intent intent = new Intent(btAction);
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BLUETOOTH_CONNECT},REQUEST_CODE);
        }
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            startActivityForResult(intent, REQUEST_BT_CODE);
        }else if(mBluetoothAdapter.isEnabled()){
            startActivityForResult(intent, REQUEST_BT_CODE);
        }

    }
    //在利用 onActivityResult方法
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_ENABLE_BT == requestCode) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "打开蓝牙失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "蓝牙已开启", Toast.LENGTH_SHORT).show();
            }
        } else if (REQUEST_DISABLE_BT  == requestCode) {
            if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "打开蓝牙失败", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "蓝牙已开启", Toast.LENGTH_SHORT).show();
            }
        }

    }
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length != 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            } else {
                Toast.makeText(this, "权限开启失败", Toast.LENGTH_LONG).show();
            }
        }
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Log.d(TAG,"onCheckedChanged isChecked="+isChecked);
        //关闭
        if (isChecked){
            //TODO 关闭现在还有问题 20241113
            //operateBt(BluetoothAdapter.ACTION_REQUEST_DISABLE,REQUEST_DISABLE_BT);
            //mBluetoothAdapter.disable();
            Toast.makeText(mContext,"关闭还有问题待调试",Toast.LENGTH_SHORT).show();
        }else {
            operateBt(BluetoothAdapter.ACTION_REQUEST_ENABLE,REQUEST_ENABLE_BT);
        }
    }
}