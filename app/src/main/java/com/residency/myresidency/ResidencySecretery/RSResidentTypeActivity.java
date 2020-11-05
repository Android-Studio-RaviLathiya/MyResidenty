package com.residency.myresidency.ResidencySecretery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.residency.myresidency.R;

public class RSResidentTypeActivity extends AppCompatActivity {

    CardView card_flat,card_rowhouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_resident_type);

        card_flat = findViewById(R.id.card_flat);
        card_rowhouse = findViewById(R.id.card_rowhouse);



        card_flat.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                startActivity(new Intent(RSResidentTypeActivity.this, RSResidentInfoAddActivity.class));
            }
        });
        card_rowhouse.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {


                startActivity(new Intent(RSResidentTypeActivity.this, RSResidentInfoAddActivity.class));




            }
        });

    }

    public void back(View view) {
        onBackPressed();
//        startActivity(new Intent(RegistrationsMainActivity.this,ResidentTypeActivity.class));

    }
}
