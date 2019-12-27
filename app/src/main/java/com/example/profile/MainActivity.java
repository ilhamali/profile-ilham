package com.example.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView1;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView;
    Spinner mLanguage;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLanguage = (Spinner) findViewById(R.id.spLanguage);
        mTextView1 = (TextView) findViewById(R.id.foto);
        mTextView2 = (TextView) findViewById(R.id.pengikut);
        mTextView3 = (TextView) findViewById(R.id.mengikuti);

        mAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.language_option));
        mLanguage.setAdapter(mAdapter);

        if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("ar")) {
            mLanguage.setSelection(mAdapter.getPosition("Arabic"));
        } else if (LocaleHelper.getLanguage(MainActivity.this).equalsIgnoreCase("in")) {
            mLanguage.setSelection(mAdapter.getPosition("Indonesian"));
        }

        mLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Context context;
                Resources resources;
                switch (i) {
                    case 0:
                        context = LocaleHelper.setLocale(MainActivity.this, "ar");
                        resources = context.getResources();
                        mTextView1.setText(resources.getString(R.string.photo));
                        mTextView2.setText(resources.getString(R.string.pengikut));
                        mTextView3.setText(resources.getString(R.string.mengikuti));
                        break;
                    case 1:
                        context = LocaleHelper.setLocale(MainActivity.this, "in");
                        resources = context.getResources();
                        mTextView1.setText(resources.getString(R.string.photo));
                        mTextView2.setText(resources.getString(R.string.pengikut));
                        mTextView3.setText(resources.getString(R.string.mengikuti));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
