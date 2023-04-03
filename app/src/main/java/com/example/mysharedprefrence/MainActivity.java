package com.example.mysharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edusername,edemail,edpassword;
    Button btnregister;
    TextView tvloginlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edusername = findViewById(R.id.ed_username);
        edemail = findViewById(R.id.ed_email);
        edpassword = findViewById(R.id.ed_password);

        btnregister = findViewById(R.id.btn_register);
        tvloginlink = findViewById(R.id.tv_login);

        MyShared myShared= new MyShared(MainActivity.this);

        if (myShared.checkLogin())
        {
            Intent i = new Intent(MainActivity.this,DashboardActivity.class);
            finish();
            startActivity(i);
        }


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myShared.storeData(edusername.getText().toString(),edemail.getText().toString(),edpassword.getText().toString());
                Intent i =new Intent(MainActivity.this,DashboardActivity.class);
                finish();
                startActivity(i);
            }
        });

        tvloginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,LoginActivity.class);
                finish();
                startActivity(i);
            }
        });



    }
}