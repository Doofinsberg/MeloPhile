package com.aditya.melophile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    ImageView imageView;
    EditText email;
    EditText password;
    Button signup;
    Button loginact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        imageView = (ImageView)findViewById(R.id.imageView);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        signup = (Button)findViewById(R.id.signup);
        loginact = (Button)findViewById(R.id.loginact);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(getApplicationContext(),"Enter Email and password",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}
