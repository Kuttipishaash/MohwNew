package com.hackit.mohwnew.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackit.mohwnew.Data.Report;
import com.hackit.mohwnew.R;

import java.util.List;

/**
 * Created by praji on 30-Mar-18.
 */

public class ReportsAdapter extends ArrayAdapter<Report> {

    public ReportsAdapter(Context context, int resource, List<Report> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if (view == null) {
            view = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_report, parent, false);
        }
        TextView mTitleText = view.findViewById(R.id.text_item_title);
        TextView mProgramNameText = view.findViewById(R.id.text_item_program_name);
        TextView mDescriptionText = view.findViewById(R.id.text_item_description);

        Report report = getItem(position);
        mTitleText.setText(report.getTitle());
        mProgramNameText.setText(report.getProgName());
        mDescriptionText.setText(report.getDesc());
        return view;
    }
}
