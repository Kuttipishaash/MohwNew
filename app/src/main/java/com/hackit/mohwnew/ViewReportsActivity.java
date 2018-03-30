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

public class ViewReportsActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    List<Report> reportsList;
    ListView mReportList;
    ReportsAdapter reportsAdapter;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_reports);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("reports");
        mReportList = (ListView) findViewById(R.id.list_view_reports);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_view_reports);
        reportsList = new ArrayList<Report>();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Report report = dataSnapshot.getValue(Report.class);
                reportsList.add(report);
                reportsAdapter = new ReportsAdapter(ViewReportsActivity.this, R.layout.item_report, reportsList);
                mReportList.setAdapter(reportsAdapter);
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
