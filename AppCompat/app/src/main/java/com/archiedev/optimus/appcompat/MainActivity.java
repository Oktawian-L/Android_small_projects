package com.archiedev.optimus.appcompat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.net.DatagramPacket;

public class MainActivity extends AppCompatActivity {

    int request_Value = 14;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void uruchomDwa(View view) {
        final Intent intencja2 = new Intent(this,Activity2.class);
        startActivity(intencja2);
        startActivityForResult(intencja2, request_Value);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == request_Value){
            if(resultCode == RESULT_OK){
                Toast.makeText(this,data.getData().toString(),Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void uruchomTrzy(View view) {
        final Intent intencja3 = new Intent(this,Activity3.class);
        startActivity(intencja3);
    }

    public void uruchomCztery(View view) {
        final Intent intencja4 = new Intent(this,Activity4.class);
        startActivity(intencja4);
    }
}