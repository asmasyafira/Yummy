package com.example.safuan.yummy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.safuan.yummy.Model.Yummy;

import java.util.ArrayList;

public class DetailListActivity extends AppCompatActivity {


    TextView tvNameMen, tvNameDes;
    ImageView imgmen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        tvNameMen = findViewById(R.id.namaMen);
        tvNameDes = findViewById(R.id.descMen);
        imgmen = findViewById(R.id.imgMen);

        tvNameMen.setText(getIntent().getStringExtra("name_food"));

        Glide.with(this).load("photo").apply(new RequestOptions().override(250,300))
                .into(imgmen);

        tvNameDes.setText(getIntent().getStringExtra("desc_food"));
    }
}
