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
                "\n\nRank     Team         Ratings      Points" +
                "\n\n1        IND           121           5313" +
                "\n\n2        SA            115           4484" +
                "\n\n 3        AUS          104           4174" +
                "\n\n4        NZ            100           3489" +
                "\n\n5        ENG           99           4829" +
                "\n\n6        SLA            95           4374" +
                "\n\n7        PAK            88           2988" +
                "\n\n8       WI               72           2606" +
                "\n\n9        BAN            71           1833"


        );
        mylist.add("ODI" +
                "\n\nRank     Team         Ratings      Points" +
                "\n\n1        IND           122           7594" +
                "\n\n2        SA            117           6911" +
                "\n\n 3        AUS          116           6871" +
                "\n\n4        NZ            115           6550" +
                "\n\n5        ENG           112           6376" +
                "\n\n6        SLA            95           4374" +
                "\n\n7        PAK            88           2988" +
                "\n\n8       WI               72           2606" +
                "\n\n9        BAN            71           1833"



        );
        mylist.add("T20" +
                "\n\nRank     Team         Ratings      Points" +
                "\n\n1        IND           111           8313" +
                "\n\n2        NZ            110           4484" +
                "\n\n 3        AUS          104           3174" +
                "\n\n4        SA            101           3089" +
                "\n\n5        ENG           99           2829" +
                "\n\n6        SLA            95           2374" +
                "\n\n7        BAN            88           2188" +
                "\n\n8       WI               72           2006" +
                "\n\n9        PAK            71           1833"

        );
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
