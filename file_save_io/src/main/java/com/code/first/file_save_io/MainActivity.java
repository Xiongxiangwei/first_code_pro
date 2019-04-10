package com.code.first.file_save_io;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    private String mSvaeStr;
    private BufferedWriter mWriter;
    private BufferedReader mBufferedReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View   viewById = findViewById(R.id.click);
        String str="file save success";
        save(str);
        mSvaeStr = getSvaeStr();
        viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, mSvaeStr, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private String getSvaeStr() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream inputStream    = openFileInput("temp_file");
            mBufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String          line           ="";
            while ((line= mBufferedReader.readLine())!=null){
                stringBuilder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (mBufferedReader!=null){
                    mBufferedReader.close();
                }
            }catch (Exception e){

            }

        }
        return  stringBuilder.toString();
    }

    private void save(String str) {
        try {
            FileOutputStream output         = openFileOutput("temp_file", Context.MODE_PRIVATE);
            mWriter = new BufferedWriter(new OutputStreamWriter(output));
            mWriter.write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (mWriter!=null) {
                    mWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
