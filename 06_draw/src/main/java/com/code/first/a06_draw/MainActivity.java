package com.code.first.a06_draw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity
        extends AppCompatActivity implements View.OnClickListener
{

    private TextView mTvAvatar;
    private TextView mTvDash;
    private TextView mTvImageText;
    private TextView mTvPie;
    private TextView mTvSport;
    private Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvAvatar = findViewById(R.id.tv_avatar);
        mTvDash = findViewById(R.id.tv_dash);
        mTvImageText = findViewById(R.id.tv_image_text);
        mTvPie = findViewById(R.id.tv_pie);
        mTvSport = findViewById(R.id.tv_sport);
        mTvAvatar.setOnClickListener(this);
        mTvDash.setOnClickListener(this);
        mTvImageText.setOnClickListener(this);
        mTvPie.setOnClickListener(this);
        mTvSport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (mIntent==null){
            mIntent = new Intent(MainActivity.this, SkipActivity.class);
        }
        switch (v.getId()) {
            case R.id.tv_avatar:
                 mIntent.putExtra("type","0");
                 startActivity(mIntent);
                 break;
            case R.id.tv_dash:
                mIntent.putExtra("type","1");
                startActivity(mIntent);
                break;
            case R.id.tv_image_text:
                mIntent.putExtra("type","2");
                startActivity(mIntent);
                break;
            case R.id.tv_pie:
                mIntent.putExtra("type","3");
                startActivity(mIntent);
                break;
            case R.id.tv_sport:
                mIntent.putExtra("type","4");
                startActivity(mIntent);
                break;
            default:
                 break;
        }

    }
}
