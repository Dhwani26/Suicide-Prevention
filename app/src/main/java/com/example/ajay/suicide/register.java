package com.example.ajay.suicide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
    }

    public void done(View view){
        EditText name = (EditText) findViewById(R.id.name);
        EditText age = (EditText) findViewById(R.id.age);
        EditText email = (EditText) findViewById(R.id.email);

        String s_name = name.getText().toString();
        String s_age = age.getText().toString();
        String s_email = email.getText().toString();

        SharedPreferences preferences = getSharedPreferences("PREF" , MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("registered", true);
        editor.putString("name", s_name);
        editor.putString("age", s_age);
        editor.putString("email", s_email);
        editor.apply();

        Intent i = new Intent(this , MainActivity.class) ;
        startActivity(i);
    }
}
