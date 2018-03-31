package com.hackit.mohwnew;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackit.mohwnew.Adapters.DistrictProgramsAdapter;
import com.hackit.mohwnew.Data.DistrictProgram;

import java.util.ArrayList;

public class DistrictProgramsActivity extends AppCompatActivity {

    private static final String PREFERENCE_FILE = "User_Preferences";
    //SharedPref objects
    SharedPreferences mSharedPreferences;
    //List populating objects
    private ListView mListView;
    private ArrayList<DistrictProgram> districtProgramArrayList;
    private DistrictProgramsAdapter districtProgramsAdapter;
    private ArrayList<String> programIDList;
    //Location details
    private String mState;
    private String mDistrict;
    //User details
    private boolean completed;
    private String programID;
    //Firebase Objects
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mFirebaseDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district_programs);
        initViews();

        mFirebaseDatabase = FirebaseDatabase.getInstance();

        mSharedPreferences = getApplicationContext().getSharedPreferences(PREFERENCE_FILE, 0);
        mState = mSharedPreferences.getString("state", "");
        mDistrict = mSharedPreferences.getString("district", "");

        mFirebaseDatabaseReference = mFirebaseDatabase.getReference("/states/" + mState + "/" + mDistrict + "/");

        districtProgramArrayList = new ArrayList<DistrictProgram>();
        districtProgramArrayList.add(new DistrictProgram("National Vector Borne Disease Control Programme (NVBDCP)", "Directorate of National Vector Borne Disease Control Programme (NVBDCP) is the central nodal agency for the prevention and control of vector borne diseases i.e. Malaria, Dengue, Lymphatic Filariasis, Kala-azar, Japanese Encephalitis and Chikungunya in India. It is one of the Technical Departments of Directorate General of Health Services, Government of India.", false));
        districtProgramArrayList.add(new DistrictProgram("India Newborn Action Plan (INAP)", "The programme expands the scope of adolescent health programming in India - from being limited to sexual and reproductive health, it now includes in its ambit nutrition, injuries and violence (including gender based violence), non-communicable diseases, mental health and substance misuse. The strength of the program is its health promotion approach.", true));
        districtProgramArrayList.add(new DistrictProgram("Rashtriya Bal Swasthya Karyakram (RBSK)", "Rashtriya Bal Swasthya Karyakram (RBSK) is an important initiative aiming at early identification and early intervention for children from birth to 18 years to cover 4 ‘D’s viz. Defects at birth, Deficiencies, Diseases, Development delays including disability.", false));
        districtProgramArrayList.add(new DistrictProgram("Rashtriya Kishor Swasthya Karyakram (RKSK)", "The programme expands the scope of adolescent health programming in India - from being limited to sexual and reproductive health, it now includes in its ambit nutrition, injuries and violence (including gender based violence), non-communicable diseases, mental health and substance misuse. The strength of the program is its health promotion approach.", true));
        districtProgramsAdapter = new DistrictProgramsAdapter(DistrictProgramsActivity.this, districtProgramArrayList);
        districtProgramsAdapter.setNotifyOnChange(true);
        mListView.setAdapter(districtProgramsAdapter);
//        programIDList = new ArrayList<String>();

//        mFirebaseDatabaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                programIDList.clear();
//
//
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                    completed = (boolean) postSnapshot.child("completed").getValue();
//                    programID = postSnapshot.getKey();
//                    programIDList.add(programID);
//                }
//                getList();
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

    }

    private void initViews() {
        mListView = findViewById(R.id.lv_district_programs);
    }


//    private void getList() {
//        for (int i = 0; i < programIDList.size(); i++) {
//            programID = programIDList.get(i);
//            DatabaseReference reference = mFirebaseDatabase.getReference("/programs");
//            reference.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    if (programID.equals(dataSnapshot.getKey())) {
//                        DistrictProgram districtProgram = new DistrictProgram();
//                        districtProgram.setCompletionStatus(completed);
//
//                        String x;
//                        x = "";
//                        x = dataSnapshot.child("title").getValue(String.class);
//                        String y;
//                        y = "";
//                        y = dataSnapshot.child("description").getValue(String.class);
//
//                        districtProgram.setTitle(x);
//                        districtProgram.setDescription(y);
//                        districtProgramArrayList.add(districtProgram);
//                    }
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//
//                }
//            });
//            districtProgramsAdapter = new DistrictProgramsAdapter(DistrictProgramsActivity.this, districtProgramArrayList);
//            districtProgramsAdapter.setNotifyOnChange(true);
//            mListView.setAdapter(districtProgramsAdapter);
//
//        }
//    }
}
