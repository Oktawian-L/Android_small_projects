package com.archiedev.optimus.cw3fragmenty;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener {
    AppCompatActivity A1;
    OnWyborOpcjiListener sluchaczF1;

    Fragment11 f11;
    Fragment12 f12;
    FragmentTransaction transakcja;

    private static final String TAG_F11 = "Fragment11";
    private static final String TAG_F12 = "Fragment12";

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int id = group.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioButton: sluchaczF1.onWyborOpcji(1);
                break;
            case R.id.radioButton2: sluchaczF1.onWyborOpcji(2);
                break;
            default:
                break;
        }
    }

    public interface OnWyborOpcjiListener {
        public void onWyborOpcji(int opcja);
    }

    public Fragment1() {
        // Required empty public constructor

    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (savedInstanceState == null) {
            f11 = new Fragment11();
            f12 = new Fragment12();
            transakcja = getChildFragmentManager().beginTransaction();
            transakcja.add(R.id.kontener, f11, TAG_F11);
            transakcja.detach(f11);
            transakcja.add(R.id.kontener, f12, TAG_F12);
            transakcja.detach(f12);
            transakcja.commit();
        }
        else {
            f11=(Fragment11) getChildFragmentManager().findFragmentByTag(TAG_F11);
            f12=(Fragment12) getChildFragmentManager().findFragmentByTag(TAG_F12);
        }

        ((RadioGroup) getActivity().findViewById(R.id.opcje)).
                setOnCheckedChangeListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setRetainInstance(true);
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            A1 = (AppCompatActivity) context;
            sluchaczF1 = (OnWyborOpcjiListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(A1.toString() +
                    " musi implementować OnWyborOpcjiListener");
        }
    }


}