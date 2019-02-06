package com.archiedev.optimus.adapterytresci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import java.io.Serializable;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void add(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        RadioGroup radioGroup= (RadioGroup) findViewById(R.id.opcjeData);
        int id = radioGroup.getCheckedRadioButtonId();
        char plecValue = 'N';
        switch (id) {
            case R.id.radioButton: plecValue = 'M';
                break;
            case R.id.radioButton2: plecValue = 'F';
                break;
            default:
                break;
        }

        Osoba osoba = new Osoba("Mazda", 22, 4, 'M');
        osoba.setName(editText2.getText().toString());
        osoba.setWiek(Integer.parseInt(editText.getText().toString()));
        osoba.setPriorytet(Integer.parseInt(String.valueOf(seekBar.getProgress() + 1)));
        osoba.setPlec(plecValue);
        Intent i = new Intent(this, Activity4.class);
        i.putExtra("sampleObject", osoba);
        startActivity(i);
    }
    public void uruchomJeden(View view) {
        onBackPressed();
    }

}


