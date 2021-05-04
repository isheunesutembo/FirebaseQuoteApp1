package com.example.firebasequoteapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignIn extends AppCompatActivity {
    private EditText email,password;
    private Button signinBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        signinBtn=findViewById(R.id.signin);
        mAuth=FirebaseAuth.getInstance();


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser();

            }
        });
    }

    private void signInUser(){

       String emailString=email.getText().toString();
       String passwordString=password.getText().toString();

       mAuth.signInWithEmailAndPassword(emailString,passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isSuccessful()){
                   Intent intent=new Intent(SignIn.this,MainActivity.class);
                   startActivity(intent);
               }else{
                   Toast.makeText(SignIn.this, "Sorrty we could not sign you in ,did you create an account?", Toast.LENGTH_SHORT).show();
               }



           }
       });



    }
}