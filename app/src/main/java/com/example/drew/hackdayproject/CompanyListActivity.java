package com.example.drew.hackdayproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class CompanyListActivity extends BaseActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_list);

        ImageView boomLogo = (ImageView) findViewById(R.id.boom_logo);
        boomLogo.setOnClickListener(this);

//        ImageView darkhorseLogo= (ImageView) findViewById(R.id.dark_horse_logo);
//        darkhorseLogo.setOnClickListener(this);

        ImageView dcLogo = (ImageView) findViewById(R.id.dc_logo);
        dcLogo.setOnClickListener(this);

//        ImageView dynamiteLogo= (ImageView) findViewById(R.id.dynamite_logo);
//        dynamiteLogo.setOnClickListener(this);

//        ImageView idwLogo= (ImageView) findViewById(R.id.idw_logo);
//        idwLogo.setOnClickListener(this);

        ImageView imageLogo = (ImageView) findViewById(R.id.image_logo);
        imageLogo.setOnClickListener(this);

        ImageView marvelLogo = (ImageView) findViewById(R.id.marvel_logo);
        marvelLogo.setOnClickListener(this);

//        ImageView valiantLogo= (ImageView) findViewById(R.id.valiant_logo);
//        valiantLogo.setOnClickListener(this);
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

    private void gotoMenu(int drawableID, String compURL) {
        Intent igotoMenu = new Intent(this, MenuActivity.class);
        igotoMenu.putExtra(MenuActivity.COMPANY_LOGO, drawableID);
        igotoMenu.putExtra(MenuActivity.COMPANY_URL, compURL );
        startActivity(igotoMenu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boom_logo:
                gotoMenu(R.drawable.boom_comics_logo, "http://www.comicvine.com/new-comics/?company=1868&startWeek=09%2F14%2F2014");
                break;

//            case R.id.dark_horse_logo:
//                Intent darkhorse= new Intent(this, MenuActivity.class);
//                startActivity(darkhorse);
//                break;
            case R.id.dc_logo:
                gotoMenu(R.drawable.dc_comics_logo, "http://www.comicvine.com/new-comics/?company=10&startWeek=09%2F14%2F2014");
                break;

//            case R.id.dynamite_logo:
//                Intent dynamite= new Intent(this, MenuActivity.class);
//                startActivity(dynamite);
//                break;
//            case R.id.idw_logo:
//                Intent idw= new Intent(this, MenuActivity.class);
//                startActivity(idw);
//                break;
            case R.id.image_logo:
                gotoMenu(R.drawable.image_comics_logo, "http://www.tfaw.com/Arriving-This-Week?_results_start_date_search=-4+days&_results_end_date_search=%2B3+days&_results_limit_search=30&_results_adultfilter_search=T&_results_ordercombo_search=title_asc&_results_available_search=none&_results_publishers_search=7");
                break;


            case R.id.marvel_logo:
                gotoMenu(R.drawable.marvel_comics_logo, "http://www.tfaw.com/Arriving-This-Week?_results_start_date_search=-4+days&_results_end_date_search=%2B3+days&_results_limit_search=30&_results_adultfilter_search=T&_results_ordercombo_search=title_asc&_results_available_search=none&_results_publishers_search=2");
                break;


//            case R.id.valiant_logo:
//                throw new NullPointerException();

        }

    }
}