package com.example.abhi.alpha;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;


import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    FloatingActionMenu materialDesignFAM;
    Button sort_1,sort_2,sort_3,sort_4,sort_5;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3;
    ArrayList<HashMap<String, String>> myValues;
    private ProgressDialog pDialog;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        myValues = new ArrayList<>();
        if(isNetworkOnline()){
            new getJsonData().execute();
        }
        else{
            alertDialog();
        }

        sort_1 = (Button)findViewById(R.id.sort_1);
        sort_2 = (Button)findViewById(R.id.sort_2);
        sort_3 = (Button)findViewById(R.id.sort_3);
        sort_4 = (Button)findViewById(R.id.sort_4);
        sort_5 = (Button)findViewById(R.id.sort_5);

        changeColor(sort_1,"#19d1b8");
        changeColor(sort_2,"#ef481f");
        changeColor(sort_3,"#1e6eef");
        changeColor(sort_4,"#1eef24");
        changeColor(sort_5,"#ef1ec5");
        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.material_design_android_floating_action_menu);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item1);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item2);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.material_design_floating_action_menu_item3);

        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked

            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.sign_in:
                startActivity(new Intent(getApplicationContext(),sign_in.class));
                return true;
            case R.id.add:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = MotionEventCompat.getActionMasked(event);
        switch (action){
            case(MotionEvent.ACTION_UP):
                Toast.makeText(getApplicationContext(),"Up action",Toast.LENGTH_SHORT).show();
                getSupportActionBar().hide();
                return true;
            case(MotionEvent.ACTION_DOWN):
                Toast.makeText(getApplicationContext(),"Down action",Toast.LENGTH_SHORT).show();
                getSupportActionBar().show();
                return true;
        }
        return super.onTouchEvent(event);
    }

    private class getJsonData extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {

            HttpHandler sh = new HttpHandler();
            String url = "https://gist.githubusercontent.com/awadhawan18/54592d9ec5e7be1b39013cdd7e78dae4/raw/54a90fe99b8e821e273e1997f356d04308bdb232/Random-images.json";
            String jsonData = sh.makeServiceCall(url);
            Log.e(MainActivity.class.getSimpleName(), "Response from url: " + jsonData);
            if(jsonData!=null){

                try{
                    JSONObject jsonObj = new JSONObject(jsonData);
                    JSONArray cards = jsonObj.getJSONArray("sample");
                    for(int i=0;i<cards.length();i++) {
                        JSONObject c = cards.getJSONObject(i);
                        String description = c.getString("description");
                        String image_url = c.getString("image-url");
                        HashMap<String,String> samples= new HashMap<>();
                        samples.put("description",description);
                        samples.put("image-url",image_url);
                        myValues.add(samples);
                    }
                }catch (final JSONException e){

                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Couldn't get Json Data",Toast.LENGTH_SHORT).show();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (pDialog.isShowing())
                pDialog.dismiss();
            RecyclerViewAdapter adapter = new RecyclerViewAdapter(getApplicationContext(),myValues);
            RecyclerView myView =  (RecyclerView)findViewById(R.id.recyclerview);
            myView.setHasFixedSize(true);
            myView.setAdapter(adapter);
            LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            myView.setLayoutManager(llm);
            myView.addOnScrollListener(new HidingScrollListener() {
                @Override
                public void onHide() {
                    //hideViews();
                }

                @Override
                public void onShow() {
                    //showViews();
                }
            });


        }
    }
    private void hideViews(){
        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));

    }
    private void showViews(){
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
    }
    //checks network connection
    public boolean isNetworkOnline() {
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;

    }
    public void alertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
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
                                finish();
                            }
                        })
                .setNegativeButton("Try Again",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                if(isNetworkOnline()){
                                    new getJsonData().execute();
                                }
                                else alertDialog();
                            }
                        });


        AlertDialog alert = builder.create();

        alert.show();
    }
    private void changeColor(Button id, String color){
        Drawable roundDrawable1 = getResources().getDrawable(R.drawable.round_buttons);
        roundDrawable1.setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        id.setBackground(roundDrawable1);
    }
}
