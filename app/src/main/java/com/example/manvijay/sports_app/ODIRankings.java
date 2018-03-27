package com.example.manvijay.sports_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class ODIRankings extends Fragment {


    public ODIRankings() {
        // Required empty public constructor
    }

    public static ODIRankings newInstance() {
        ODIRankings fragment = new ODIRankings();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_odirankings, container, false);
    }


}
