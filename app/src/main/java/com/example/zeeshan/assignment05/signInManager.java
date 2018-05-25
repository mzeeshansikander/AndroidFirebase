package com.example.zeeshan.assignment05;


import android.content.Intent;
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

public class signInManager extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button button;

    private FirebaseAuth mAuth;
    //private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_manager);


        mAuth = FirebaseAuth.getInstance();
/*
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {


                }

            }
        };
*/

        email = findViewById(R.id.userId);
        password = findViewById(R.id.userPass);
        email.setText("zeeshan@live.com");
        password.setText("zeeshan123");
        button = findViewById(R.id.signIn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn();

            }
        });


    }

/*    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }*/

    private void SignIn() {
        String sEmail = email.getText().toString();
        String sPass = password.getText().toString();

        mAuth.signInWithEmailAndPassword(sEmail, sPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (!task.isSuccessful()) {
                    Toast.makeText(signInManager.this, "Sign in Error", Toast.LENGTH_LONG).show();

                } else {

                    startActivity(new Intent(signInManager.this, manager.class));
                }


            }
        });
    }
}