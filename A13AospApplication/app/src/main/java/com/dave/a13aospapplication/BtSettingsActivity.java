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
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BtSettingsActivity extends AppCompatActivity {
    private static final String TAG = "BtSettingsActivity";
    final int REQUEST_CODE = 1;
    final int REQUEST_ENABLE_BT  = 555;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt_settings);

    }



    @SuppressLint("MissingPermission")
    public void openBt(View view) {
        openBt();
    }
    public void openBt() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.BLUETOOTH_CONNECT},REQUEST_CODE);
        }
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, REQUEST_ENABLE_BT);
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

}