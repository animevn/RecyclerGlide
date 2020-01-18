package com.haanhgs.recyclerglidedemo.view;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.haanhgs.recyclerglidedemo.R;
import androidx.annotation.Nullable;
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



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

    }
}
