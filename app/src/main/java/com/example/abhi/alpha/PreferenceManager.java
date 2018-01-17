package com.example.abhi.alpha;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferenceManager {
    private SharedPreferences sharedPreferences;
    private Context context;

    public PreferenceManager(Context context) {
        this.context = context;
        getSharedPreference();
    }

    private void getSharedPreference() {
        sharedPreferences = context.getSharedPreferences(context.getString(R.string.my_preference), Context.MODE_PRIVATE);
    }

    public void writePreference() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(context.getString(R.string.my_preference_key), "INIT_OK");
        editor.apply();
    }

    public boolean checkPreference() {
        boolean status = false;
        status = !sharedPreferences.getString(context.getString(R.string.my_preference_key), "null").equals("null");
        return status;
    }

    public void clearPreference() {

        sharedPreferences.edit().clear().apply();
    }
}
