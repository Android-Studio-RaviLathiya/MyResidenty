package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.residency.myresidency.R;

import java.util.ArrayList;
import java.util.Locale;

public class RSAnnounementAdd extends AppCompatActivity {

    EditText et_announcent_note;
    Button btn_next;
    final int VOICE_CODE = 10;
    LottieAnimationView mic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_announement_add);

        et_announcent_note = findViewById(R.id.et_announcent_note);
        btn_next = findViewById(R.id.btn_next);
        mic = findViewById(R.id.mic);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


         mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                voice_to_text();
            }
        });






    }

    private void voice_to_text() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Announement Say Something!!");
        try {
            startActivityForResult(intent, VOICE_CODE);
        } catch (ActivityNotFoundException e) {

        }
    }

    // receive voice input and set it to textbox

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case VOICE_CODE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    et_announcent_note.setText(result.get(0));
                }
                break;
            }

        }
    }


    public void back(View view) {
        onBackPressed();
    }
}
