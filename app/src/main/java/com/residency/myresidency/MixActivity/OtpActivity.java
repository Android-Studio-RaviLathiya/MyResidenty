package com.residency.myresidency.MixActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.residency.myresidency.R;
import com.residency.myresidency.ResidentMembers.RMMainActivity;
import com.residency.myresidency.WatchMan.WMMainActivity;
import com.residency.myresidency.WingSecretery.WSMainActivity;

import in.aabhasjindal.otptextview.OtpTextView;

public class OtpActivity extends AppCompatActivity {

    OtpTextView et_otp;
    int click_counter;
    TextView tv_time, tv_resend_otp;
    String otp_click;
    Button btn_next;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        et_otp = findViewById(R.id.et_otp);
        tv_time = findViewById(R.id.tv_time);
        tv_resend_otp = findViewById(R.id.tv_resend_otp);
        btn_next = findViewById(R.id.btn_next);
        btn = findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(OtpActivity.this, WSMainActivity.class));

            }
        });


         btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OtpActivity.this, RMMainActivity.class));

            }
        });










         /*TIMER*/
            timer();

    }

    private void timer() {

        MyPrefrence.setotpsendclick("0");
        tv_time.setVisibility(View.VISIBLE);

        new CountDownTimer(61000, 1000) {

            public void onTick(long millisUntilFinished) {

                tv_time.setText("00:" + millisUntilFinished / 1000);
                if (millisUntilFinished < 11000) {

                    tv_time.setTextColor(Color.RED);
                } else {

                    tv_time.setTextColor(Color.BLACK);
                }

            }


            public void onFinish() {
//                tv_time.setText("Time Finish!");

                tv_time.setVisibility(View.GONE);
                tv_resend_otp.setVisibility(View.VISIBLE);

            }
        }.start();

        tv_resend_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (click_counter == 1) {

                    Toast toast = Toast.makeText(OtpActivity.this, "Please try again after sometime..", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }else {

                    /* OTP TIMER*/
                    new CountDownTimer(61000, 1000) {

                        public void onTick(long millisUntilFinished) {

                            tv_time.setText("00:" + millisUntilFinished / 1000);

                            if (millisUntilFinished < 11000) {

                                tv_time.setTextColor(Color.RED);
                            } else {

                                tv_time.setTextColor(Color.BLACK);
                            }

                        }


                        public void onFinish() {
//                tv_time.setText("Time Finish!");

                            tv_time.setVisibility(View.GONE);
                            tv_resend_otp.setVisibility(View.VISIBLE);

                        }
                    }.start();

                    tv_time.setVisibility(View.VISIBLE);
                    tv_resend_otp.setVisibility(View.GONE);

                    otp_click = MyPrefrence.getotpsendclick();
                    click_counter = Integer.parseInt(otp_click) + 1;

                    MyPrefrence.setotpsendclick("" + click_counter);

                }

            }
        });
    }

    public void wm(View view) {
        startActivity(new Intent(OtpActivity.this, WMMainActivity.class));
    }

    public void changenumber(View view) {
        onBackPressed();
    }

    public void back(View view) {
        onBackPressed();
    }
}
