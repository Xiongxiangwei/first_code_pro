package com.code.first.a06_draw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SkipActivity
        extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skip);
        String type = getIntent().getStringExtra("type");
    }
}
