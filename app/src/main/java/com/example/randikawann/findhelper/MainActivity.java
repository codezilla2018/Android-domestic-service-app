package com.example.randikawann.findhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void signInBtnClicked(View v){
        Intent myIntent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(myIntent);
    }

    public void signupBtnClicked(View v){
        Intent myIntent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(myIntent);
    }
}
