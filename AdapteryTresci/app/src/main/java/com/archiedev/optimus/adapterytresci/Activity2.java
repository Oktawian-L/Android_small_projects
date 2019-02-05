package com.archiedev.optimus.adapterytresci;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    String[] lista = {"Witaj", "Cześć", "Dzień dobry!"};
    private int seekR, seekG, seekB, nowyRozmiarTekstu, nowypoczatekKoloru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final SharedPreferences sp = getSharedPreferences("dane_apki", MODE_PRIVATE);
        final SharedPreferences.Editor spe = sp.edit();
        final int nrWyboruPrywitania = sp.getInt("nr_przywitania", 0);
        final int nrWyboruRozmiaru = sp.getInt("nr_rozmiaru", R.id.radioButton);
        final int rozmiarTekstu = sp.getInt("rozmiar_tekstu", 14);
        final int poziomR = sp.getInt("poziom_czerwony", 255);
        final int poziomG = sp.getInt("poziom_zielony", 255);
        final int poziomB = sp.getInt("poziom_niebieski", 0);
        final int kolor = Color.rgb(poziomR, poziomG, poziomB);
        final int poczatekKoloru = sp.getInt("poczatek_koloru", kolor);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.opcje);
        radioGroup.check(nrWyboruRozmiaru);
        radioGroup.setOnCheckedChangeListener(this);
        radioGroup.check(nrWyboruRozmiaru);

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setTextSize(rozmiarTekstu);

        final SeekBar sbR = (SeekBar) findViewById(R.id.RedSeekBar);
        final SeekBar sbG = (SeekBar) findViewById(R.id.GreenSeekBar);
        final SeekBar sbB = (SeekBar) findViewById(R.id.BlueSeekBar);
        sbR.setProgress(poziomR);
        sbG.setProgress(poziomG);
        sbB.setProgress(poziomB);
        final View view = (View) findViewById(R.id.view);
        view.setBackgroundColor(poczatekKoloru);

        final Spinner opcje = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        opcje.setAdapter(adapter);
        opcje.setSelection(nrWyboruPrywitania);

        Button saveButton = (Button) findViewById(R.id.button2);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                spe.commit();

                //create an instance of Intent object.
                Intent data = new Intent();

                nowyRozmiarTekstu = sp.getInt("rozmiar_tekstu", 14);

                int nowypoziomR = sp.getInt("poziom_czerwony", 255);
                int nowypoziomG = sp.getInt("poziom_zielony", 255);
                int nowypoziomB = sp.getInt("poziom_niebieski", 0);
                int nowyKolor = Color.rgb(nowypoziomR, nowypoziomG, nowypoziomB);
                nowypoczatekKoloru = sp.getInt("poczatek_koloru", nowyKolor);

                data.putExtra("rozmiar_tekstu", nowyRozmiarTekstu);
                data.putExtra("kolor", nowypoczatekKoloru);

                setResult(RESULT_OK,data);
                finish();
            }
        });

        Button resetButton = (Button) findViewById(R.id.button4);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextSize(rozmiarTekstu);
                sbR.setProgress(poziomR);
                sbG.setProgress(poziomG);
                sbB.setProgress(poziomB);
                radioGroup.check(nrWyboruRozmiaru);
                view.setBackgroundColor(poczatekKoloru);
                opcje.setSelection(nrWyboruPrywitania);
            }
        });

        opcje.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int item = opcje.getSelectedItemPosition();
                spe.putInt("nr_przywitania", item);
                //spe.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rozmiarTekstu = 14;
                int id = group.getCheckedRadioButtonId();
                switch (id) {
                    case R.id.radioButton: rozmiarTekstu = 14;
                        break;
                    case R.id.radioButton2: rozmiarTekstu = 18;
                        break;
                    case R.id.radioButton3: rozmiarTekstu = 22;
                    default:
                        break;
                }

                textView.setTextSize(rozmiarTekstu);
                spe.putInt("rozmiar_tekstu", rozmiarTekstu);
                spe.putInt("nr_rozmiaru", id);
                //spe.commit();
            }
    });

        sbR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekR = progress;

                ChangeColor(view);
                spe.putInt("poziom_czerwony", progress);
                //spe.commit();
            }
        });

        sbG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekG = progress;

                spe.putInt("poziom_zielony", progress);
                //spe.commit();
                ChangeColor(view);
            }
        });

        sbB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekB = progress;

                spe.putInt("poziom_niebieski", progress);
                //spe.commit();
                ChangeColor(view);
            }
        });

    }

    private void ChangeColor(View view) {
        int color = Color.rgb(seekR, seekG, seekB);
        view.setBackgroundColor(color);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        TextView textView= (TextView) findViewById(R.id.textView);
        int rozmiarTekstu = 14;
        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioButton: rozmiarTekstu = 14;
                break;
            case R.id.radioButton2: rozmiarTekstu = 16;
                break;
            case R.id.radioButton3: rozmiarTekstu = 18;
            default:
                break;
        }

        textView.setTextSize(rozmiarTekstu);
    }


    public void uruchomJeden(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void reset(View view) {

    }
    public void opcjaBack(View view) {
        onBackPressed();
    }
}