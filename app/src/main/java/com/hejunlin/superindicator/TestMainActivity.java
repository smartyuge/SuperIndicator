package com.hejunlin.superindicator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Created by hejunlin on 2016/9/5.
 */
public class TestMainActivity extends AppCompatActivity {

    private Button mCommonViewButton;
    private Button mScrollViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);
        mCommonViewButton = (Button) findViewById(R.id.bt_common);
        mScrollViewButton = (Button) findViewById(R.id.bt_scroll);
        mScrollViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMainActivity.this, TestScrollViewActivity.class);
                startActivity(intent);
            }
        });
        mCommonViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestMainActivity.this, TestCommonViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
