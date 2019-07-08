package com.example.ajay.suicide;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class AskForHelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_for_help);

        ArrayList<com.example.ajay.suicide.Detail> words = new ArrayList<com.example.ajay.suicide.Detail>();
        words.add(new com.example.ajay.suicide.Detail("+914066202000" ,"Roshni"));
        words.add(new com.example.ajay.suicide.Detail("+918322252525" ,"Cooj Mental Health Foundation"));
        words.add(new com.example.ajay.suicide.Detail("+914424640050" ,"Sneha Foundation India"));
        words.add(new com.example.ajay.suicide.Detail("+9118602662345" ,"Vandrevala Foundation"));
        words.add(new com.example.ajay.suicide.Detail("+919922001122" ,"Connecting"));

        WordAdapter adapter = new WordAdapter(this , words) ;
        ListView listView = (ListView) findViewById(R.id.list) ;
        listView.setAdapter(adapter);
    }

    public void openContacts(View view){
        Intent intent = new Intent(Intent.ACTION_DEFAULT, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, 1);
    }
}
