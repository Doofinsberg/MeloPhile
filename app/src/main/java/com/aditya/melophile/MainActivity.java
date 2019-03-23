//tools:context=".MainActivity">
//implementation 'com.android.support:appcompat-v7:28.0.0'
package com.aditya.melophile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView text_forgot,text_social;
    ImageView imageLogo, plus,facebook,twitter;
    Button signin,signup;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_main);

        text_forgot = (TextView)findViewById(R.id.text_forgot);
        text_social = (TextView)findViewById(R.id.social_signIN);

        imageLogo = (ImageView)findViewById(R.id.imageView);
        plus = (ImageView)findViewById(R.id.plus);
        facebook = (ImageView)findViewById(R.id.facebook);
        twitter = (ImageView)findViewById(R.id.twitter);

        signin = (Button)findViewById(R.id.signin);
        signup = (Button)findViewById(R.id.signup);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUp.class));
            }
        });


    }


}