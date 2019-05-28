package com.example.safuan.yummy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.safuan.yummy.DetailMenuActivity;
import com.example.safuan.yummy.Model.Yummy;
import com.example.safuan.yummy.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListMenuAdapter extends RecyclerView.Adapter<ListMenuAdapter.ListViewHolder> {
    private Context context;
    private ArrayList<Yummy> listYummy;


    public ListMenuAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Yummy> getListYummy() {
        return listYummy;
    }

    public void setListYummy(ArrayList<Yummy> listYummy) {
        this.listYummy = listYummy;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int a) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_menu_layout,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        final Yummy yummy = listYummy.get(i);
        listViewHolder.tvName.setText(getListYummy().get(i).getName());

        Glide.with(context).load(getListYummy().get(i).getPhoto()).apply(new RequestOptions().override(55,55))
                .into(listViewHolder.imgPhoto);

        listViewHolder.bind(listYummy.get(i));

            }



    @Override
    public int getItemCount() {
        return getListYummy().size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder  {
        TextView tvName;
        ImageView imgPhoto;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);


            tvName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), DetailMenuActivity.class);
                    context.startActivity(i);
                }
            });
            imgPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(), DetailMenuActivity.class);
                    context.startActivity(i);
                }
            });


    }

        public void bind(Yummy yummy) {
            Intent intentA = new Intent(itemView.getContext().getApplicationContext(), DetailMenuActivity.class);
            intentA.putExtra("name_food",yummy.getName());
            intentA.putExtra("photo",yummy.getPhoto());
            intentA.putExtra("desc_food",yummy.getDescription());
        }
    }
}
