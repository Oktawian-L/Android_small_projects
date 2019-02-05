package com.archiedev.optimus.adapterytresci;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        private int seekR, seekG, seekB;
        private SharedPreferences mPreferences;
        private SharedPreferences.Editor mEditor;
        private int color;
        private String tekstPowitania;
        private String opisPowitania;
        private int czcionka;




        private SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekBar.getId()) {
                    case R.id.redSeekbar:
                        seekR = progress;
                        break;
                    case R.id.greenSeekbar:
                        seekG = progress;
                        break;
                    case R.id.blueSeekbar:
                        seekB = progress;
                        break;
                }

                doSomethingWithColor();
            }
        };

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_2);

            SeekBar sbR = (SeekBar) findViewById(R.id.redSeekbar);
            SeekBar sbG = (SeekBar) findViewById(R.id.greenSeekbar);
            SeekBar sbB = (SeekBar) findViewById(R.id.blueSeekbar);

            sbR.setOnSeekBarChangeListener(onSeekBarChangeListener);
            sbG.setOnSeekBarChangeListener(onSeekBarChangeListener);
            sbB.setOnSeekBarChangeListener(onSeekBarChangeListener);

            Spinner spinner = findViewById(R.id.spinner);
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.texts, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);



            RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    switch (checkedId) {
                        case R.id.radioButton:
                            tekstPowitania = "Pierwszy tekst powitalny";
                            opisPowitania = "Opis powitania pierwszego";
                            break;
                        case R.id.radioButton2:
                            tekstPowitania = "Drugi tekst powitalny";
                            opisPowitania = "Opis powitania drugiego";
                            break;
                        case R.id.radioButton3:
                            tekstPowitania = "Trzeci tekst powitalny";
                            opisPowitania = "Opis powitania trzeciego";
                            break;
                    }
                }
            });


            Button save = findViewById(R.id.save);

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveData();
                    finish();   //Closes activity
                }
            });

            Button reset = findViewById(R.id.reset);

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    color = Color.parseColor("white");
                    tekstPowitania = "Pierwszy tekst powitalny";
                    opisPowitania = "Opis powitania pierwszego";
                    czcionka = 25;

                    saveData();
                    finish();   //Closes activity
                }
            });

            Button cancel = findViewById(R.id.cancel);

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();   //Closes activity
                }
            });
        }

        private void doSomethingWithColor() {
            ImageView rbg = (ImageView) findViewById(R.id.RGB);
            color = Color.rgb(seekR, seekG, seekB);
            rbg.setBackgroundColor(color);

        }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String tmp = parent.getItemAtPosition(position).toString();

            if(tmp == "Rozmiar 1"){
                czcionka = 20;
            } else if (tmp == "Rozmiar 2"){
                czcionka = 25;
            }
            else {
                czcionka = 30;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        private void saveData() {
            mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            mEditor = mPreferences.edit();


            mEditor.putInt("backgroundColor", color);
            mEditor.putString("testPowitania", tekstPowitania);
            mEditor.putString("opisPowitania", opisPowitania);
            mEditor.putInt("czcionka", czcionka);

            mEditor.commit();
        }
    }
