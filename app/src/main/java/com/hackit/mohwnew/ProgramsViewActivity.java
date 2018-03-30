package com.hackit.mohwnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProgramsViewActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    List<Program> programList;
    ListView mProgramsList;
    ProgramsAdapter mProgramAdapter;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_view);

        programList = new ArrayList<Program>();
        mProgramsList = (ListView) findViewById(R.id.list_view_programs);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_view_programs);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("programs");
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Program program = dataSnapshot.getValue(Program.class);
                programList.add(program);
                mProgramAdapter = new ProgramsAdapter(ProgramsViewActivity.this, R.layout.item_program, programList);
                mProgramsList.setAdapter(mProgramAdapter);
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
