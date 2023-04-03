package com.example.mysharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText edloginemail,edloginpassword;
    Button btnlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edloginemail = findViewById(R.id.ed_login_email);
        edloginpassword = findViewById(R.id.ed_login_password);
        btnlogin = findViewById(R.id.btn_login);

        MyShared myShared = new MyShared(LoginActivity.this);
        if (myShared.checkLogin())
        {
            Intent i = new Intent(LoginActivity.this,DashboardActivity.class);
            finish();
            startActivity(i);
        }


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edloginemail.getText().toString().equals(myShared.sharedPreferences.getString("email","")) && edloginpassword.getText().toString().equals(myShared.sharedPreferences.getString("password","")) );
                {
                    myShared.login(true);
                    Intent i = new Intent(LoginActivity.this,DashboardActivity.class);
                    finish();
                    startActivity(i);
                }
            }
        });
    }
}