package com.example.demo2;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // code just to check laguage changes
    TextView textView;
    Button chgLag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textViewId);
        chgLag = (Button)findViewById(R.id.chgLag);

        chgLag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chgLag.getText().toString().equalsIgnoreCase(("chgLagHindi"))){
                        chgLag.setText("chgLagEnglish");
                    setLocale("hi");
                }else{
                    chgLag.setText("chgLagHindi");
                    setLocale("en");
                }

            }
        });
    }

    public void setLocale(String lang) {
        Locale myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        textView.setText(getString(R.string.textName));

    }
}