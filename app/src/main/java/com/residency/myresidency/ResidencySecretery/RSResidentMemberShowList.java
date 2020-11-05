package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.residency.myresidency.R;

public class RSResidentMemberShowList extends AppCompatActivity {

    RecyclerView rv;
    FloatingActionButton add_resident_member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_resident_member_show_list);

        add_resident_member = findViewById(R.id.add_resident_member);
        rv = findViewById(R.id.rv);


        add_resident_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RSResidentMemberShowList.this, RSResidentMemberAddMembe.class));

            }
        });


        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && add_resident_member.getVisibility() == View.VISIBLE) {
                    add_resident_member.hide();
                } else if (dy < 0 && add_resident_member.getVisibility() != View.VISIBLE) {
                    add_resident_member.show();
                }
            }
        });

    }

    public void back(View view) {
        onBackPressed();
    }
}
