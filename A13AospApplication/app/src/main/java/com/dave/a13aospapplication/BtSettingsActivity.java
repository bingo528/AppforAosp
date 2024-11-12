package com.dave.a13aospapplication;

import static android.app.PendingIntent.getActivity;
import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BtSettingsActivity extends AppCompatActivity {
    private static final String TAG = "BtSettingsActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bt_settings);

    }



    @SuppressLint("MissingPermission")
    public void openBt(View view) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean adapterEnabled = defaultAdapter.isEnabled();
        boolean enable = defaultAdapter.enable();
        Log.d(TAG,"openBt 2222 enable="+enable+",adapterEnabled="+adapterEnabled);
    }
}