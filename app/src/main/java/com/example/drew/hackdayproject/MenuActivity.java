package com.example.drew.hackdayproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MenuActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        TextView new_game= (TextView) findViewById(R.id.new_game_button);
        new_game.setOnClickListener(this);

        TextView continue_game= (TextView) findViewById(R.id.continue_game_button);
        continue_game.setOnClickListener(this);

        TextView eat_shit= (TextView) findViewById(R.id.eat_shit_button);
        eat_shit.setOnClickListener(this);
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
            case R.id.new_game_button:
                Intent iNewGame = new Intent(this, NewGameActivity.class);
                startActivity(iNewGame);
                break;

            case R.id.continue_game_button:
                Intent iContinueGame = new Intent(this, ContinueGameActivity.class);
                startActivity(iContinueGame);
                break;

            case R.id.eat_shit_button:
                throw new NullPointerException();
        }

    }
}
