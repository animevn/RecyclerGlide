package com.haanhgs.recyclerglidedemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.haanhgs.recyclerglidedemo.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.tbrDetail)
    Toolbar tbrDetail;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.tvDetailTitle)
    TextView tvDetailTitle;
    @BindView(R.id.tvDetailInfo)
    TextView tvDetailInfo;
    @BindView(R.id.tvContent)
    TextView tvContent;

    private void setToolBar(){
        setSupportActionBar(tbrDetail);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Hahahahahaha");
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void updateViews(){
        Intent intent = getIntent();
        tvDetailTitle.setText(intent.getStringExtra("title"));
        tvDetailInfo.setText(intent.getStringExtra("info"));
        int id = intent.getIntExtra("img", 0);
        Glide.with(this).load(id).into(imageView);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setToolBar();
        updateViews();
    }
}
