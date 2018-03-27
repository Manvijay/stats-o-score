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
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.android.volley.VolleyError;

import com.android.volley.Response;

import com.android.volley.Request;

import com.android.volley.toolbox.JsonArrayRequest;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;



import org.json.JSONArray;

import org.json.JSONObject;

import org.json.JSONException;
import junit.framework.Test;

import java.lang.reflect.Array;
import java.util.*;


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

    RequestQueue req1;
    String urlepl = "http://api.football-data.org/v1/competitions/445/fixtures/";
    String urlliga = "http://api.football-data.org/v1/competitions/455/fixtures/";
    String urlbundes = "http://api.football-data.org/v1/competitions/452/fixtures/";

    public static Current_Matches newInstance() {
        Current_Matches fragment = new Current_Matches();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Toast.makeText(getActivity().getApplicationContext(), "Loading Matches..",
                Toast.LENGTH_SHORT).show();

        View rootView = inflater.inflate(R.layout.fragment_current__matches, container, false);
        mrecycler1 = rootView.findViewById(R.id.recycle1);
        mrecycler2 = rootView.findViewById(R.id.recycle2);
        mrecycler3 = rootView.findViewById(R.id.recycle3);
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list3 = new ArrayList<>();

        req1 = Volley.newRequestQueue(getActivity());

        mrecycler1.setHasFixedSize(true);
        mrecycler2.setHasFixedSize(true);
        mrecycler3.setHasFixedSize(true);
        mlayout1 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mlayout2 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mlayout3 = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET,  urlepl, null, new Response.Listener<JSONObject>(){

            @Override

            public void onResponse(JSONObject response) {

                // Check the length of our response (to see if the user has any repos)

                if (response.length() > 0) {

                    // The user does have repos, so let's loop through them all.
                    JSONArray jsonarr = null;
                    Integer count = null;
                    try {
                        jsonarr = response.getJSONArray("fixtures");
                        count = response.getInt("count");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Date curr = Calendar.getInstance().getTime();
                    SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        curr = mdformat.parse(mdformat.format(curr));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(curr);
                    c.add(Calendar.DATE, 9);
                    Date currfut = c.getTime();
                    c.add(Calendar.DATE, -16);
                    curr = c.getTime();

                    for (int i = 0; i <= count; i++) {

                        try {

                            // For each repo, add a new line to our repo list.
                            JSONObject temp = jsonarr.getJSONObject(i);
                            String tempdate = temp.get("date").toString();
                            tempdate = tempdate.substring(0,10);
                            Date temp2 = mdformat.parse(tempdate);
                            if( (temp.get("status").toString().equals("FINISHED") || temp.get("status").toString().equals("IN_PLAY")) && temp2.after(curr) &&  temp2.before(currfut) ) {
                                JSONObject result = temp.getJSONObject("result");

                                list1.add(temp.get("homeTeamName").toString() + " " + result.get("goalsHomeTeam").toString() + "\n" + temp.get("awayTeamName").toString() + " " + result.get("goalsAwayTeam").toString());


                            }

                            if( (temp.get("status").toString().equals("SCHEDULED") || temp.get("status").toString().equals("TIMED")) && temp2.after(curr) &&  temp2.before(currfut) ) {
                                //JSONObject result = temp.getJSONObject("result");

                                list1.add(temp.get("homeTeamName").toString() + " " + "VS " + temp.get("awayTeamName").toString() + "\n" + temp.get("date").toString().substring(0,10));


                            }

                        } catch (JSONException e) {

                            // If there is an error then output this to the logs.

                            Log.e("Volley", "Invalid JSON Object.");

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    // add command here
                    madapter1 = new MainAdapter(list1);
                    mrecycler1.setLayoutManager(mlayout1);
                    mrecycler1.setAdapter(madapter1);

                } else {

                    // The user didn't have any repos.

                    list1.add("Too many requests, try after some time");
                }
            }
        },

                new Response.ErrorListener() {

                    @Override

                    public void onErrorResponse(VolleyError error) {

                        // If there a HTTP error then add a note to our repo list.

                        list1.add("Too many requests, try after some time");

                        Log.e("Volley", error.toString());

                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Auth-Token", " c1719e0814b54b13a2e1725eb778ed13");
                return params;
            }
        };

        JsonObjectRequest jsonObjectRequest1 = new JsonObjectRequest (Request.Method.GET,  urlliga, null, new Response.Listener<JSONObject>(){

            @Override

            public void onResponse(JSONObject response) {

                // Check the length of our response (to see if the user has any repos)

                if (response.length() > 0) {

                    // The user does have repos, so let's loop through them all.
                    JSONArray jsonarr = null;
                    Integer count = null;
                    try {
                        jsonarr = response.getJSONArray("fixtures");
                        count = response.getInt("count");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Date curr = Calendar.getInstance().getTime();
                    SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        curr = mdformat.parse(mdformat.format(curr));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(curr);
                    c.add(Calendar.DATE, 9);
                    Date currfut = c.getTime();
                    c.add(Calendar.DATE, -16);
                    curr = c.getTime();

                    for (int i = 0; i <= count; i++) {

                        try {

                            // For each repo, add a new line to our repo list.
                            JSONObject temp = jsonarr.getJSONObject(i);
                            String tempdate = temp.get("date").toString();
                            tempdate = tempdate.substring(0,10);
                            Date temp2 = mdformat.parse(tempdate);
                            if( (temp.get("status").toString().equals("FINISHED") || temp.get("status").toString().equals("IN_PLAY")) && temp2.after(curr) &&  temp2.before(currfut) ) {
                                JSONObject result = temp.getJSONObject("result");

                                list2.add(temp.get("homeTeamName").toString() + " " + result.get("goalsHomeTeam").toString() + "\n" + temp.get("awayTeamName").toString() + " " + result.get("goalsAwayTeam").toString());


                            }

                            if( (temp.get("status").toString().equals("SCHEDULED") || temp.get("status").toString().equals("TIMED")) && temp2.after(curr) &&  temp2.before(currfut) ) {
                                //JSONObject result = temp.getJSONObject("result");

                                list2.add(temp.get("homeTeamName").toString() + " " + "VS " + temp.get("awayTeamName").toString() + "\n" + temp.get("date").toString().substring(0,10));


                            }

                        } catch (JSONException e) {

                            // If there is an error then output this to the logs.

                            Log.e("Volley", "Invalid JSON Object.");

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    // add command here
                    madapter2 = new MainAdapter(list2);
                    mrecycler2.setLayoutManager(mlayout2);
                    mrecycler2.setAdapter(madapter2);

                } else {

                    // The user didn't have any repos.

                    list2.add("Too many requests, try after some time");
                }
            }
        },

                new Response.ErrorListener() {

                    @Override

                    public void onErrorResponse(VolleyError error) {

                        // If there a HTTP error then add a note to our repo list.

                        list2.add("Too many requests, try after some time");

                        Log.e("Volley", error.toString());

                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Auth-Token", " c1719e0814b54b13a2e1725eb778ed13");
                return params;
            }
        };

        JsonObjectRequest jsonObjectRequest2 = new JsonObjectRequest (Request.Method.GET,  urlbundes, null, new Response.Listener<JSONObject>(){

            @Override

            public void onResponse(JSONObject response) {

                // Check the length of our response (to see if the user has any repos)

                if (response.length() > 0) {

                    // The user does have repos, so let's loop through them all.
                    JSONArray jsonarr = null;
                    Integer count = null;
                    try {
                        jsonarr = response.getJSONArray("fixtures");
                        count = response.getInt("count");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    Date curr = Calendar.getInstance().getTime();
                    SimpleDateFormat mdformat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        curr = mdformat.parse(mdformat.format(curr));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    Calendar c = Calendar.getInstance();
                    c.setTime(curr);
                    c.add(Calendar.DATE, 9);
                    Date currfut = c.getTime();
                    c.add(Calendar.DATE, -16);
                    curr = c.getTime();

                    for (int i = 0; i <= count; i++) {

                        try {

                            // For each repo, add a new line to our repo list.
                            JSONObject temp = jsonarr.getJSONObject(i);
                            String tempdate = temp.get("date").toString();
                            tempdate = tempdate.substring(0,10);
                            Date temp2 = mdformat.parse(tempdate);
                            if( (temp.get("status").toString().equals("FINISHED") || temp.get("status").toString().equals("IN_PLAY")) && temp2.after(curr) &&  temp2.before(currfut) ) {
                                JSONObject result = temp.getJSONObject("result");

                                list3.add(temp.get("homeTeamName").toString() + " " + result.get("goalsHomeTeam").toString() + "\n" + temp.get("awayTeamName").toString() + " " + result.get("goalsAwayTeam").toString());


                            }

                            if( (temp.get("status").toString().equals("SCHEDULED") || temp.get("status").toString().equals("TIMED")) && temp2.after(curr) &&  temp2.before(currfut) ) {
                                //JSONObject result = temp.getJSONObject("result");

                                list3.add(temp.get("homeTeamName").toString() + " " + "VS " + temp.get("awayTeamName").toString() + "\n" + temp.get("date").toString().substring(0,10));


                            }

                        } catch (JSONException e) {

                            // If there is an error then output this to the logs.

                            Log.e("Volley", "Invalid JSON Object.");

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    // add command here
                    madapter3 = new MainAdapter(list3);
                    mrecycler3.setLayoutManager(mlayout3);
                    mrecycler3.setAdapter(madapter3);

                } else {

                    // The user didn't have any repos.

                    list3.add("Too many requests, try after some time");
                }
            }
        },

                new Response.ErrorListener() {

                    @Override

                    public void onErrorResponse(VolleyError error) {

                        // If there a HTTP error then add a note to our repo list.

                        list3.add("Too many requests, try after some time");

                        Log.e("Volley", error.toString());

                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Auth-Token", " c1719e0814b54b13a2e1725eb778ed13");
                return params;
            }
        };

        req1.add(jsonObjectRequest);
        req1.add(jsonObjectRequest1);
        req1.add(jsonObjectRequest2);
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
