package com.example.randikawann.findhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {
    String email;
    EditText etpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        etpassword=(EditText) findViewById(R.id.etpassword);

        Intent myIntent=getIntent();
        if(myIntent==null){
            email=myIntent.getStringExtra("email");
        }
    }
    public void nextButtonClicked(View v){

        if(etpassword.getText().toString().length()>6) {
            Intent myIntent = new Intent(PasswordActivity.this, NameActivity.class);
            myIntent.putExtra("email", email);
            myIntent.putExtra("password", etpassword.getText().toString());
            startActivity(myIntent);
        }
        else{
            Toast.makeText(getApplicationContext(),"password length should be  more than 6 character",Toast.LENGTH_SHORT).show();
        }

    }
}
