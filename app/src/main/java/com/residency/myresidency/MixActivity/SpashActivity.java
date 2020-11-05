package com.residency.myresidency.MixActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;

import com.residency.myresidency.R;

public class SpashActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash);

        logo = findViewById(R.id.logo);
        MyPrefrence.setSelected_Language("-1");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                Intent intent = new Intent(SpashActivity.this, UserAuthenticationActivity.class);

                Pair[] pairs = new Pair[1];
                pairs[0] = new Pair<View, String>(logo, "logo");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation(SpashActivity.this, pairs);
                    startActivity(intent, activityOptions.toBundle());
                }

            }
        }, 1000);
    }
}
