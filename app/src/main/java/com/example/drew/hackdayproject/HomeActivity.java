package com.example.drew.hackdayproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends BaseActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button newReleases = (Button) findViewById(R.id.new_releases_button);
        Button myComics = (Button) findViewById(R.id.my_comics_button);
        Button signIn = (Button) findViewById(R.id.sign_in_button);
        Button signOut = (Button) findViewById(R.id.sign_out_button);
        Button register = (Button) findViewById(R.id.register_button);

        newReleases.setOnClickListener(this);
        myComics.setOnClickListener(this);
        signIn.setOnClickListener(this);
        signOut.setOnClickListener(this);
        register.setOnClickListener(this);


        if (isUserSignedIn()) {
            signIn.setVisibility(View.GONE);
            register.setVisibility(View.GONE);
            signOut.setVisibility(View.VISIBLE);
        }

        else {
            signIn.setOnClickListener(this);
            register.setVisibility(View.VISIBLE);
            signOut.setVisibility(View.GONE);
        }


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.new_releases_button:
                Intent newReleases= new Intent(this, CompanyListActivity.class);
                startActivity(newReleases);
                break;
            case R.id.my_comics_button:
                Intent myComics= new Intent(this, MyComicsActivity.class);
                startActivity(myComics);
                break;
            case R.id.sign_in_button:
                Intent signIn= new Intent(this, SignInActivity.class);
                startActivity(signIn);
                break;

            case R.id.register_button:
                Intent register= new Intent(this, RegisterActivity.class);
                startActivity(register);
                break;

        }

    }
}
