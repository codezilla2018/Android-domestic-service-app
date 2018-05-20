package com.example.randikawann.findhelper;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class NameActivity extends AppCompatActivity {
    String email, password;
    EditText etname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        Intent myIntent =getIntent();
        if(myIntent!=null){
            email = myIntent.getStringExtra("email");
            password = myIntent.getStringExtra("password");
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void nextBtnClicked(View v){
        Date myDate=new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.getDefault());
        String date = dateFormat.format(myDate);

        Random r =new Random();
        int n = 1000+r.nextInt(9000);
        String code = String.valueOf(n);

        if(etname.getText().toString()!=null){
            Intent myIntent = new Intent(NameActivity.this,InviteCodeActivity.class);
            myIntent.putExtra("name",etname.getText().toString());
            myIntent.putExtra("email",email);
            myIntent.putExtra("password",password);
            myIntent.putExtra("date",date);
            myIntent.putExtra("isSharing","false");
            myIntent.putExtra("code",code);

            startActivity(myIntent);
        }else{
            Toast.makeText(getApplicationContext(),"Please enter user name",Toast.LENGTH_SHORT).show();
        }
    }
}
