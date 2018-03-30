package com.hackit.mohwnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FeedBack extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Feedback");
        }
        setContentView(R.layout.activity_feed_back);
    }
}
