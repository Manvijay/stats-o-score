package com.example.manvijay.sports_app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootview = inflater.inflate(R.layout.fragment_rankings,container,false);
        myrecycle = rootview.findViewById(R.id.ranking_recycle);
        mylist = new ArrayList<>();
        mylist.add("TEST" +
                "\ndsadsa'" +
                "\ndasdsa" +
                "\nasdsad" +
                "\nasdas0");
        mylist.add("ODI");
        mylist.add("T20");
        //myrecycle.setHasFixedSize(true);

        mylayout = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        myadapter = new SecondAdapter(mylist);
        myrecycle.setLayoutManager(mylayout);
        myrecycle.setAdapter(myadapter);

        // Inflate the layout for this fragment
        return rootview;
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
