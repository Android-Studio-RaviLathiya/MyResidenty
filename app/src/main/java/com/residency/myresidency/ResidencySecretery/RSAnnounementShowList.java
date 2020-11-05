package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.residency.myresidency.R;

public class RSAnnounementShowList extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton add_ammouncent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_announement_show_list);


        add_ammouncent = findViewById(R.id.add_ammouncent);
        rv = findViewById(R.id.rv);


        add_ammouncent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSAnnounementShowList.this, RSAnnounementAdd.class));

            }
        });

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && add_ammouncent.getVisibility() == View.VISIBLE) {
                    add_ammouncent.hide();
                } else if (dy < 0 && add_ammouncent.getVisibility() != View.VISIBLE) {
                    add_ammouncent.show();
                }
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
