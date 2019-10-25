package com.haanhgs.recyclerglidedemo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar tbrDetail = findViewById(R.id.tbrDetail);
        setSupportActionBar(tbrDetail);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView tvTitle = findViewById(R.id.tvDetailTitle);
        TextView tvInfo = findViewById(R.id.tvDetailInfo);
        TextView tvContent = findViewById(R.id.tvContent);
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            tvContent.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        ImageView ivDetail = findViewById(R.id.imageView);

        Intent intent = getIntent();
        tvTitle.setText(intent.getStringExtra("title"));
        tvInfo.setText(intent.getStringExtra("info"));


        int id = intent.getIntExtra("img", 0);
        Glide.with(this).load(id).into(ivDetail);

    }

}
