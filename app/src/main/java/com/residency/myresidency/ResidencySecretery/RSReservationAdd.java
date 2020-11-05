package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.residency.myresidency.R;

import java.util.ArrayList;
import java.util.Calendar;

public class RSReservationAdd extends AppCompatActivity {

    EditText et_reservation_other, et_reservation_date;
    Button btn_next;
    LottieAnimationView btn_date_picker;
    Spinner sp_reservation;
    ArrayList<String> reservation = new ArrayList<>();
    int d, m, y;
    int H, M, S;
    Calendar calendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_reservation_add);


        sp_reservation = findViewById(R.id.sp_reservation);
        et_reservation_other = findViewById(R.id.et_reservation_other);
        et_reservation_date = findViewById(R.id.et_reservation_date);
        btn_date_picker = findViewById(R.id.btn_date_picker);
        btn_next = findViewById(R.id.btn_next);

        /*SPINNER*/
        spinner();
        /*DATE PICKER*/
        date();


        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });

    }

    private void date() {

        btn_date_picker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                y = calendar.get(Calendar.YEAR);
                m = calendar.get(Calendar.MONTH);
                d = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(RSReservationAdd.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        et_reservation_date.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, y, m, d);

                datePickerDialog.show();

            }
        });


    }


    private void spinner() {
        reservation.add("" + getResources().getString(R.string.reservation_one));
        reservation.add("" + getResources().getString(R.string.reservation_two));
        reservation.add("" + getResources().getString(R.string.reservation_three));

//        for (int i = 0; i < reservation.size(); i++) {
//            Log.e("corde", "fund" + reservation.get(i));
//        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RSReservationAdd.this, R.layout.support_simple_spinner_dropdown_item, reservation);
        sp_reservation.setAdapter(arrayAdapter);

        sp_reservation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(RSReservationAdd.this, "" + reservation.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
