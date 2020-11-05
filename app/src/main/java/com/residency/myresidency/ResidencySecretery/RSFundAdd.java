package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.residency.myresidency.R;

import java.util.ArrayList;

public class RSFundAdd extends AppCompatActivity {

    EditText et_fund_type, et_fund_amount;
    Button btn_next;
    Spinner sp_fund;
    ArrayList<String> fundlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_fund_add);

        et_fund_type = findViewById(R.id.et_fund_type);
        et_fund_amount = findViewById(R.id.et_fund_amount);
        sp_fund = findViewById(R.id.sp_fund);

        btn_next = findViewById(R.id.btn_next);

        /*SPINNER*/
        spinner();



        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });


    }

    private void spinner() {

        fundlist.add(getResources().getString(R.string.fund_one));
        fundlist.add(getResources().getString(R.string.fund_two));
        fundlist.add(getResources().getString(R.string.fund_three));

//        for (int i = 0; i < fundlist.size(); i++) {
//            Log.e("corde", "fund" + fundlist.get(i));
//        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(RSFundAdd.this, R.layout.support_simple_spinner_dropdown_item, fundlist);
        sp_fund.setAdapter(arrayAdapter);
        sp_fund.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(RSFundAdd.this, "" + fundlist.get(position), Toast.LENGTH_SHORT).show();
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
