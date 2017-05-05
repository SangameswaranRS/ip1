package com.example.sangameswaran.practice;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.Calendar;

/**
 * Created by Sangameswaran on 05-05-2017.
 */

public class PickerDialog extends DialogFragment {



    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
       DateSettings settings=new DateSettings(getActivity());
        Calendar calendar=Calendar.getInstance();

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int date=calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog dialog;

        dialog=new DatePickerDialog(getActivity(),settings,year,month,date);
        return dialog;

    }
}
