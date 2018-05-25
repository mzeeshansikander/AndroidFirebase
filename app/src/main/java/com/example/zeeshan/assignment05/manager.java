package com.example.zeeshan.assignment05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class manager extends AppCompatActivity {

    private Button logout;
    private EditText canName;
    private EditText canPosition;
    private EditText canMemo;
    private Button cAdd;


    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        canName = findViewById(R.id.cName);
        canPosition = findViewById(R.id.cPosition);
        canMemo = findViewById(R.id.cMemo);
        cAdd = findViewById(R.id.canAdd);
        databaseReference = FirebaseDatabase.getInstance().getReference("candidate");

        cAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCandidate();
            }
        });





        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(manager.this,MainActivity.class));
            }
        });


    }
    private void addCandidate(){
        String name,position,memo;
        name = canName.getText().toString();
        position = canPosition.getText().toString();
        memo = canMemo.getText().toString();

        if (!TextUtils.isEmpty(name)){

            String id = databaseReference.push().getKey();
            Candidate candidate = new Candidate(id, name, position, memo);

            databaseReference.child(id).setValue(candidate);
            Toast.makeText(manager.this,"Candidate Added ",Toast.LENGTH_SHORT).show();


        }else{

            Toast.makeText(manager.this,"Insert Data ",Toast.LENGTH_SHORT).show();
        }


    }
}
