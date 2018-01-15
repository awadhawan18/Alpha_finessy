package com.example.abhi.alpha;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;


public class MainActivity extends AppCompatActivity{


    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.app_name), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.app_name), Boolean.TRUE);
            edit.commit();
            startActivity(new Intent(getApplicationContext(),sign_in.class));
        }
        else{
            startActivity(new Intent(getApplicationContext(),tabview.class));
        }
        MainActivity.this.finish();
    }
}
