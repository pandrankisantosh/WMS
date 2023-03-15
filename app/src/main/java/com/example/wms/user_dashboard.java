package com.example.wms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class user_dashboard extends AppCompatActivity
{
    private ImageView imageView;
     private  Button back_btn;
     private TextView user_name;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_dashboard);
        //image data
        imageView=findViewById(R.id.user_profile_pic);
        user_name=findViewById(R.id.user_fullname);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.drawable.userloginlogo);
        RoundedBitmapDrawable roundedBitmapDrawable= RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);

        back_btn=findViewById(R.id.backbtnofuserdashboard);
        back_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(user_dashboard.this,secondpageofWMS.class);
                startActivity(intent);
                finish();

            }
        });
    }
}