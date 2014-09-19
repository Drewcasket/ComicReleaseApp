package com.example.drew.hackdayproject;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

/**
 * Created by Drew on 9/16/14.
 */
public abstract class BaseActivity extends Activity {

    private SharedPreferences sharedPreferences;

    protected void setUserEmail(String email) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.user_email), email);
        editor.commit();
    }

    protected void setUserPassword(String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.user_password), password);
        editor.commit();
    }

    protected String getUserEmail() {
        return sharedPreferences.getString(getString(R.string.user_email), "");
    }

    protected String getUserPassword() {
        return sharedPreferences.getString(getString(R.string.user_password), "");
    }

    protected boolean isUserSignedIn() {

        return !getUserEmail().isEmpty() && !getUserPassword().isEmpty();

    }

    //need to check if user has favorite comics saved

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences(getString(R.string.user_preferences), 0);
    }
}
