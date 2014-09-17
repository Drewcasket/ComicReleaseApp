package com.example.drew.hackdayproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class CompanyListActivity extends Activity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        ImageView boomLogo= (ImageView) findViewById(R.id.boom_logo);
        boomLogo.setOnClickListener(this);

        ImageView darkhorseLogo= (ImageView) findViewById(R.id.dark_horse_logo);
        darkhorseLogo.setOnClickListener(this);

        ImageView dcLogo= (ImageView) findViewById(R.id.dc_logo);
        dcLogo.setOnClickListener(this);

        ImageView dynamiteLogo= (ImageView) findViewById(R.id.dynamite_logo);
        dynamiteLogo.setOnClickListener(this);

        ImageView idwLogo= (ImageView) findViewById(R.id.idw_logo);
        idwLogo.setOnClickListener(this);

        ImageView imageLogo= (ImageView) findViewById(R.id.image_logo);
        imageLogo.setOnClickListener(this);

        ImageView marvelLogo= (ImageView) findViewById(R.id.marvel_logo);
        marvelLogo.setOnClickListener(this);

        ImageView valiantLogo= (ImageView) findViewById(R.id.valiant_logo);
        valiantLogo.setOnClickListener(this);
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
            case R.id.boom_logo:
                Intent boom= new Intent(this, MenuActivity.class);
                startActivity(boom);
                break;
            case R.id.dark_horse_logo:
                Intent darkhorse= new Intent(this, MenuActivity.class);
                startActivity(darkhorse);
                break;
            case R.id.dc_logo:
                Intent dc= new Intent(this, MenuActivity.class);
                startActivity(dc);
                break;
            case R.id.dynamite_logo:
                Intent dynamite= new Intent(this, MenuActivity.class);
                startActivity(dynamite);
                break;
            case R.id.idw_logo:
                Intent idw= new Intent(this, MenuActivity.class);
                startActivity(idw);
                break;
            case R.id.image_logo:
                Intent image= new Intent(this, MenuActivity.class);
                startActivity(image);
                break;
            case R.id.marvel_logo:
                Intent marvel= new Intent(this, MenuActivity.class);
                startActivity(marvel);
                break;

            case R.id.valiant_logo:
                throw new NullPointerException();

        }

    }
}