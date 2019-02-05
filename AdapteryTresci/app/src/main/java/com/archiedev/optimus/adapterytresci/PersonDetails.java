package com.archiedev.optimus.adapterytresci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);

       /* final Intent i = getIntent();
        Osoba osoba = (Osoba)i.getSerializableExtra("sampleObject");

        TextView dane = (TextView) findViewById(R.id.textViewName);
        dane.setText(osoba.getName());
        TextView wiek = (TextView) findViewById(R.id.textViewAge);
        wiek.setText("Wiek: " + Integer.toString(osoba.getWiek()));
        TextView priorytet = (TextView) findViewById(R.id.textViewLevel);
        priorytet.setText("Priorytet: " + Integer.toString(osoba.getPriorytet()));
        TextView plec = (TextView) findViewById(R.id.textViewGender);
        plec.setText(String.valueOf(osoba.getPlec()));
        ImageView plecImg = (ImageView) findViewById(R.id.imageView);
        if (osoba.getPlec()=='M') {
            plec.setText("Typ:Spalinowy");
            plecImg.setImageResource(R.drawable.male);
        }
        else {
            plec.setText("Typ:Elektryczny");
            plecImg.setImageResource(R.drawable.female);
        }*/
        }

}
