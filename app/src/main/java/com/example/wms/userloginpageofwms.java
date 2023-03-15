package com.example.wms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class userloginpageofwms extends AppCompatActivity
{
    //create object  database reference to access firebase realtime database https://wms1-9b8b8-default-rtdb.firebaseio.com
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wms1-9b8b8-default-rtdb.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userloginpageofwms);
       final Button back_btn=findViewById(R.id.backbutton1);
       final TextView user_signup_btn =findViewById(R.id.user_signup);
      final Button  login_now_btn=findViewById(R.id.user_login_now);

        //login input
       final EditText log_email_text=findViewById(R.id.login_email);
        final EditText log_pass_text = findViewById(R.id.login_pass);


        //back button for go back

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(userloginpageofwms.this,secondpageofWMS.class);
                startActivity(intent);
                finish();
            }
        });

        //re direct to registration page when he/she has a new user

        user_signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(userloginpageofwms.this,userregestrationpageofwms.class);
                startActivity(intent);
                finish();
            }
        });
        //login code
        login_now_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final String email_data = log_email_text.getText().toString();
                final String pass_data=log_pass_text.getText().toString();
                if(email_data.isEmpty() || pass_data.isEmpty())
                {
                    Toast.makeText(userloginpageofwms.this, "enter email or password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                   databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener()
                   {
                       @Override
                       public void onDataChange(@NonNull DataSnapshot snapshot)
                       {
                           //check if email is exist in firebase or not
                           if(snapshot.hasChild(email_data))
                           {
                               //email is exist inthe firebase
                               // now get password of user form firebase and match with given password
                               final String getpassword=snapshot.child(email_data).child("password").getValue(String.class);


                               //if password matches with existing passwrod
                               if(getpassword.equals(pass_data))
                               {
                                   Toast.makeText(userloginpageofwms.this, "successfully logged in", Toast.LENGTH_SHORT).show();
                                   //open activity
                                   Intent intent=new Intent(userloginpageofwms.this,user_dashboard.class);
                                   startActivity(intent);
                                   finish();


                               }
                               else
                               {
                                   Toast.makeText(userloginpageofwms.this, "wrong passwrod entered", Toast.LENGTH_SHORT).show();
                               }
                           }
                           else
                           {
                               Toast.makeText(userloginpageofwms.this, "email not exist", Toast.LENGTH_SHORT).show();
                           }

                       }

                       @Override
                       public void onCancelled(@NonNull DatabaseError error) {

                       }
                   });
                }

            }
        });

    }
}