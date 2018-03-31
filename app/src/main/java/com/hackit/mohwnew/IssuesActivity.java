package com.hackit.mohwnew;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackit.mohwnew.Data.UserLocation;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class IssuesActivity extends AppCompatActivity {

    private Button submitButton;

    private RadioGroup mRadioGroup1;
    private RadioGroup mRadioGroup2;
    private RadioGroup mRadioGroup3;
    private RadioGroup mRadioGroup4;
    private RadioGroup mRadioGroup5;
    private RadioGroup mRadioGroup6;
    private RadioGroup mRadioGroup7;
    private RadioGroup mRadioGroup8;
    private RadioGroup mRadioGroup9;
    private RadioGroup mRadioGroup10;

    private RadioButton mRadioButton1;
    private RadioButton mRadioButton2;
    private RadioButton mRadioButton3;
    private RadioButton mRadioButton4;
    private RadioButton mRadioButton5;
    private RadioButton mRadioButton6;
    private RadioButton mRadioButton7;
    private RadioButton mRadioButton8;
    private RadioButton mRadioButton9;
    private RadioButton mRadioButton10;
    private RadioButton mRadioButton11;
    private RadioButton mRadioButton12;
    private RadioButton mRadioButton13;
    private RadioButton mRadioButton14;
    private RadioButton mRadioButton15;
    private RadioButton mRadioButton16;
    private RadioButton mRadioButton17;
    private RadioButton mRadioButton18;
    private RadioButton mRadioButton19;
    private RadioButton mRadioButton20;
    private RadioButton mRadioButton21;
    private RadioButton mRadioButton22;
    private RadioButton mRadioButton23;
    private RadioButton mRadioButton24;
    private RadioButton mRadioButton25;
    private RadioButton mRadioButton26;
    private RadioButton mRadioButton27;
    private RadioButton mRadioButton28;
    private RadioButton mRadioButton29;
    private RadioButton mRadioButton30;

    private TextView mQuestionTextView1;
    private TextView mQuestionTextView2;
    private TextView mQuestionTextView3;
    private TextView mQuestionTextView4;
    private TextView mQuestionTextView5;
    private TextView mQuestionTextView6;
    private TextView mQuestionTextView7;
    private TextView mQuestionTextView8;
    private TextView mQuestionTextView9;
    private TextView mQuestionTextView10;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference reference;
    private UserLocation userLocation;
    private String issues[] = new String[10];
    private String questionSet1[] = {
            "Does the child have difficulty seeing either during the day or night?",
            "Does the child have any difficulty in speaking compared to other children of his/her age?",
            "Does the child have difficulty in sustaining attention on activities at school, home or play?",
            "Does the child have difficulty in learning new things?",
            "Does the child find it difficult to read or write?",
            "Does the child find it difficult to do simple calculations?",
            "From birth till date, has the child ever had fits?",
            "Does the child have stiffness in his/her arms/legs?",
            "Does the child have floppiness in his/her arms/legs?",
            "Does the child have itching on skin especially at night?"
    };
    private String questionSet2[] = {
            "Was any fever case found positive for malaria last month?",
            "Have you obtained bed nets?",
            "Were you immunized against Cholera?",
            "Were you made aware of how to control Dengue?",
            "Do you have proper toilets in your home?",
            "Does your locality face water clogging problems during rains?",
            "Do you get proper drinking water in your homes?",
            "Is the government hospitals in your locality hygenic?",
            "Is the food provided in nurseries nutritious?",
            "Is drainage systems proper in your area?"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Survey");
        }


        firebaseDatabase = FirebaseDatabase.getInstance();
        reference = firebaseDatabase.getReference("locations");

        setContentView(R.layout.activity_issues);
        initViews();

        Intent intent = getIntent();
        int pos = intent.getIntExtra("position", 0);
        if (pos % 2 == 0) {
            setQuestions(questionSet1);
        } else {
            setQuestions(questionSet2);
        }

        mRadioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.t1r1:
                        issues[0] = mRadioButton1.getText().toString();
                        break;
                    case R.id.t1r2:
                        issues[0] = mRadioButton2.getText().toString();
                        break;
                    case R.id.t1r3:
                        issues[0] = mRadioButton3.getText().toString();
                }
            }
        });
        mRadioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t2r1:
                        issues[1] = mRadioButton4.getText().toString();
                        break;
                    case R.id.t2r2:
                        issues[1] = mRadioButton5.getText().toString();
                        break;
                    case R.id.t2r3:
                        issues[1] = mRadioButton6.getText().toString();
                }
            }
        });
        mRadioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t3r1:
                        issues[2] = mRadioButton7.getText().toString();
                        break;
                    case R.id.t3r2:
                        issues[2] = mRadioButton8.getText().toString();
                        break;
                    case R.id.t3r3:
                        issues[2] = mRadioButton9.getText().toString();
                }
            }
        });
        mRadioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t4r1:
                        issues[3] = mRadioButton10.getText().toString();
                        break;
                    case R.id.t4r2:
                        issues[3] = mRadioButton11.getText().toString();
                        break;
                    case R.id.t4r3:
                        issues[3] = mRadioButton12.getText().toString();
                }
            }
        });
        mRadioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t5r1:
                        issues[4] = mRadioButton13.getText().toString();
                        break;
                    case R.id.t5r2:
                        issues[4] = mRadioButton14.getText().toString();
                        break;
                    case R.id.t5r3:
                        issues[4] = mRadioButton15.getText().toString();
                }
            }
        });
        mRadioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t6r1:
                        issues[5] = mRadioButton16.getText().toString();
                        break;
                    case R.id.t6r2:
                        issues[5] = mRadioButton17.getText().toString();
                        break;
                    case R.id.t6r3:
                        issues[5] = mRadioButton18.getText().toString();
                }
            }
        });
        mRadioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t7r1:
                        issues[6] = mRadioButton19.getText().toString();
                        break;
                    case R.id.t7r2:
                        issues[6] = mRadioButton20.getText().toString();
                        break;
                    case R.id.t7r3:
                        issues[6] = mRadioButton21.getText().toString();
                }
            }
        });
        mRadioGroup8.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t8r1:
                        issues[7] = mRadioButton22.getText().toString();
                        break;
                    case R.id.t8r2:
                        issues[7] = mRadioButton23.getText().toString();
                        break;
                    case R.id.t8r3:
                        issues[7] = mRadioButton24.getText().toString();
                }
            }
        });
        mRadioGroup9.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t9r1:
                        issues[8] = mRadioButton25.getText().toString();
                        break;
                    case R.id.t9r2:
                        issues[8] = mRadioButton26.getText().toString();
                        break;
                    case R.id.t9r3:
                        issues[8] = mRadioButton27.getText().toString();
                }
            }
        });
        mRadioGroup10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedID) {
                switch (checkedID) {
                    case R.id.t10r1:
                        issues[9] = mRadioButton28.getText().toString();
                        break;
                    case R.id.t10r2:
                        issues[9] = mRadioButton29.getText().toString();
                        break;
                    case R.id.t10r3:
                        issues[9] = mRadioButton30.getText().toString();
                }
            }
        });
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 10; i++) {
                    Log.e("FeedbackActivity", "Answer of qstn " + (i + 1) + " is : " + issues[i]);
                }
                if (ActivityCompat.checkSelfPermission(IssuesActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(IssuesActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(IssuesActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                    return;
                } else {
                    // instantiate the location manager, note you will need to request permissions in your manifest
                    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                    // get the last know location from your location manager.

                    Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    double lat = location.getLatitude();
                    double lng = location.getLongitude();
                    // now get the lat/lon from the location and do something with it.
                    Geocoder gcd = new Geocoder(getApplicationContext(), Locale.getDefault());
                    userLocation = new UserLocation();
                    userLocation.setLat(lat);
                    userLocation.setLng(lng);
                    reference.push().setValue(userLocation);
                    try {
                        List<Address> addresses = gcd.getFromLocation(lat, lng, 1);
                        if (addresses.size() > 0) {
                            Log.e("User_location", "Place is : " + addresses.get(0).getLocality());
                        } else {
                            Log.e("User_location", "lat : " + lat + "long" + lng + " Place Name : " + addresses.get(0).getLocality());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

    }

    private void setQuestions(String[] questionSet) {
        mQuestionTextView1.setText(questionSet[0]);
        mQuestionTextView2.setText(questionSet[1]);
        mQuestionTextView3.setText(questionSet[2]);
        mQuestionTextView4.setText(questionSet[3]);
        mQuestionTextView5.setText(questionSet[4]);
        mQuestionTextView6.setText(questionSet[5]);
        mQuestionTextView7.setText(questionSet[6]);
        mQuestionTextView8.setText(questionSet[7]);
        mQuestionTextView9.setText(questionSet[8]);
        mQuestionTextView10.setText(questionSet[9]);
    }

    private void initViews() {

        submitButton = findViewById(R.id.btn_submit_afb);

        mQuestionTextView1 = findViewById(R.id.t1q);
        mQuestionTextView2 = findViewById(R.id.t2q);
        mQuestionTextView3 = findViewById(R.id.t3q);
        mQuestionTextView4 = findViewById(R.id.t4q);
        mQuestionTextView5 = findViewById(R.id.t5q);
        mQuestionTextView6 = findViewById(R.id.t6q);
        mQuestionTextView7 = findViewById(R.id.t7q);
        mQuestionTextView8 = findViewById(R.id.t8q);
        mQuestionTextView9 = findViewById(R.id.t9q);
        mQuestionTextView10 = findViewById(R.id.t10q);

        mRadioGroup1 = findViewById(R.id.t1rg1);
        mRadioGroup2 = findViewById(R.id.t1rg2);
        mRadioGroup3 = findViewById(R.id.t1rg3);
        mRadioGroup4 = findViewById(R.id.t1rg4);
        mRadioGroup5 = findViewById(R.id.t1rg5);
        mRadioGroup6 = findViewById(R.id.t1rg6);
        mRadioGroup7 = findViewById(R.id.t1rg7);
        mRadioGroup8 = findViewById(R.id.t1rg8);
        mRadioGroup9 = findViewById(R.id.t1rg9);
        mRadioGroup10 = findViewById(R.id.t1rg10);

        mRadioButton1 = findViewById(R.id.t1r1);
        mRadioButton2 = findViewById(R.id.t1r2);
        mRadioButton3 = findViewById(R.id.t1r3);
        mRadioButton4 = findViewById(R.id.t2r1);
        mRadioButton5 = findViewById(R.id.t2r2);
        mRadioButton6 = findViewById(R.id.t2r3);
        mRadioButton7 = findViewById(R.id.t3r1);
        mRadioButton8 = findViewById(R.id.t3r2);
        mRadioButton9 = findViewById(R.id.t3r3);
        mRadioButton10 = findViewById(R.id.t4r1);
        mRadioButton11 = findViewById(R.id.t4r2);
        mRadioButton12 = findViewById(R.id.t4r3);
        mRadioButton13 = findViewById(R.id.t5r1);
        mRadioButton14 = findViewById(R.id.t5r2);
        mRadioButton15 = findViewById(R.id.t5r3);
        mRadioButton16 = findViewById(R.id.t6r1);
        mRadioButton17 = findViewById(R.id.t6r2);
        mRadioButton18 = findViewById(R.id.t6r3);
        mRadioButton19 = findViewById(R.id.t7r1);
        mRadioButton20 = findViewById(R.id.t7r2);
        mRadioButton21 = findViewById(R.id.t7r3);
        mRadioButton22 = findViewById(R.id.t8r1);
        mRadioButton23 = findViewById(R.id.t8r2);
        mRadioButton24 = findViewById(R.id.t8r3);
        mRadioButton25 = findViewById(R.id.t9r1);
        mRadioButton26 = findViewById(R.id.t9r2);
        mRadioButton27 = findViewById(R.id.t9r3);
        mRadioButton28 = findViewById(R.id.t10r1);
        mRadioButton29 = findViewById(R.id.t10r2);
        mRadioButton30 = findViewById(R.id.t10r3);
    }

}
