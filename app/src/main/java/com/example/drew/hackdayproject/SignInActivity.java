package com.example.drew.hackdayproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignInActivity extends BaseActivity implements View.OnClickListener {

    EditText email;
    EditText password;
    EditText confirmPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        email = (EditText) findViewById(R.id.email_field);
        password = (EditText) findViewById(R.id.password_field);
        confirmPassword = (EditText) findViewById(R.id.confirm_password_field);

        confirmPassword.setVisibility(View.GONE);


        Button signIn = (Button) findViewById(R.id.register_button);
        signIn.setText(R.string.sign_in);
        signIn.setOnClickListener(this);
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

        String userEmail = email.getText().toString().trim();
        String userPassword = password.getText().toString();
        if (!userEmail.equals(getUserEmail())) {
            email.setError("Email address not found");
            return;
        }

        if (!userPassword.equals(getUserPassword())) {
            password.setError("Password is incorrect");
            return;
        }


        Intent signIn = new Intent(this, HomeActivity.class);
        startActivity(signIn);
    }
}
