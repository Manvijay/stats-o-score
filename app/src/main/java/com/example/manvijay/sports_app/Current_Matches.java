package com.example.manvijay.sports_app;

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
 * {@link Current_Matches.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Current_Matches#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Current_Matches extends Fragment {
   
    RecyclerView mrecycler1,mrecycler2,mrecycler3;
    RecyclerView.LayoutManager mlayout1,mlayout2,mlayout3;
    RecyclerView.Adapter madapter1,madapter2,madapter3;
    ArrayList<String> list1,list2,list3;

    public static Current_Matches newInstance() {
        Current_Matches fragment = new Current_Matches();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



       /* list1 = new ArrayList<>();
       // mrecycler1 = (RecyclerView) getView().findViewById(R.id.recycle1);

        mrecycler1.setHasFixedSize(true);
        mlayout1 = new LinearLayoutManager(getActivity());
        madapter1 = new MainAdapter(list1);
        mrecycler1.setLayoutManager(mlayout1);
        mrecycler1.setAdapter(madapter1);
*/

        





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_current__matches, container, false);
        mrecycler1 = rootView.findViewById(R.id.recycle1);
        mrecycler2 = rootView.findViewById(R.id.recycle2);
        mrecycler3 = rootView.findViewById(R.id.recycle3);
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();
        list1.add("Flick Right To see Score Cards");
        list1.add("IND vs SA" + "\n IND 140/2 (Over 60)");
        list1.add("ENG vs AUS" + " \n AUS 260/9 (Over 56.2)");
        list1.add("WI vs BAN" + " \n WI 110/5 (Over 75.2)");
        list1.add("ZIM vs PAK" + " \n PAK 111/9 (Over 88.1)");
        list2.add("Flick Right To see Score Cards");
        list2.add("SL vs IRE" + "\n SL 200/3 (Over 48)");
        list2.add("AFG vs SCO" + " \n SCO 360/9 (Over 50)");
        list2.add("UAE vs NETH" + " \n UAE 112/5 (Over 27)");
        list2.add("HKG vs OMN" + " \n HKG 90/7 (Over 28.1)");
        list3.add("Flick Right To see Score Cards");
        list3.add("IND vs PAK" + "\n Ind 140/2 (Over 19)");
        list3.add("ENG vs SL" + " \n SL 260/9 (Over 20)");
        list3.add("WI vs BAN" + " \n WI 190/5 (Over 18.5)");
        list3.add("ZIM vs AFG" + " \n ZIM 90/2 (Over 16.3)");

        mrecycler1.setHasFixedSize(true);
        mrecycler2.setHasFixedSize(true);
        mrecycler3.setHasFixedSize(true);
        mlayout1 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mlayout2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mlayout3 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        madapter1 = new MainAdapter(list1);
        madapter2 = new MainAdapter(list2);
        madapter3 = new MainAdapter(list3);
        mrecycler1.setLayoutManager(mlayout1);
        mrecycler1.setAdapter(madapter1);
        mrecycler2.setLayoutManager(mlayout2);
        mrecycler2.setAdapter(madapter2);
        mrecycler3.setLayoutManager(mlayout3);
        mrecycler3.setAdapter(madapter3);


        return rootView;
    }
;
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
