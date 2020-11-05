package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.residency.myresidency.R;

public class RSWingSecretaryShowList extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton add_liwing_secretary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_wing_secretary_show_list);

        add_liwing_secretary = findViewById(R.id.add_liwing_secretary);
        rv = findViewById(R.id.rv);


        add_liwing_secretary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSWingSecretaryShowList.this, RSWingSecretaryAddMember.class));

            }
        });




    }

    public void back(View view) {
        onBackPressed();
    }
}
