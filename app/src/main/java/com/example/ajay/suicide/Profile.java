package com.example.ajay.suicide;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {
    TextView name ;
    TextView age ;
    TextView gender ;
    TextView email ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        name = (TextView) findViewById(R.id.p_name);
        age = (TextView) findViewById(R.id.p_age);
        gender = (TextView) findViewById(R.id.p_gender);
        email = (TextView) findViewById(R.id.p_email);

        SharedPreferences preferences = getSharedPreferences("PREF" , MODE_PRIVATE);
        //boolean check = preferences.getBoolean("registered", false);
        name.setText(preferences.getString("name", "default name"));
        gender.setText(preferences.getString("gender","defaut gender"));
        email.setText(preferences.getString("email","default email"));
        age.setText(preferences.getString("age","default age"));
    }
}
