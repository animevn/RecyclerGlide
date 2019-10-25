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

    private TextView tvTitle;
    private TextView tvInfo;
    private TextView tvContent;
    private ImageView ivDetail;

    private void initViews(){
        tvTitle = findViewById(R.id.tvDetailTitle);
        tvInfo = findViewById(R.id.tvDetailInfo);
        tvContent = findViewById(R.id.tvContent);
        ivDetail = findViewById(R.id.imageView);
    }

    private void handleHeader(){
        Toolbar tbrDetail = findViewById(R.id.tbrDetail);
        setSupportActionBar(tbrDetail);

        //show back arrow when in child activity
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void updateViews(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O){
            tvContent.setJustificationMode(Layout.JUSTIFICATION_MODE_INTER_WORD);
        }
        Intent intent = getIntent();
        tvTitle.setText(intent.getStringExtra("title"));
        tvInfo.setText(intent.getStringExtra("info"));
        int id = intent.getIntExtra("img", 0);
        Glide.with(this).load(id).into(ivDetail);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();
        handleHeader();
        updateViews();
    }
}
