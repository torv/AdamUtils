package com.torv.adam.adamutils;

import android.Manifest;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.torv.adam.utils.log.L;
import com.torv.adam.utils.permission.PermissionTool;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String[] PERMISSIONS = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_PHONE_STATE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.d("LifeCycle");

        if(PermissionTool.checkNeedRequestPermission(PERMISSIONS)) {
            PermissionTool.requestPermission(MainActivity.this, PERMISSIONS);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        L.d("LifeCycle");
    }

    @Override
    protected void onResume() {
        super.onResume();
        L.d("LifeCycle");
    }

    @Override
    protected void onPause() {
        super.onPause();
        L.d("LifeCycle");
    }

    @Override
    protected void onStop() {
        super.onStop();
        L.d("LifeCycle");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        L.d("LifeCycle");
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        L.d("LifeCycle");
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionTool.handleGrantResult(requestCode, permissions, grantResults, new PermissionTool.IGrantResultCallback() {
            @Override
            public void onGrantedPermissions(List<String> grantedPermissions) {
                L.d(grantedPermissions.toString());
            }

            @Override
            public void onDeniedPermissions(List<String> deniedPermissions) {
                L.d(deniedPermissions.toString());
            }
        });
    }
}
