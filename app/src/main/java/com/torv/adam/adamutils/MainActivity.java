package com.torv.adam.adamutils;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.torv.adam.utils.log.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        L.d("LifeCycle");
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
}
