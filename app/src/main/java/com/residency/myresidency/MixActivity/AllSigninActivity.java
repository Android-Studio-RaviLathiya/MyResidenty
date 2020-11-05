package com.residency.myresidency.MixActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.residency.myresidency.R;
import com.residency.myresidency.WingSecretery.WSMainActivity;

public class AllSigninActivity extends AppCompatActivity {

    EditText et_mobilenumber;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_signin);

        et_mobilenumber = findViewById(R.id.et_mobilenumber);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AllSigninActivity.this, OtpActivity.class));
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
