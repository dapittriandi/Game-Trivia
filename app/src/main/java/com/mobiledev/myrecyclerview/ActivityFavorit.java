package com.mobiledev.myrecyclerview;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ActivityFavorit extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CardLocationAdapter favoritAdapter;
    private ArrayList<Lokasi> listFavorit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favorit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.rvFavorit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadFavorites();
        favoritAdapter = new CardLocationAdapter(this,listFavorit);
        recyclerView.setAdapter(favoritAdapter);


    }

    private void loadFavorites(){
        SharedPreferences sharedPreferences = getSharedPreferences("FAVORITES", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("favorites",null);
        Type type = new TypeToken<ArrayList<Lokasi>>(){}.getType();
        listFavorit = gson.fromJson(json,type);
        if (listFavorit == null){
            listFavorit = new ArrayList<>();
        }
    }
}