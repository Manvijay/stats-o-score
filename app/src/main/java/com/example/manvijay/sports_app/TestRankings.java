package com.example.manvijay.sports_app;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;

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


public class TestRankings extends Fragment {

    TextView text1,text2,text3,text4,text5,text6,text7;
    TextView pos1, team1, pg1, w1, l1, d1, pts1;
    RequestQueue req1;
    String baseUrl = "http://api.football-data.org/v1/competitions/445/leagueTable";  // api url for getting standings from EPL
    String disp = "",disp2 = "",disp3 = "",disp4 = "",disp5 = "",disp6 = "",disp7 = "";
    //ListView listView;
    //ItemArrayAdapter itemArrayAdapter;

    public TestRankings() {
        // Required empty public constructor
    }

    public static TestRankings newInstance() {
        TestRankings fragment = new TestRankings();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Toast.makeText(getActivity().getApplicationContext(), "Loading ..",
                Toast.LENGTH_SHORT).show();

        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "Comfortaa-Regular.ttf");

        View rootview = inflater.inflate(R.layout.fragment_test_rankings, container, false);
        this.text1 = rootview.findViewById(R.id.epltext);
        this.text2 = rootview.findViewById(R.id.epltext2);
        this.text3 = rootview.findViewById(R.id.epltext3);
        this.text4 = rootview.findViewById(R.id.epltext4);
        this.text5 = rootview.findViewById(R.id.epltext5);
        this.text6 = rootview.findViewById(R.id.epltext6);
        this.text7 = rootview.findViewById(R.id.epltext7);
        req1 = Volley.newRequestQueue(getActivity());

        this.text1.setTypeface(tf);
        this.text2.setTypeface(tf);
        this.text3.setTypeface(tf);
        this.text4.setTypeface(tf);
        this.text5.setTypeface(tf);
        this.text6.setTypeface(tf);
        this.text7.setTypeface(tf);

        pos1 = rootview.findViewById(R.id.pos);
        team1 = rootview.findViewById(R.id.Team);
        pg1 = rootview.findViewById(R.id.pg);
        w1 = rootview.findViewById(R.id.w);
        l1 = rootview.findViewById(R.id.l);
        d1 = rootview.findViewById(R.id.d);
        pts1 = rootview.findViewById(R.id.pts);

        pos1.setTypeface(tf);
        team1.setTypeface(tf);
        pg1.setTypeface(tf);
        w1.setTypeface(tf);
        l1.setTypeface(tf);
        d1.setTypeface(tf);
        pts1.setTypeface(tf);
        
        
        //api call for getting team standings for EPL
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, baseUrl, null, new Response.Listener<JSONObject>(){

            @Override

            public void onResponse(JSONObject response) {

                // Check the length of our response

                if (response.length() > 0) {

                    //if we did receive some response
                    JSONArray jsonarr = null;
                    try {
                        jsonarr = response.getJSONArray("standing");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    for (int i = 0; i < 20; i++) {

                        try {

                            // FOr each JsonObject we put the key value in a separate string to displayed later
                            JSONObject temp = jsonarr.getJSONObject(i);
                            disp = disp + temp.get("position").toString() + "\n\n";
                            disp2 = disp2 + temp.get("teamName").toString()  + "\n\n";
                            disp3 = disp3 +  temp.get("playedGames").toString() + "\n\n";
                            disp4 = disp4 +  temp.get("wins").toString()+ "\n\n";
                            disp5 = disp5 + temp.get("draws").toString()+ "\n\n";
                            disp6 = disp6 + temp.get("losses").toString()+ "\n\n";
                            disp7 = disp7 + temp.get("points").toString()+ "\n\n" ;



                        } catch (JSONException e) {

                            // If there is an error then output this to the logs.

                            Log.e("Volley", "Invalid JSON Object.");

                        }
                    }
                    //function to use the string created before and display it in fragment_test_rankings.xml i.e. EPL Tab
                    setval(disp,disp2,disp3,disp4,disp5,disp6,disp7);

                } else {

                    // if we did not recieve any response

                    Toast.makeText(getActivity().getApplicationContext(), "Offline Turn On Connection",
                            Toast.LENGTH_SHORT).show();

                    //setval("No repos found.");
                }
            }
        },

                new Response.ErrorListener() {

                    @Override

                    public void onErrorResponse(VolleyError error) {

                        // If there a HTTP error 
                        Toast.makeText(getActivity().getApplicationContext(), "Too many Request Or Offline",
                                Toast.LENGTH_SHORT).show();

                        //setval("Error while calling REST API");

                        Log.e("Volley", error.toString());

                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-Auth-Token", "7b9128b9cf7e4742b7b153482537f93d");

                return params;
            }
        };

        // Add the api request we just defined to our request queue.

        
        req1.add(jsonObjectRequest);
        return rootview;
    }

    private void cleartext() {

        this.text1.setText("Display EPL Rankings");

    }

    private void setval(String x,String x1,String x2,String x3,String x4,String x5,String x6){

        this.text1.setText(x);
        this.text2.setText(x1);
        this.text3.setText(x2);
        this.text4.setText(x3);
        this.text5.setText(x4);
        this.text6.setText(x5);
        this.text7.setText(x6);
    }

    private void setval(String x){

        this.text2.setText(x);

    }





}
