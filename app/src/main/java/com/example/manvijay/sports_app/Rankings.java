package com.example.manvijay.sports_app;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Rankings.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Rankings#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Rankings extends Fragment {
    ArrayList<String> mylist;
    RecyclerView myrecycle;
    RecyclerView.LayoutManager mylayout;
    RecyclerView.Adapter myadapter;

    //private static final String TAG = "Rankings";
    public static Rankings newInstance() {

        Rankings fragment= new Rankings();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        final View view=inflater.inflate(R.layout.fragment_rankings, container, false);
        Typeface tf= Typeface.createFromAsset(getActivity().getAssets(),"Comfortaa-Regular.ttf");
        final TabLayout tl=(TabLayout) view.findViewById(R.id.tabs);
        //setting names of Tabs in Standings page of app. This is for fragments_ranking.xml file

        tl.addTab(tl.newTab().setText("EPL"));
        tl.addTab(tl.newTab().setText("La Liga"));
        tl.addTab(tl.newTab().setText("Bundesliga"));
        tl.setTabTextColors(ColorStateList.valueOf(Color.WHITE));


        //Adding custom font to all tablayouts
            ViewGroup vg = (ViewGroup) tl.getChildAt(0);
            int tabsCount = vg.getChildCount();

            for (int j = 0; j < tabsCount; j++) {
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

                int tabChildsCount = vgTab.getChildCount();

                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        //Put your font in assests folder
                        //assign name of the font here (Must be case sensitive)
                        ((TextView) tabViewChild).setTypeface(tf);
                    }
                }
            }


        tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                FragmentTransaction transaction= getFragmentManager().beginTransaction();
                //switch case to open the pages for different tabs when clicked on
                switch (tab.getPosition()){                          //getting id of clicked tab from fragment_ranking.xml

                    case 0: transaction.replace(R.id.frame, TestRankings.newInstance());
                            transaction.commit();
                            break;
                    case 1: transaction.replace(R.id.frame, ODIRankings.newInstance());
                            transaction.commit();
                            break;
                    case 2: transaction.replace(R.id.frame, T20Rankings.newInstance());
                            transaction.commit();

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        FragmentTransaction transaction= getFragmentManager().beginTransaction();
        transaction.replace(R.id.frame, TestRankings.newInstance());
        transaction.commit();
        return view;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
