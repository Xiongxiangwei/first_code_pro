package com.code.first.sql_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedWriter;

public class MainActivity
        extends AppCompatActivity
{

    private BufferedWriter mBufferedWriter;

    private String mFileString;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.click);


    }

}
