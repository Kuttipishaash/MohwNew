package com.hackit.mohwnew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.hackit.mohwnew.Data.Report;

public class AddReportActivity extends AppCompatActivity {

    EditText mTitleField;
    EditText mProgramNameField;
    EditText mDescField;
    Button mSubmitButton;

    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_report);

        mTitleField = findViewById(R.id.et_report_title);
        mDescField = findViewById(R.id.et_report_description);
        mProgramNameField = findViewById(R.id.et_report_program);
        mSubmitButton = findViewById(R.id.btn_report_submit);

        mTitleField.requestFocus();

        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.keepSynced(true);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Report report = new Report();
                report.setTitle(mTitleField.getText().toString());
                report.setDesc(mDescField.getText().toString());
                report.setProgName(mProgramNameField.getText().toString());
                databaseReference.child("reports").push().setValue(report);

                Toast.makeText(AddReportActivity.this, "Report created", Toast.LENGTH_SHORT).show();

                mTitleField.setText("");
                mDescField.setText("");
                mProgramNameField.setText("");
                mTitleField.requestFocus();
            }
        });
    }
}
