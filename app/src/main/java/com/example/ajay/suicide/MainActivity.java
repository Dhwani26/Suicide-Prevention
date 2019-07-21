package com.example.ajay.suicide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        SharedPreferences preferences = getSharedPreferences("PREF" , MODE_PRIVATE);
        boolean check = preferences.getBoolean("registered", false);

        if(check == false){
            Intent i = new Intent(this, register.class);
            startActivity(i);
        }else{
        }
    }

    public void openAskForHelp(View view){
        Intent i = new Intent(this , AskForHelpActivity.class) ;
        startActivity(i);
    }

    public void openWarningSignsActivity(View view){
        Intent i = new Intent(this ,WarningSignsActivity.class) ;
        startActivity(i);
    }

    public void openReasons(View view){
        Intent i = new Intent(this , ReasonsActivity.class) ;
        startActivity(i);
    }

    public void openSafety(View view){
        Intent i = new Intent(this , SafetyActivity.class) ;
        startActivity(i);
    }

    public void openPlaces(View view){
        Intent i = new Intent(this , PlacesActivity.class) ;
        startActivity(i);
    }

    public void openMusic(View view){
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MUSIC_PLAYER) ;
        startActivity(intent);
    }

    public void openProfile(View view){
        Intent i = new Intent(this,Profile.class);
        startActivity(i);
    }
}
