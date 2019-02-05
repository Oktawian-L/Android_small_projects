package com.archiedev.optimus.cw3fragmenty;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class List1 extends Fragment {

    ArrayList<Osoba> listDb = new ArrayList<>();
    public List1() {

        // Required empty public constructor
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String mParam1 = "";
        String nameData = "";
        int ageData = 0;
        int priorityData = 0;
        int thirdData = 0;
        final Osoba osoba = new Osoba("Jan Kowalski", 22, 4);

        if (getArguments() != null) {
            mParam1 = getArguments().getString("params");
            nameData = getArguments().getString("name");
            ageData = getArguments().getInt("age");
            priorityData = getArguments().getInt("priority");
            thirdData = getArguments().getInt("getThirdData");
        }
        if (getArguments() == null) {
            mParam1 = "getArguments equals NULL";
        }

        if (thirdData != 0) {
            osoba.setName(nameData);
            osoba.setPriorytet(priorityData);
            osoba.setWiek(ageData);
            listDb.add(osoba);
        }

        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_list1, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list);

        listView.setAdapter(new OsobaAdapter(this.getContext(), listDb));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent,
                                    View view, int position,
                                    long id) {

                Intent j = new Intent(view.getContext(), PersonDetails.class);
                j.putExtra("sampleObject", (Osoba)parent.getItemAtPosition(position));
                startActivity(j);
            }
        });
        return view;
    }

}
