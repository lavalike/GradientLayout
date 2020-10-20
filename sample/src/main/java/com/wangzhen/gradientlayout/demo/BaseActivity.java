package com.wangzhen.gradientlayout.demo;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by wangzhen on 2017/6/23.
 */

public class BaseActivity extends AppCompatActivity {
    @CallSuper
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        ((ViewGroup) getWindow().getDecorView()).getChildAt(0).setFitsSystemWindows(false);
        View view = findViewById(R.id.action_bar_root);
        if (view != null) {
            view.setFitsSystemWindows(false);
        }
        super.onPostCreate(savedInstanceState);
    }
}
