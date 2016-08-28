package com.hejunlin.superindicator;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hejunlin.superindicatorlibray.LoopViewPager;
import com.hejunlin.superindicatorlibray.CircleIndicator;
/**
 * Created by hejunlin on 2016/8/25.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoopViewPager viewpager = (LoopViewPager) findViewById(R.id.viewpager);
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        viewpager.setAdapter(new PicAdapter(MainActivity.this));
        viewpager.setLooperPic(true);
        indicator.setViewPager(viewpager);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
