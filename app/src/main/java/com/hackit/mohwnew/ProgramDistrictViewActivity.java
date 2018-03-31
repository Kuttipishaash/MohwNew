package com.hackit.mohwnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

    //    mDistrictsListView = (ListView) findViewById(R.id.list_view_districts_programs);
    }
}
