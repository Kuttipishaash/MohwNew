package com.hackit.mohwnew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ProgramDistrictViewActivity extends AppCompatActivity {

    List<String> districtsList;
    ArrayAdapter mAdapter;
    ListView mDistrictsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_district_view);

        String state = getIntent().getStringExtra("state");
        getSupportActionBar().setTitle(state);

        mDistrictsListView = findViewById(R.id.list_view_districts_programs);
        districtsList = new ArrayList<>();

        districtsList.add("Ernakulam");
        districtsList.add("Palakkad");
        districtsList.add("Trissur");
        districtsList.add("Kannur");
        districtsList.add("Kozhikode");
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_selectable_list_item, districtsList);
        mDistrictsListView.setAdapter(mAdapter);
        mDistrictsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String district = districtsList.get(position);
                Intent intent = new Intent(ProgramDistrictViewActivity.this, IssuesActivity.class);
                intent.putExtra("district", district);
                startActivity(intent);
            }
        });

    //    mDistrictsListView = (ListView) findViewById(R.id.list_view_districts_programs);
    }
}
