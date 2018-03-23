package com.example.manvijay.sports_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import junit.framework.Test;


public class TestRankings extends Fragment {


    public TestRankings() {
        // Required empty public constructor
    }

    public static TestRankings newInstance() {
        TestRankings fragment = new TestRankings();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test_rankings, container, false);
    }


}
