package com.example.sangameswaran.practice;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by Sangameswaran on 05-05-2017.
 */

public class DateSettings implements DatePickerDialog.OnDateSetListener {


    Context ctx;
    DateSettings(Context ctx)
    {
        this.ctx=ctx;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Toast.makeText(ctx,"Date is Set"+i+i1+i2,Toast.LENGTH_LONG).show();

    }
}
