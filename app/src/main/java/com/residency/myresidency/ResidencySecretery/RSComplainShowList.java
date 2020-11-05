package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.residency.myresidency.R;

public class RSComplainShowList extends AppCompatActivity {

    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_complain_show_list);

        rv = findViewById(R.id.rv);


    }

    public void back(View view) {
        onBackPressed();
    }
}
