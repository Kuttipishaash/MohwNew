package com.hackit.mohwnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    //Views
    private EditText mUserNameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    //Firebase Realtime DB Objects


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void initViews() {
        mUserNameEditText = findViewById(R.id.et_username_al);
        mPasswordEditText = findViewById(R.id.et_password_al);
        mLoginButton = findViewById(R.id.btn_login_al);
    }

}
