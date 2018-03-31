package com.hackit.mohwnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class AddFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issues);

        String state = getIntent().getStringExtra("state");
        getSupportActionBar().setTitle(state);


    }
}
