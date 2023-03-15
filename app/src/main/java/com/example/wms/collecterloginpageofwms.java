package com.example.wms;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class collecterloginpageofwms extends AppCompatActivity
{
    private Button back_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collecterloginpageofwms);
        back_btn= findViewById(R.id.backbutton1);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),secondpageofWMS.class);
                startActivity(intent);
                finish();
            }
        });
    }
}