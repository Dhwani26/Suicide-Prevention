package com.example.ajay.suicide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    final ArrayList<String> place = new ArrayList<String>() ;
    ArrayAdapter<String> adapterp ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        adapterp = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , place) ;
        ListView listViewp = (ListView) findViewById(R.id.list_place) ;

        Button button = (Button) findViewById(R.id.add_1) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText editText = (EditText) findViewById(R.id.edit_text_2) ;
                String s = editText.getText().toString() ;
                place.add(s) ;
                adapterp.notifyDataSetChanged();
                editText.setText("");
            }
        });
        listViewp.setAdapter(adapterp);
    }

    //public void addPlace(View view){

    //}
}
