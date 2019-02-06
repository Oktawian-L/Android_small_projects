package com.example.beata.zadanie32;



import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment1 extends Fragment implements RadioGroup.OnCheckedChangeListener{

    private AppCompatActivity A1;
    private OnWyborOpcjiListener sluchaczF1;

    public fragment1() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            A1 = (AppCompatActivity) context;
            sluchaczF1 = (OnWyborOpcjiListener) context;
        }
        catch (ClassCastException e) {
            throw new ClassCastException(A1.toString() + " musi implementowac OnWyborOpcjiListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        RadioGroup radioGroup = getActivity().findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(this);
    }

    public void onCheckedChanged(RadioGroup radioGroup, int i){
        switch (i){
            case R.id.radio1:{
                sluchaczF1.onWyborOpcji(1);
                break;
            }
            case R.id.radio2:{
                sluchaczF1.onWyborOpcji(2);
                break;
            }

        }
    }
    public interface OnWyborOpcjiListener{
        void onWyborOpcji (int opcja);
    }



}