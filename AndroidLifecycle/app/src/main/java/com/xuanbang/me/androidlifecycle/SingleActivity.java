package com.xuanbang.me.androidlifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;


/**
 * ========== SINGLE ACTIVITY ==========
 *
 * Trường hợp 1: là bấm nút back (pressback mặc định) thì vòng đời Android
 * onCreate(null) -> onStart() -> onResume() -> [..Press Back..or call method Activity.finish()] -> onPause() -> onStop() -> onDestroy().
 * {.....} onCreate(null) -> onStart() -> onResume().
 * <p>
 * Trường hợp 2: bấm vào phím Home
 * onCreate(null) -> onStart() -> onResume() -> [..Button Home or minimize app] -> onPause() -> onStop().
 * {....} onRestart() -> onStart() -> onResume().
 *
 *
 */
public class SingleActivity extends Activity {

    private final static String TAG = SingleActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        Log.e(TAG, "onCreate()");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy()");
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e(TAG, "onSaveInstanceState() - PersistableBundle");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(TAG, "onSaveInstanceState()");
    }


    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
        Log.e(TAG, "onRestoreInstanceState() - PersistableBundle");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState()");
    }
}
