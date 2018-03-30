package com.hackit.mohwnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class ProgramsViewActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    List<Program> programList;
    ListView mProgramsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_view);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("programs");
    }
}
