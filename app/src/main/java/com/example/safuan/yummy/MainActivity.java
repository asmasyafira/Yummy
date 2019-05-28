package com.example.safuan.yummy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.safuan.yummy.Adapter.GridMenuAdapter;
import com.example.safuan.yummy.Adapter.ListMenuAdapter;
import com.example.safuan.yummy.Model.Yummy;
import com.example.safuan.yummy.Resource.YummyData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Yummy> yummies = new ArrayList<>();
    private String title = "Yummy";

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_grid:
                showRecyclerGrid();
                setActionBarTitle("Gambar Menu");
                break;
            case R.id.action_list:
                showRecyclerList();
                setActionBarTitle("Menu");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            rvCategory = findViewById(R.id.rv_yummyFood);
            rvCategory.setHasFixedSize(true);


            yummies.addAll(YummyData.getListData());
            showRecyclerGrid();
            showRecyclerList();


    }



    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMenuAdapter listMenuAdapter = new ListMenuAdapter(this);
        listMenuAdapter.setListYummy(yummies);
        rvCategory.setAdapter(listMenuAdapter);


    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this,3));
        GridMenuAdapter cardViewHeroAdapter = new GridMenuAdapter(this);
        cardViewHeroAdapter.setYummies(yummies);
        rvCategory.setAdapter(cardViewHeroAdapter);
    }
}
