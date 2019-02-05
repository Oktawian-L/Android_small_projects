package com.archiedev.optimus.adapterytresci;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int request_Value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void uruchomDwa(View view) {
        final Intent intencja2 = new Intent(this,Activity2.class);
        startActivityForResult(intencja2, request_Value);
    }

    public void uruchomTrzy(View view) {
        final Intent intencja3 = new Intent(this,Activity3.class);
        startActivity(intencja3);
    }

    public void uruchomCztery(View view) {
        final Intent intencja4 = new Intent(this,Activity4.class);
        startActivity(intencja4);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        int rozmiarTekstu = data.getIntExtra("rozmiar_tekstu", 14);
        int kolor = data.getIntExtra("kolor", Color.rgb(0,0,0));
        zmienTekst(rozmiarTekstu, kolor);
    }

    public void zmienTekst(int rozmiarTkestu, int kolorTekstu) {
        TextView textView = (TextView) findViewById(R.id.textView2test);
        TextView textView3 = (TextView) findViewById(R.id.textView3test);
        textView.setTextSize(rozmiarTkestu);
        textView3.setTextSize(rozmiarTkestu);
        textView3.setTextColor(kolorTekstu);
    }
}