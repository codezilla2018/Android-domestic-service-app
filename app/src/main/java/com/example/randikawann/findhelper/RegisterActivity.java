package com.example.randikawann.findhelper;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;

public class RegisterActivity extends AppCompatActivity {

    EditText etemail;
    //Button btnnext;
    FirebaseAuth auth;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etemail = (EditText) findViewById(R.id.etpassword);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
    }

    public void nextButtonClicked(View v){
        dialog.setMessage("cheking email address");
        dialog.show();
        //check if email already registered or not
        auth.fetchProvidersForEmail(etemail.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                    @Override
                    public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                        if(task.isSuccessful()){
                            dialog.dismiss();
                            boolean check = !task.getResult().getProviders().isEmpty();
                            if(!check){
                                //email doesnot exit, so we can create this email with user
                                Intent myIntent = new Intent();
                                myIntent.putExtra("email",etemail.getText().toString());
                                startActivity(myIntent);
                            }else{
                                dialog.dismiss();
                                Toast.makeText(getApplicationContext(),"This email is already registered",Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
    }
}
