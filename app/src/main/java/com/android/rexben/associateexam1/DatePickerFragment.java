package com.android.rexben.associateexam1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Objects;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {




    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(Objects.requireNonNull(getActivity()), this, year, month, day);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_date_picker, container, false);
    }



    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        PickerActivity activity = (PickerActivity) getActivity();
        activity.processDate(year, month, dayOfMonth);
    }


}
