package com.code.first.sql_demo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        save("safe success");
        mFileString = getFileString();
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mFileString, Toast.LENGTH_LONG).show();
            }
        });

    }

    private String getFileString() {
        StringBuilder mStringBuilder=new StringBuilder();
        try {
            FileInputStream in           = openFileInput("data");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line="";
            while ((line=bufferedReader.readLine())!=null){
                mStringBuilder.append(line);
            }
//            while (bufferedReader.readLine()!=null){
//                mStringBuilder.append(bufferedReader.readLine());
            //多读了一次 readLine
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mStringBuilder.toString();
    }

    private void save( String str) {
        try {
            FileOutputStream output         =openFileOutput("data", Context.MODE_PRIVATE);
            mBufferedWriter = new BufferedWriter(new OutputStreamWriter(output));
            mBufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
                try {
                    if (mBufferedWriter!=null){
                    mBufferedWriter.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
