package com.hackit.mohwnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProgramStateViewActivity extends AppCompatActivity {

    String title;
    String completed;
    String completion_rate;
    String description;
    String total;
    String under;
    String id;

    DatabaseReference programRef;
    DatabaseReference stateRef;

    List<String> statesList;
    ArrayAdapter mAdapter;
    ListView mStatesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_state_view);

        title = getIntent().getStringExtra("title");
        id = getIntent().getStringExtra("id");

        getSupportActionBar().setTitle(title);

        mStatesListView = (ListView) findViewById(R.id.list_view_states_programs);
        statesList = new ArrayList<>();

        statesList.add("Kerala");
        statesList.add("Maharashtra");
        statesList.add("West Bengal");
        statesList.add("Uttar Pradesh");
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, statesList);
        mStatesListView.setAdapter(mAdapter);
        mStatesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedString = statesList.get(position);
                Intent intent = new Intent(ProgramStateViewActivity.this, AddFeedbackActivity.class);
                intent.putExtra("state", clickedString);
                startActivity(intent);
            }
        });


/*        completed = getIntent().getStringExtra("completed");
        completion_rate = getIntent().getStringExtra("completion_rate");
        description = getIntent().getStringExtra("description");
        total = getIntent().getStringExtra("total");
        under = getIntent().getStringExtra("under");

        programRef = FirebaseDatabase.getInstance().getReference().child("programs");
        stateRef = FirebaseDatabase.getInstance().getReference().child("states");

        stateRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String district = dataSnapshot.getValue(String.class);
                Toast.makeText(ProgramStateViewActivity.this, district + "", Toast.LENGTH_SHORT).show();
                districtList.add(district);
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
*/
    }
}
