package com.example.abhi.alpha;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class Tab1 extends Fragment {

    ArrayList<HashMap<String, String>> myValues;
    private String URL = "https://gist.githubusercontent.com/awadhawan18/54592d9ec5e7be1b39013cdd7e78dae4/raw/54a90fe99b8e821e273e1997f356d04308bdb232/Random-images.json";
    private ProgressDialog pDialog;
    Button sort_1, sort_2, sort_3, sort_4, sort_5;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab1, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //gets the json data from gist and passes it to recycle view adapter
        myValues = new ArrayList<>();
        if (isNetworkOnline()) {
            //getJsonData();
        } else {
            alertDialog();
        }
        //sort buttons with different colors
        /*sort_1 = (Button) getView().findViewById(R.id.sort_1);
        sort_2 = (Button) getView().findViewById(R.id.sort_2);
        sort_3 = (Button) getView().findViewById(R.id.sort_3);
        sort_4 = (Button) getView().findViewById(R.id.sort_4);
        sort_5 = (Button) getView().findViewById(R.id.sort_5);
        //adds different colors to buttons.
        changeColor(sort_1, "#19d1b8");
        changeColor(sort_2, "#ef481f");
        changeColor(sort_3, "#1e6eef");
        changeColor(sort_4, "#1eef24");
        changeColor(sort_5, "#ef1ec5");*/

        //floating action menu with listeners



    }

    //gets the json file from github gist using HttpHandle and converts in into json
    //populated by recycler view adapter
    public void getJsonData() {
        pDialog = new ProgressDialog(getContext());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();

        RequestQueue queue = MySingleton.getInstance(getContext()).
                getRequestQueue();
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject jsonObj = new JSONObject(String.valueOf(response));
                            JSONArray cards = jsonObj.getJSONArray("sample");
                            for (int i = 0; i < cards.length(); i++) {
                                JSONObject c = cards.getJSONObject(i);
                                String description = c.getString("description");
                                String image_url = c.getString("image-url");
                                HashMap<String, String> samples = new HashMap<>();
                                samples.put("description", description);
                                samples.put("image-url", image_url);
                                myValues.add(samples);
                            }


                        } catch (final JSONException e) {

                        } finally {
                            if (pDialog.isShowing())
                                pDialog.dismiss();
                            RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), myValues);
                            RecyclerView myView = getView().findViewById(R.id.recyclerview);
                            myView.setHasFixedSize(true);
                            myView.setAdapter(adapter);
                            LinearLayoutManager llm = new LinearLayoutManager(getContext());
                            llm.setOrientation(LinearLayoutManager.VERTICAL);
                            myView.setLayoutManager(llm);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("Error main_activity", error.toString());
                        Toast.makeText(getContext(), "Sorry Couldn't fetch data", Toast.LENGTH_SHORT).show();

                    }
                });
        queue.add(jsObjRequest);

    }

    //checks network connection
    public boolean isNetworkOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;

    }

    //Dialog box opens when no network detected
    public void alertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(
                "Unable to reach server, \nPlease check your connectivity.")
                .setTitle("Network not detected")
                .setCancelable(false)
                .setPositiveButton("Exit",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                //loader.cancel(true);

                            }
                        })
                .setNegativeButton("Try Again",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                if (isNetworkOnline()) {
                                   // getJsonData();
                                } else alertDialog();
                            }
                        });


        AlertDialog alert = builder.create();

        alert.show();
    }

    //changes the color of each button
    public void changeColor(Button id, String color) {
        Drawable roundDrawable1 = getResources().getDrawable(R.drawable.round_buttons);
        roundDrawable1.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        id.setBackground(roundDrawable1);
    }

}
