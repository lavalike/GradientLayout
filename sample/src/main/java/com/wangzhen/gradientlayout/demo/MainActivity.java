package com.wangzhen.gradientlayout.demo;

import android.os.Bundle;
import android.widget.SeekBar;

import com.wangzhen.gradientlayout.GradientLayout;

public class MainActivity extends BaseActivity implements SeekBar.OnSeekBarChangeListener {

    private GradientLayout gradientLayout;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gradientLayout = (GradientLayout) findViewById(R.id.gradientLayout);
        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(this);
        gradientLayout.setProgress(seekBar.getProgress());
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        gradientLayout.setProgress(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
