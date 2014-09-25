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
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.drew.hackdayproject.formatters.ComixologyDateFormatter;
import com.example.drew.hackdayproject.formatters.DateFormatter;

public class MenuActivity extends BaseActivity implements View.OnClickListener {


    public static final String COMPANY_LOGO = "compLogo";
    public static final String COMPANY_TITLE = "compTitle";
    Button lastWeekPressed;
    Button lastWeekDefault;
    ImageView comicLogo;
    WebView webviewArea;
    DateFormatter dateFormatter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        int companyLogo = getIntent().getIntExtra(COMPANY_LOGO, 0);
        String companyTitle = getIntent().getStringExtra(COMPANY_TITLE);
        Button nextWeek = (Button) findViewById(R.id.next_week_button);
        lastWeekDefault = (Button) findViewById(R.id.last_week_button);
        lastWeekPressed = (Button) findViewById(R.id.last_week_button_pressed);

        Button currentWeek = (Button) findViewById(R.id.current_week_button);
        comicLogo = (ImageView) findViewById(R.id.comic_logo);
        webviewArea = (WebView) findViewById(R.id.webview_area);
        dateFormatter = new ComixologyDateFormatter(companyTitle);

        webviewArea.setWebViewClient(new WebViewClient() {
                                         @Override
                                         public boolean shouldOverrideUrlLoading(WebView view, String url) {
                                             view.loadUrl(url);
                                             return true;
                                         }
                                     });

        nextWeek.setOnClickListener(this);
        lastWeekPressed.setOnClickListener(this);
        lastWeekDefault.setOnClickListener(this);
        lastWeekPressed.setVisibility(View.GONE);
        currentWeek.setOnClickListener(this);
        comicLogo.setImageResource(companyLogo);
        webviewArea.loadUrl(dateFormatter.currentWeek());
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
                webviewArea.loadUrl(dateFormatter.lastWeek());
                lastWeekPressed.setVisibility(View.VISIBLE);
                lastWeekDefault.setVisibility(View.GONE);


                break;

            case R.id.next_week_button:
                webviewArea.loadUrl(dateFormatter.nextWeek());
                lastWeekPressed.setVisibility(View.GONE);
                lastWeekDefault.setVisibility(View.VISIBLE);
                break;

            case R.id.current_week_button:
                webviewArea.loadUrl(dateFormatter.currentWeek());
                lastWeekPressed.setVisibility(View.GONE);
                lastWeekDefault.setVisibility(View.VISIBLE);
                break;
        }

    }
}
