package com.example.sangameswaran.practice;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by Sangameswaran on 05-05-2017.
 */

public class PracticeActivity1 extends FragmentActivity {

    EditText et1;
    Spinner category;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String languageToLoad  = "fa"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
        setContentView(R.layout.practice_1_layout);
        category=(Spinner)findViewById(R.id.spinner);

        et1=(EditText)findViewById(R.id.et1);
        ArrayList<String> categories=new ArrayList<>();
        categories.add("School");
        categories.add("College");
        categories.add("Working");
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        category.setAdapter(stringArrayAdapter);

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String s;
                s= (String) adapterView.getItemAtPosition(i);

                Toast.makeText(getApplicationContext(),"Selected"+s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inflateDate();

            }
        });

    }
    public void inflateDate()
    {

        PickerDialog pickerDialog=new PickerDialog();
        pickerDialog.show(getSupportFragmentManager(),"date_pick");
    }



}


