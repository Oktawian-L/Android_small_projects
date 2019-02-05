package com.archiedev.optimus.adapterytresci;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.archiedev.optimus.adapterytresci.FeedReaderContract.FeedEntry;
import java.util.ArrayList;
import java.util.List;

import static com.archiedev.optimus.adapterytresci.FeedReaderContract.FeedEntry.COLUMN_NAME_AGE;
import static com.archiedev.optimus.adapterytresci.FeedReaderContract.FeedEntry.COLUMN_NAME_PRIORITY;
import static com.archiedev.optimus.adapterytresci.FeedReaderContract.FeedEntry.COLUMN_NAME_GENDER;
import static com.archiedev.optimus.adapterytresci.FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE;

public class Activity4 extends AppCompatActivity {

    ArrayList<Osoba> listDb = new ArrayList<>();
    FeedReaderContract.FeedReaderDbHelper mDbHelper = new FeedReaderContract.FeedReaderDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        SQLiteDatabase db1 = mDbHelper.getReadableDatabase();

        final Intent i = getIntent();
        final Osoba osoba = (Osoba)i.getSerializableExtra("sampleObject");

        if (osoba != null) {
            ContentValues values = new ContentValues();
            values.put(COLUMN_NAME_TITLE, osoba.getName());
            values.put(COLUMN_NAME_AGE, osoba.getWiek());
            values.put(COLUMN_NAME_GENDER, String.valueOf(osoba.getPlec()));
            values.put(COLUMN_NAME_PRIORITY, osoba.getPriorytet());

            // Create a new map of values, where column names are the keys

            // Insert the new row, returning the primary key value of the new row
            long newRowId = db.insert(FeedEntry.TABLE_NAME, null, values);
        }


        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        Cursor  cursor = db1.rawQuery("select * from entry",null);

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String name2 = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_GENDER));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME_TITLE));
                int age = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_AGE));
                char genderFromDb = name2.charAt(0);
                int priority = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_PRIORITY));
                Osoba osoba1 = new Osoba("Jan Kowalski", 22, 4, 'M');
                osoba1.setName(name);
                osoba1.setWiek(age);
                osoba1.setPlec(genderFromDb);
                osoba1.setPriorytet(priority);
                listDb.add(osoba1);
                cursor.moveToNext();
            }
        }

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(new OsobaAdapter(this, listDb));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent,
                                    View view, int position,
                                    long id) {

                Intent j = new Intent(view.getContext(), PersonDetails.class);
                j.putExtra("sampleObject", osoba);
                startActivity(j);
            }
        });
        //Osoba osoba = (Osoba)i.getSerializableExtra("sampleObject");

        //TextView dane = (TextView) findViewById(R.id.textView9);
        //dane.setText(osoba.getName());
        //TextView wiek = (TextView) findViewById(R.id.textView7);
        //wiek.setText(Integer.toString(osoba.getWiek()));
        //TextView priorytet = (TextView) findViewById(R.id.textView10);
        //priorytet.setText(Integer.toString(osoba.getPriorytet()));
        //TextView plec = (TextView) findViewById(R.id.textView11);
        //plec.setText(String.valueOf(osoba.getPlec()));
    }

}