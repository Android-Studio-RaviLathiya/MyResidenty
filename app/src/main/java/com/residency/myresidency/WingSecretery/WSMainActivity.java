package com.residency.myresidency.WingSecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.residency.myresidency.R;
import com.residency.myresidency.ResidencySecretery.RSAnnounementShowList;
import com.residency.myresidency.ResidencySecretery.RSComplainShowList;
import com.residency.myresidency.ResidencySecretery.RSFundShowList;
import com.residency.myresidency.ResidencySecretery.RSResidentMemberShowList;

public class WSMainActivity extends AppCompatActivity {

    CardView  resident_member_list, fund_list, complain_list, announements_list;
    CollapsingToolbarLayout toolbar_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ws_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar_layout =  findViewById(R.id.toolbar_layout);
        setSupportActionBar(toolbar);

        toolbar_layout.setTitle("Wing Name");

        resident_member_list = findViewById(R.id.resident_member_list);
        fund_list = findViewById(R.id.fund_list);
        complain_list = findViewById(R.id.complain_list);
        announements_list = findViewById(R.id.announements_list);



        resident_member_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WSMainActivity.this, RSResidentMemberShowList.class));

            }
        });

        fund_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WSMainActivity.this, RSFundShowList.class));

            }
        });

        complain_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WSMainActivity.this, RSComplainShowList.class));

            }
        });

        announements_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WSMainActivity.this, RSAnnounementShowList.class));

            }
        });


    }
}
