package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.residency.myresidency.R;

public class RSWingSecretaryAddMember extends AppCompatActivity {

    EditText et_firstname, et_mobilenumber,et_lastname,et_wing_name;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_wing_secretary_add);

        et_firstname = findViewById(R.id.et_firstname);
        et_mobilenumber = findViewById(R.id.et_mobilenumber);
        et_lastname = findViewById(R.id.et_lastname);
        et_wing_name = findViewById(R.id.et_wing_name);

        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
