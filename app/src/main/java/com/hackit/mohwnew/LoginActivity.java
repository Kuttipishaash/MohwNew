package com.hackit.mohwnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    private static final String PREFERENCE_FILE = "User_Preferences";
    //Views
    private EditText mUserNameEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;

    //Firebase Realtime DB Objects
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mDatabaseReference;

    //SharedPreferences objects
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor mSharedPreferencesEditor;

    //Username and passwords
    private String username;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("/users");

        mSharedPreferences = getApplicationContext().getSharedPreferences(PREFERENCE_FILE, 0);
        mSharedPreferencesEditor = mSharedPreferences.edit();


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = mUserNameEditText.getText().toString();
                password = mPasswordEditText.getText().toString();


                //Attach a listener to read the data at our posts reference
                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            if (postSnapshot.getKey().equals(username)) {
                                User user = postSnapshot.getValue(User.class);
                                if (user.getPassword().equals(password)) {
                                    mSharedPreferencesEditor.putString("username", username);
                                    mSharedPreferencesEditor.apply();
                                    Toast.makeText(LoginActivity.this, "Logged in as " + user.getName(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(LoginActivity.this, MapsActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                                }
                            }


                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
    }

    private void initViews() {
        mUserNameEditText = findViewById(R.id.et_username_al);
        mPasswordEditText = findViewById(R.id.et_password_al);
        mLoginButton = findViewById(R.id.btn_login_al);
    }

}
