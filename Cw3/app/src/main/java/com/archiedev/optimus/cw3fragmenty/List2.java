package com.archiedev.optimus.cw3fragmenty;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class List2 extends Fragment {

    ArrayList<Pet> list2Db = new ArrayList<>();

    public List2() {

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
        char gatunekData = 'N';
        int thirdData2 = 0;
        final Pet pet = new Pet("Reksio", 22, 4, 'P');

        if (getArguments() != null) {
            mParam1 = getArguments().getString("params");
            nameData = getArguments().getString("name2");
            ageData = getArguments().getInt("age2");
            priorityData = getArguments().getInt("priority2");
            gatunekData = getArguments().getChar("gatunek");
            thirdData2 = getArguments().getInt("getThirdData2");
        }
        if (getArguments() == null) {
            mParam1 = "getArguments equals NULL";
        }

        if (thirdData2 != 0) {
            pet.setName(nameData);
            pet.setPriorytet(priorityData);
            pet.setWiek(ageData);
            pet.setGatunek(gatunekData);
            list2Db.add(pet);
        }

        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_list2, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list2);

        listView.setAdapter(new PetAdapter(this.getContext(), list2Db));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent,
                                    View view, int position,
                                    long id) {

                Intent j = new Intent(view.getContext(), PetDetails.class);
                j.putExtra("samplePet", (Pet) parent.getItemAtPosition(position));
                startActivity(j);
            }
        });
        return view;
    }
}