package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.residency.myresidency.R;

public class RSFundShowList extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton add_fund;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_fund_show_list);


        add_fund = findViewById(R.id.add_fund);
        rv = findViewById(R.id.rv);

add_fund.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(RSFundShowList.this,RSFundAdd.class));
    }
});




        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && add_fund.getVisibility() == View.VISIBLE) {
                    add_fund.hide();

                } else if (dy < 0 && add_fund.getVisibility() != View.VISIBLE) {
                    add_fund.show();
                }
            }
        });
    }

    public void back(View view) {
        onBackPressed();
    }
}
