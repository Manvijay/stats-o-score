package com.example.manvijay.sports_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class T20Rankings extends Fragment {


    public T20Rankings() {
        // Required empty public constructor
    }

    public static T20Rankings newInstance() {
        T20Rankings fragment = new T20Rankings();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_t20_rankings, container, false);
    }


}
