package com.example.drew.hackdayproject;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends BaseActivity implements View.OnClickListener {


    public static final String COMPANY_LOGO = "compLogo";
    public static final String COMPANY_URL = "compWebview";
    ImageView comicLogo;
    WebView webviewArea;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button nextWeek = (Button) findViewById(R.id.next_week_button);
        Button lastWeek = (Button) findViewById(R.id.last_week_button);
        comicLogo = (ImageView) findViewById(R.id.comic_logo);
        webviewArea = (WebView) findViewById(R.id.webview_area);


        int companyLogo = getIntent().getIntExtra(COMPANY_LOGO, 0);
        String companyWebview = getIntent().getStringExtra(COMPANY_URL);
        nextWeek.setOnClickListener(this);
        lastWeek.setOnClickListener(this);
        comicLogo.setImageResource(companyLogo);
        webviewArea.loadUrl(companyWebview);








    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
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
            case R.id.last_week_button:
                Intent iNewGame = new Intent(this, NewGameActivity.class);
                startActivity(iNewGame);
                break;

            case R.id.next_week_button:
                Intent iContinueGame = new Intent(this, ContinueGameActivity.class);
                startActivity(iContinueGame);
                break;


        }

    }
}
