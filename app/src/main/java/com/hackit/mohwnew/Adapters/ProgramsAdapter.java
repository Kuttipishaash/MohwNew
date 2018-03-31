package com.hackit.mohwnew.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hackit.mohwnew.Data.Program;
import com.hackit.mohwnew.R;

import java.util.List;

/**
 * Created by praji on 31-Mar-18.
 */

public class ProgramsAdapter extends ArrayAdapter<Program> {
    public ProgramsAdapter(Context context, int resource, List<Program> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        if (view == null) {
            view = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.item_program, parent, false);
        }

        TextView mTitle = view.findViewById(R.id.text_program_title);
        TextView mUnder = view.findViewById(R.id.text_program_under);
        TextView mDescription = view.findViewById(R.id.text_program_desc);
        TextView mCompleted = view.findViewById(R.id.text_program_completed);
        TextView mCompletionRate = view.findViewById(R.id.text_program_completion_rate);
        TextView mTotal = view.findViewById(R.id.text_program_total);

        Program program = getItem(position);

        mTitle.setText(program.getTitle());
        mUnder.setText(program.getUnder());
        mDescription.setText(program.getDescription());
        mCompleted.setText(Integer.toString(program.getCompleted()));
        mCompletionRate.setText(String.valueOf(program.getCompletionRate()));
        mTotal.setText(Integer.toString(program.getTotal()));
        return view;
    }
}
