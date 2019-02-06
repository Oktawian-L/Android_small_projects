package com.example.beata.zadanie32;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements fragment1.OnWyborOpcjiListener {

    private fragment11 f11;
    private fragment12 f12;
    private FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        f11 = new fragment11();
        f12 = new fragment12();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener, f12);
        transakcja.detach(f12);
        transakcja.attach(f11);
        transakcja.commit();


    }

    @Override
    public void onWyborOpcji(int opcja) {
        FragmentTransaction transakcja = getSupportFragmentManager().beginTransaction();
        switch (opcja){
            case 1:{
                transakcja.detach(f12);
                transakcja.attach(f11);
                break;
            }
            case 2:{
                transakcja.detach(f11);
                transakcja.attach(f12);
                break;
            }
        }
        transakcja.commit();
    }


}

