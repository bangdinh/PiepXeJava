package com.xuanbang.me.piepxe.ui.nulls.views;

import android.content.Intent;
import android.os.Bundle;

import com.xuanbang.me.piepxe.R;
import com.xuanbang.me.piepxe.ui.main.views.MainActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NullMainActivity extends AppCompatActivity {

//    @Override
//    protected int layoutRes() {
//        return R.layout.activity_null_main;
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_null_main);
        startActivity(new Intent(this, MainActivity.class));
    }
}
