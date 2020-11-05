package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.residency.myresidency.R;

public class RSMainActivity extends AppCompatActivity {

    CardView wing_secetory_list, resident_member_list, fund_list, complain_list, announements_list, reservation_list;

    CollapsingToolbarLayout toolbar_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_main);

        wing_secetory_list = findViewById(R.id.wing_secetory_list);
        resident_member_list = findViewById(R.id.resident_member_list);
        fund_list = findViewById(R.id.fund_list);
        complain_list = findViewById(R.id.complain_list);
        announements_list = findViewById(R.id.announements_list);
        reservation_list = findViewById(R.id.reservation_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_layout =  findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        toolbar_layout.setTitle("Name");

        wing_secetory_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSMainActivity.this, RSWingSecretaryShowList.class));

            }
        });

        resident_member_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSMainActivity.this, RSResidentMemberShowList.class));

            }
        });

        fund_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSMainActivity.this, RSFundShowList.class));

            }
        });

        complain_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSMainActivity.this, RSComplainShowList.class));

            }
        });

        announements_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSMainActivity.this, RSAnnounementShowList.class));

            }
        });

        reservation_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSMainActivity.this, RSReservationShowList.class));

            }
        });


    }
}
