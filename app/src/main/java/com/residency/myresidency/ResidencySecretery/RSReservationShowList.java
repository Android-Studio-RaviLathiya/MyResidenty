package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.residency.myresidency.R;

import java.util.ArrayList;

public class RSReservationShowList extends AppCompatActivity {


    RecyclerView rv;
    FloatingActionButton add_reservation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_reservation_show_list);


        add_reservation = findViewById(R.id.add_reservation);
        rv = findViewById(R.id.rv);


        add_reservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSReservationShowList.this, RSReservationAdd.class));

            }
        });


        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && add_reservation.getVisibility() == View.VISIBLE) {
                    add_reservation.hide();
                } else if (dy < 0 && add_reservation.getVisibility() != View.VISIBLE) {
                    add_reservation.show();
                }
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
