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


public class userregestrationpageofwms extends AppCompatActivity
{
    //create object  database reference to access firebase realtime database https://wms1-9b8b8-default-rtdb.firebaseio.com
  DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://wms1-9b8b8-default-rtdb.firebaseio.com");


 //  final Button back_btn;
   //final Button register_now_btn;
  // private TextView user_sign_in_btn;
  // private EditText  email_text,pass_text,fullname_text,phonenumber_text;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userregestrationpageofwms);
         final Button  back_btn=findViewById(R.id.backbutton1);
        final TextView user_sign_in_btn=findViewById(R.id.user_signin);
        final Button register_now_btn=findViewById(R.id.user_reg_now);


        //user input for registration

        final EditText  email_text=findViewById(R.id.email);
      final EditText pass_text=findViewById(R.id.password);
        final EditText fullname_text=findViewById(R.id.fullname);
       final EditText phonenumber_text=findViewById(R.id.mobilenumber);

        //back button code

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),secondpageofWMS.class);
                startActivity(intent);
                finish();
            }
        });
        //redirect to loginpage when he has already an account

        user_sign_in_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent=new Intent(getApplicationContext(),userloginpageofwms.class);
                startActivity(intent);
                finish();

            }
        });
        //for user registration

       register_now_btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //get data form Edittexts into string variable
                final String full_name_data=fullname_text.getText().toString();
                final String email_data=email_text.getText().toString();
                final String pass_data=pass_text.getText().toString();
                final String phone_number_data=phonenumber_text.getText().toString();
                //check user is filled all the fields or not before sending t0 fire base

                if(full_name_data.isEmpty()||email_data.isEmpty()||pass_data.isEmpty()||phone_number_data.isEmpty())
                {
                    Toast.makeText(userregestrationpageofwms.this ,"fill all the fields",Toast.LENGTH_SHORT).show();
                }
                else {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot)
                        {
                            //cehck if email is registerd before
                            if(snapshot.hasChild(email_data))
                            {
                                Toast.makeText(userregestrationpageofwms.this,"email is alredy registerd",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                //send data to firebase realtime database
                                //we are using email has unique identity for every user.
                                // and all the other remaining details come under email
                                 databaseReference.child("users").child(email_data).child("fullname").setValue(full_name_data);
                                databaseReference.child("users").child(email_data).child("phonenumber").setValue(phone_number_data);
                                databaseReference.child("users").child(email_data).child("password").setValue(pass_data);
                                //show a success message and then finish the activity
                                Toast.makeText(userregestrationpageofwms.this,"user registration successful",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(userregestrationpageofwms.this,user_dashboard.class);
                                startActivity(intent);
                                finish();
                               // finish();
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