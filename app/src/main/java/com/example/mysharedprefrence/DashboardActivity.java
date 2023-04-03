package com.example.mysharedprefrence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        MyShared myShared = new MyShared(DashboardActivity.this);

        textView = findViewById(R.id.tv_display_text);

        textView.setText(myShared.sharedPreferences.getString("username",""));
    }

}