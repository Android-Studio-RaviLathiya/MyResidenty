package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.residency.myresidency.R;

import static android.graphics.Color.BLACK;

public class RSPasnalInfoActivity extends AppCompatActivity {


    Button btn_next;
    EditText et_mobilenumber, et_firstname, et_lastname, et_email;
    String mobilenumber, firstname, lastname, email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_pasnal_info);

        btn_next = findViewById(R.id.btn_next);
        et_mobilenumber = findViewById(R.id.et_mobilenumber);
        et_lastname = findViewById(R.id.et_lastname);
        et_firstname = findViewById(R.id.et_firstname);
        et_email = findViewById(R.id.et_email);

        firstname = et_firstname.getText().toString().trim();
        lastname = et_lastname.getText().toString().trim();
        mobilenumber = et_mobilenumber.getText().toString().trim();
        email = et_email.getText().toString().trim();


        et_firstname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (et_firstname.length() == 0) {

                    et_firstname.setError("Enter Name");
                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_lastname.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_email.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_mobilenumber.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else {

                    btn_next.setBackgroundColor(Color.BLACK);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        et_lastname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @SuppressLint("ResourceAsColor")
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (et_firstname.length() == 0) {

                    et_firstname.setError("Enter Name");
                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_lastname.length() == 0) {
                    et_mobilenumber.setError("Enter Last name");


                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_email.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_mobilenumber.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else {

                    btn_next.setBackgroundColor(Color.BLACK);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (et_firstname.length() == 0) {

                    et_firstname.setError("Enter Name");
                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_lastname.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_mobilenumber.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_email.length() == 0) {

                    et_email.setError("Enter Email ");

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                }

//                else if (!email.matches(emailPattern)) {
//
//                    et_email.setError("Email Not Valid");
//                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));
//
//                }

                else {

                    btn_next.setBackgroundColor(Color.BLACK);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_mobilenumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (et_firstname.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_lastname.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_email.length() == 0) {

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else if (et_mobilenumber.length() == 0) {

                    et_mobilenumber.setError("Enter Mobile Number");

                    btn_next.setBackgroundColor(getResources().getColor(R.color.appcolor));


                } else {

                    btn_next.setBackgroundColor(Color.BLACK);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                if (lastname.isEmpty()) {
//
//                    et_lastname.setError("Enter Last Name");
//
//                } else if (mobilenumber.isEmpty()) {
//
//                    et_mobilenumber.setError("Enter Mobile NUmber");
//
//                } else if (email.isEmpty()) {
//
//                    et_email.setError("Enter Email");
//
//                } else if (!email.matches(emailPattern)) {
//
//                    et_email.setError("Not Valide Email");
//
//                } else {
//
//                    btn_next.setBackgroundColor(Color.BLACK);
                    startActivity(new Intent(RSPasnalInfoActivity.this, RSMainActivity.class));
//
//                }


            }
        });


    }

    public void back(View view) {
        onBackPressed();
//        startActivity(new Intent(RegistrationsMainActivity.this,ResidentTypeActivity.class));

    }
}
