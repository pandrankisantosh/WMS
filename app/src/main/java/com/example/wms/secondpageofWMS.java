package com.example.wms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class secondpageofWMS extends AppCompatActivity
{
    private Button user_reg_btn;
    private Button user_login_btn;
    private Button admin_login_btn;
    private  Button collecter_login_btn;
    private  Button back_btn_1;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpageof_wms);
        user_reg_btn=findViewById(R.id.userregister);
        user_login_btn=findViewById(R.id.userlogin);
        admin_login_btn=findViewById(R.id.adminlogin);
        collecter_login_btn=findViewById(R.id.collecterlogin);
        back_btn_1=findViewById(R.id.backbutton1);
        user_reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),userregestrationpageofwms.class);
                startActivity(intent);
                finish();

            }
        });
        user_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),userloginpageofwms.class);
                startActivity(intent);
                finish();

            }
        });
        admin_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),adminloginpageofwms.class);
                startActivity(intent);
                finish();

            }
        });
        collecter_login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),collecterloginpageofwms.class);
                startActivity(intent);
                finish();

            }
        });
        back_btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}