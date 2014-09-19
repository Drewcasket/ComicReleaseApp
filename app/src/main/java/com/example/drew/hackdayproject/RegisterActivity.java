package com.example.drew.hackdayproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

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

        Button signIn = (Button) findViewById(R.id.register_button);
        signIn.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
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
        String confirmUserPassword = confirmPassword.getText().toString();

        if (!userEmail.matches(Patterns.EMAIL_ADDRESS.pattern())) {
            email.setError("Please enter a valid email address");
            return;
        }

        if (!(userPassword.length() > 5)) {
            password.setError("Password must be at least 6 characters long");
            return;
        }

        if (!confirmUserPassword.equals(userPassword)) {
            confirmPassword.setError("Passwords do not match, please confirm passwords");
            return;
        }


        setUserEmail(userEmail);
        setUserPassword(userPassword);


        Intent register = new Intent(this, HomeActivity.class);
        startActivity(register);
    }
}
