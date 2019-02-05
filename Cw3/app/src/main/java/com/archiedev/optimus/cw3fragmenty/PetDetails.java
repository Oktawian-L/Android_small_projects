package com.archiedev.optimus.cw3fragmenty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PetDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        final Intent i = getIntent();
        Pet pet = (Pet)i.getSerializableExtra("samplePet");

        TextView dane = (TextView) findViewById(R.id.petTextViewName);
        dane.setText(pet.getName());
        TextView wiek = (TextView) findViewById(R.id.petTextViewAge);
        wiek.setText("Wiek: " + Integer.toString(pet.getWiek()));
        int rozmiar = pet.getPriorytet();
        String textRozmiar = "Mały";
        if (rozmiar == 2)
            textRozmiar = "Średni";
        if (rozmiar == 3)
            textRozmiar = "Duży";

        TextView priorytet = (TextView) findViewById(R.id.petTextViewLevel);
        priorytet.setText(textRozmiar);
        ImageView gatunekImg = (ImageView) findViewById(R.id.imageView);
        if (pet.getGatunek()=='P') {
            gatunekImg.setImageResource(R.drawable.dog);
        }
        else {
            gatunekImg.setImageResource(R.drawable.cat);
        }
    }

    public void done(View view) {
        onBackPressed();
    }

}
