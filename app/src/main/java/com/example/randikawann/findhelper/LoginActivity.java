package com.example.randikawann.findhelper;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth     auth;
    EditText etemail, etpassword;
    Button btnsign_in;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etemail = (EditText) findViewById(R.id.etpassword);
        etpassword = (EditText) findViewById(R.id.etpassword);
        auth = FirebaseAuth.getInstance();

    }

    public void signIn(View v){
        auth.signInWithEmailAndPassword(etemail.getText().toString(),etpassword.getText().toString())
            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(),"User log in successfully",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"wrong password or email",Toast.LENGTH_LONG).show();
                    }
                }
            });
    }
}
