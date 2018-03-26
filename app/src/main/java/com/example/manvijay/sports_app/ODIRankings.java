package com.example.manvijay.sports_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
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

import java.util.HashMap;
import java.util.Map;


public class ODIRankings extends Fragment {

    TextView text1,text2,text3,text4,text5,text6,text7;
    RequestQueue req1;
    String baseUrl = "http://api.football-data.org/v1/competitions/455/leagueTable";
    String disp = "",disp2 = "",disp3 = "",disp4 = "",disp5 = "",disp6 = "",disp7 = "";


    public ODIRankings() {
        // Required empty public constructor
    }

    public static ODIRankings newInstance() {
        ODIRankings fragment = new ODIRankings();
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
        View rootview = inflater.inflate(R.layout.fragment_odirankings, container, false);
        this.text1 = rootview.findViewById(R.id.ligatext);
        this.text2 = rootview.findViewById(R.id.ligatext2);
        this.text3 = rootview.findViewById(R.id.ligatext3);
        this.text4 = rootview.findViewById(R.id.ligatext4);
        this.text5 = rootview.findViewById(R.id.ligatext5);
        this.text6 = rootview.findViewById(R.id.ligatext6);
        this.text7 = rootview.findViewById(R.id.ligatext7);
        req1 = Volley.newRequestQueue(getActivity());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest (Request.Method.GET, baseUrl, null, new Response.Listener<JSONObject>(){

            @Override

            public void onResponse(JSONObject response) {

                // Check the length of our response (to see if the user has any repos)

                if (response.length() > 0) {

                    // The user does have repos, so let's loop through them all.
                    JSONArray jsonarr = null;
                    try {
                        jsonarr = response.getJSONArray("standing");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    for (int i = 0; i < 20; i++) {

                        try {

                            // For each repo, add a new line to our repo list.
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
                    setval(disp,disp2,disp3,disp4,disp5,disp6,disp7);

                } else {

                    // The user didn't have any repos.

                    setval("No repos found.");
                }
            }
        },

                new Response.ErrorListener() {

                    @Override

                    public void onErrorResponse(VolleyError error) {

                        // If there a HTTP error then add a note to our repo list.

                        setval("Error while calling REST API");

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


        // Add the request we just defined to our request queue.

        // The request queue will automatically handle the request as soon as it can.
        req1.add(jsonObjectRequest);


        return rootview;
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
