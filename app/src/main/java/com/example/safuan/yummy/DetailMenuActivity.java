package com.example.safuan.yummy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.safuan.yummy.Model.Yummy;
import com.example.safuan.yummy.Resource.YummyData;

import java.util.ArrayList;

public class DetailMenuActivity extends AppCompatActivity {
    String txtNama, txtDeskripsi, txtGambar;
    TextView tvNameMenu, tvNameDesc;
    ImageView imgmenu;
    private ArrayList<Yummy> yummies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_menu);

        tvNameMenu = findViewById(R.id.namaMenu);
        tvNameDesc = findViewById(R.id.descMenu);
        imgmenu = findViewById(R.id.imgMenu);

//        yummies.addAll(YummyData.getListData());

        tvNameMenu.setText(getIntent().getStringExtra("name_food"));

        Glide.with(this).load("photo").apply(new RequestOptions().override(250,300))
                .into(imgmenu);

        tvNameDesc.setText(getIntent().getStringExtra("desc_food"));


        }
}
