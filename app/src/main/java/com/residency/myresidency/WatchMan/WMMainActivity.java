package com.residency.myresidency.WatchMan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.residency.myresidency.R;

import java.util.ArrayList;

public class WMMainActivity extends AppCompatActivity {

    CollapsingToolbarLayout toolbar_layout;
    RecyclerView rv;
    ArrayList<DaynemicItem> daynemicItems = new ArrayList<>();
    DaynemicAdapter daynemicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wm_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        rv = findViewById(R.id.rv);
        toolbar_layout =  findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        toolbar_layout.setTitle("Name");



        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        rv.setLayoutManager(linearLayoutManager);

        daynemicItems.clear();

        daynemicItems.add(new DaynemicItem("1", "A1"));
        daynemicItems.add(new DaynemicItem("2", "A2"));
        daynemicItems.add(new DaynemicItem("3", "B2"));
        daynemicItems.add(new DaynemicItem("4", "B1"));
        daynemicItems.add(new DaynemicItem("5", "C"));


        daynemicAdapter = new DaynemicAdapter(daynemicItems, this);
        rv.setAdapter(daynemicAdapter);




//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setLogo(R.drawable.bungalow);
//        getSupportActionBar().setSubtitle("sutitle");
//        toolbar.setSubtitle("sadfgvfv");
    }
}
