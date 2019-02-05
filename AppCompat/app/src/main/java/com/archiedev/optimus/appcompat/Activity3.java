package com.archiedev.optimus.appcompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
    }

    public void toast(View view) {
        TextView tekst = findViewById(R.id.editText2);
        TextView email = findViewById(R.id.email);
        TextView liczba = findViewById(R.id.liczba);
        TextView phone = findViewById(R.id.phone);


        String napis = "";

        napis += "Tekst: " + tekst.getText().toString() + " \nemail: " + email.getText().toString() + " \nliczba: " + liczba.getText().toString() + " \nphone: " + phone.getText().toString();

        Toast.makeText(getApplicationContext(),
                napis,
                Toast.LENGTH_SHORT).show();
    }
    public void uruchomJeden(View view) {
        onBackPressed();
    }
}