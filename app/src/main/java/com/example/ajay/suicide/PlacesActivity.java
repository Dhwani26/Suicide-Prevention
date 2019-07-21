package com.example.ajay.suicide;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlacesActivity extends AppCompatActivity {

    final ArrayList<String> place = new ArrayList<String>() ;
    ArrayAdapter<String> adapterp ;
    DatabaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        myDb = new DatabaseHelper(this);

        Cursor res = myDb.getAllPLaces();
        while (res.moveToNext()){
            place.add(res.getString(1));
        }

        adapterp = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , place) ;
        ListView listViewp = (ListView) findViewById(R.id.list_place) ;

        Button button = (Button) findViewById(R.id.add_1) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText editText = (EditText) findViewById(R.id.place) ;
                String s = editText.getText().toString() ;
                place.add(s) ;
                boolean isInserted = myDb.insertPlace(s);
                adapterp.notifyDataSetChanged();
                editText.setText("");
                if(isInserted){
                    Toast.makeText(PlacesActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(PlacesActivity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });
        listViewp.setAdapter(adapterp);
        listViewp.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }

                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });
    }

    //public void addPlace(View view){

    //}
}
