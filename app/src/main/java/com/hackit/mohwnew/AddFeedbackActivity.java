package com.hackit.mohwnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddFeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        String state = getIntent().getStringExtra("state");
        getSupportActionBar().setTitle(state);


    }
}
