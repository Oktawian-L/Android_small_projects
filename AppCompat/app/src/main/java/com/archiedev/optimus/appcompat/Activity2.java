package com.archiedev.optimus.appcompat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Activity2 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.opcje);
        radioGroup.setOnCheckedChangeListener(this);

        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setKeyListener(null);


        Button toastButton = (Button) findViewById(R.id.button2);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String napis = "";
                RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                napis += "Wybrana opcja: " + radioButton.getText().toString() + " , " + textView.getText().toString();

                Toast.makeText(getApplicationContext(),
                        napis,
                        Toast.LENGTH_SHORT).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    public void changeTextView(View view) {
        TextView textView = (TextView) findViewById(R.id.textView);

        if (textView.getText().toString().equals(getString(R.string.text1)))
            textView.setText(R.string.text2);
        else
            if (textView.getText().toString().equals(getString(R.string.text2)))
                textView.setText(R.string.text3);
        else
            if (textView.getText().toString().equals(getString(R.string.text3)))
                textView.setText(R.string.text1);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioButton: imageView.setImageResource(R.drawable.img2);
                break;
            case R.id.radioButton2: imageView.setImageResource(R.drawable.img1);
                break;
            default:
                break;
        }
    }

    public void uruchomJeden(View view) {
        onBackPressed();
    }
}
