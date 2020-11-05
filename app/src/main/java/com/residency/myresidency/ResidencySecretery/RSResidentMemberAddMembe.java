package com.residency.myresidency.ResidencySecretery;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.residency.myresidency.R;

public class RSResidentMemberAddMembe extends AppCompatActivity implements TextToSpeech.OnInitListener {

    EditText et_firstname, et_mobilenumber,et_lastname,et_wing_name,flat_no;
    Button btn_next;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rs_resident_member_add_membe);

        et_firstname = findViewById(R.id.et_firstname);
        et_mobilenumber = findViewById(R.id.et_mobilenumber);
        et_lastname = findViewById(R.id.et_lastname);
        et_wing_name = findViewById(R.id.et_wing_name);
        flat_no = findViewById(R.id.flat_no);

        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onBackPressed();
                String str=  et_firstname.getText().toString();
                tts.speak(str, TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        Intent i =new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, 1);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
            {
                tts= new TextToSpeech(this,this);
            }
            else
            {
                Intent i=new Intent();
                i.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(i);
            }
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if(status==TextToSpeech.SUCCESS)
        {
            Toast.makeText(getApplicationContext(), "engine installed",1000).show();
        }
        if(status==TextToSpeech.ERROR)
        {
            Toast.makeText(getApplicationContext(), "engine not installed", 1000).show();
        }
    }

    public void back(View view) {
        onBackPressed();
    }
}
