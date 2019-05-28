package com.example.safuan.yummy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.safuan.yummy.DetailMenuActivity;
import com.example.safuan.yummy.Model.Yummy;
import com.example.safuan.yummy.R;
import com.example.safuan.yummy.Resource.YummyData;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GridMenuAdapter extends RecyclerView.Adapter<GridMenuAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Yummy> yummies;

    public GridMenuAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Yummy> getYummies() {
        return yummies;
    }

    public void setYummies(ArrayList<Yummy> yummies) {
        this.yummies = yummies;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int a) {
        View view = LayoutInflater.from(viewGroup. getContext()).inflate(R.layout.grid_menu_layout, viewGroup,false);
        return new GridViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder gridViewHolder, int i) {
        Glide.with(context)
                .load(getYummies().get(i).getPhoto())
                .apply(new RequestOptions().override(350,550))
                .into(gridViewHolder.imageGrid);
        gridViewHolder.tvGrid.setText(getYummies().get(i).getName());
        gridViewHolder.bind(yummies.get(i));

    }

    @Override
    public int getItemCount() {
        return getYummies().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageGrid;
        TextView tvGrid;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageGrid = itemView.findViewById(R.id.img_grid_photo);
            tvGrid = itemView.findViewById(R.id.tv_grid_name);
            imageGrid.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent i = new Intent(v.getContext(), DetailMenuActivity.class);
            context.startActivity(i);

        }

        public void bind(Yummy yummy) {
            Intent intent = new Intent(itemView.getContext().getApplicationContext(), DetailMenuActivity.class);
            intent.putExtra("name_food",yummy.getName());
            intent.putExtra("photo", yummy.getPhoto());
        }
    }
}

