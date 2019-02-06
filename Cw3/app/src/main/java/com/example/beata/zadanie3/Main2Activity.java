package com.example.beata.zadanie3;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements ActionBar.TabListener {

    private Fragment11 f11;
    private Fragment12 f12;
    private FragmentTransaction transakcja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        f11 = new Fragment11();
        f12 = new Fragment12();
        transakcja = getSupportFragmentManager().beginTransaction();
        transakcja.add(R.id.kontener2, f11);
        transakcja.detach(f11);
        transakcja.add(R.id.kontener2, f12);
        transakcja.detach(f12);
        transakcja.commit();

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        actionBar.addTab(actionBar.newTab().setText("Fragment 1.1").setTabListener(this).setTag(1));
        actionBar.addTab(actionBar.newTab().setText("Fragment 1.2").setTabListener(this).setTag(2));

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        int index = (int) tab.getTag();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case 1: {
                transaction.attach(f11);
                break;
            }
            case 2: {
                transaction.attach(f12);
                break;
            }
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        int index = (int) tab.getTag();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case 1: {
                transaction.detach(f11);
                break;
            }
            case 2: {
                transaction.detach(f12);
                break;
            }
        }
        transaction.commit();
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Toast.makeText(getApplicationContext(), "Jesteś tutaj", Toast.LENGTH_SHORT).show();
    }

}
