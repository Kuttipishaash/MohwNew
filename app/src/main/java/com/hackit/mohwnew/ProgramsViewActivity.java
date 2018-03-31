package com.hackit.mohwnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

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
    List<String> programIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_view);
        getSupportActionBar().setTitle("Programs");

        programList = new ArrayList<Program>();
        programIds = new ArrayList<String>();
        mProgramsList = (ListView) findViewById(R.id.list_view_programs);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_view_programs);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("programs");
        databaseReference.keepSynced(true);
        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Program program = dataSnapshot.getValue(Program.class);
                programList.add(program);
                programIds.add(dataSnapshot.getKey());
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

        mProgramsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Program clickedProgram = mProgramAdapter.getItem(position);

                Intent intent = new Intent(getBaseContext(), ProgramStateViewActivity.class);
                intent.putExtra("title", clickedProgram.getTitle());
                intent.putExtra("id",  programIds.get(position));
                Toast.makeText(ProgramsViewActivity.this, programIds.get(position) + "", Toast.LENGTH_SHORT).show();
/*                intent.putExtra("completed", Integer.toString(clickedProgram.getCompleted()));
                intent.putExtra("completion_rate", Float.toString(clickedProgram.getCompletionRate()));
                intent.putExtra("description", clickedProgram.getDescription());
                intent.putExtra("total", Integer.toString(clickedProgram.getTotal()));
                intent.putExtra("under", clickedProgram.getUnder());
*/                startActivity(intent);
            }
        });
    }
}
