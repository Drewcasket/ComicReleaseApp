package com.example.drew.hackdayproject;

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

        ImageView darkhorseLogo= (ImageView) findViewById(R.id.dark_horse_logo);
        darkhorseLogo.setOnClickListener(this);

        ImageView dcLogo = (ImageView) findViewById(R.id.dc_logo);
        dcLogo.setOnClickListener(this);

        ImageView idwLogo= (ImageView) findViewById(R.id.idw_logo);
        idwLogo.setOnClickListener(this);

        ImageView imageLogo = (ImageView) findViewById(R.id.image_logo);
        imageLogo.setOnClickListener(this);

        ImageView marvelLogo = (ImageView) findViewById(R.id.marvel_logo);
        marvelLogo.setOnClickListener(this);
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

    private void gotoMenu(int drawableID, String comic_title) {
        Intent igotoMenu = new Intent(this, MenuActivity.class);
        igotoMenu.putExtra(MenuActivity.COMPANY_LOGO, drawableID);
        igotoMenu.putExtra(MenuActivity.COMPANY_TITLE, comic_title);

        startActivity(igotoMenu);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boom_logo:
                gotoMenu(R.drawable.boom_comics_logo, "boom_studios");
                break;

            case R.id.dark_horse_logo:
                gotoMenu(R.drawable.dark_horse_comics_logo, "dark_horse");
                break;

            case R.id.dc_logo:
                gotoMenu(R.drawable.dc_comics_logo, "dc_comics");
                break;

            case R.id.idw_logo:
                gotoMenu(R.drawable.idw_comics_logo, "idw");
                break;

            case R.id.image_logo:
                gotoMenu(R.drawable.image_comics_logo, "image");
                break;

            case R.id.marvel_logo:
                gotoMenu(R.drawable.marvel_comics_logo, "marvel");
                break;

        }

    }
}