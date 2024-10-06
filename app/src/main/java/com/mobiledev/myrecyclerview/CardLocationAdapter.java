package com.mobiledev.myrecyclerview;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.ArrayList;

public class CardLocationAdapter extends RecyclerView.Adapter<CardLocationAdapter.CardViewHolder> {
    private ArrayList<Lokasi> listlokasi;
    private  ArrayList<Lokasi> listfavorit;
    private Context context;

    public CardLocationAdapter(Context context, ArrayList<Lokasi> listlokasi) {
        this.context = context;
        this.listlokasi = listlokasi;
        this.listfavorit = new ArrayList<>();
    }

    public CardLocationAdapter(MainActivity context, ArrayList<Location> listLokasi) {

    }

    @NonNull
    @Override
    public CardLocationAdapter.CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_lokasi, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Lokasi lokasi = listlokasi.get(position);
        holder.txtTitle.setText(lokasi.getNama());
        holder.txtDesc.setText(lokasi.getDesc());

        holder.txtDesc.setOnClickListener(v -> {
            if (holder.txtDesc.getMaxLines() == 2){
                holder.txtDesc.setMaxLines(Integer.MAX_VALUE);
            }else {
                holder.txtDesc.setMaxLines(2);
            }
        });

        Glide.with(context).load(lokasi.getImg())
                .into(holder.imgList);

        if(listfavorit.contains(lokasi)){
            holder.imgBtnStar.setImageResource(R.drawable.heart);
        }else {
            holder.imgBtnStar.setImageResource(R.drawable.heartoutline);
        }

        holder.imgBtnStar.setOnClickListener(v -> {
            if (listfavorit.contains(lokasi)){
                listfavorit.remove(lokasi);
                holder.imgBtnStar.setImageResource(R.drawable.heartoutline);
            }else {
                listfavorit.add(lokasi);
                holder.imgBtnStar.setImageResource(R.drawable.heart);
            }
            saveFavorites();
        });
    }



    private void saveFavorites() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("FAVORITES",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(listfavorit);
        editor.putString("favorites",json);
        editor.apply();
    }

    @Override
    public int getItemCount() {
        return listlokasi.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgList, imgBtnStar;
        TextView txtTitle, txtDesc;
        public CardViewHolder(View itemView) {
            super(itemView);
            imgList = itemView.findViewById(R.id.img_list);
            imgBtnStar = itemView.findViewById(R.id.imgBtnStar);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDesc = itemView.findViewById(R.id.txtDesc);
        }
    }
}
