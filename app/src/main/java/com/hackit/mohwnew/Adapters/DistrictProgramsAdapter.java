package com.hackit.mohwnew.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.hackit.mohwnew.Data.DistrictProgram;
import com.hackit.mohwnew.R;

import java.util.List;

public class DistrictProgramsAdapter extends ArrayAdapter<DistrictProgram> {
    public DistrictProgramsAdapter(Context context, List<DistrictProgram> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if (view == null) {
            view = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_district_program, parent, false);
        }
        TextView mTitleText = view.findViewById(R.id.tv_title_adpli);
        TextView mDescriptionText = view.findViewById(R.id.tv_desc_adpli);
//        TextView mPercentText = view.findViewById(R.id.tv_complete_percent_adpli);
        CheckBox mCompletedCheckBox = view.findViewById(R.id.cb_program_status_adpli);


        DistrictProgram districtProgram = getItem(position);
        mTitleText.setText(districtProgram.getTitle());
        mDescriptionText.setText(districtProgram.getDescription());
//            mPercentText.setText(districtProgram.getCompletion_rate() + "");
        mCompletedCheckBox.setChecked(districtProgram.isCompletionStatus());

        return view;
    }
}
