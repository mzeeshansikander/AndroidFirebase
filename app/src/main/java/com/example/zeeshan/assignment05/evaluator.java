package com.example.zeeshan.assignment05;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class evaluator extends AppCompatActivity {

    private List<String> candidateList = new ArrayList<>();
    ListView lvCandidates;
    DatabaseReference databaseReference;
    ArrayAdapter<String> arrayAdapter;
    private Button bView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluator);

        lvCandidates = findViewById(R.id.candidateList);
        bView = findViewById(R.id.view);

        databaseReference = FirebaseDatabase.getInstance().getReference("candidate");
        bView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {



                        for (DataSnapshot candidateSnapshot : dataSnapshot.getChildren()) {

                            candidateList.add(candidateSnapshot.child("candidateName").getValue().toString());
                            Log.e("TAG",candidateSnapshot.child("candidateName").getValue().toString());

                        }
                        arrayAdapter = new ArrayAdapter<String>(evaluator.this,android.R.layout.simple_list_item_1,candidateList);
                        lvCandidates.setAdapter(arrayAdapter);


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });


            }
        });



    }






        }

