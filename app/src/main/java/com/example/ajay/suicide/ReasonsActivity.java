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

public class ReasonsActivity extends AppCompatActivity {
    ArrayList<String> reason = new ArrayList<String>() ;
    ArrayAdapter<String> adapter ;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasons);
        myDb = new DatabaseHelper(this);
        Cursor res = myDb.getAllReasons();

        while(res.moveToNext()){
            reason.add(res.getString(1));
        }

        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , reason) ;
        ListView listViewr = (ListView) findViewById(R.id.list_reason) ;

        Button button = (Button) findViewById(R.id.add) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText editText = (EditText) findViewById(R.id.edit_text_1) ;
                String s = editText.getText().toString() ;
                boolean isInserted = myDb.insertReason(s);
                reason.add(s) ;
                adapter.notifyDataSetChanged();
                editText.setText("");
                if(isInserted){
                    Toast.makeText(ReasonsActivity.this,"Data Inserted", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(ReasonsActivity.this,"Data not Inserted", Toast.LENGTH_LONG).show();
                }
            }
        });

        listViewr.setAdapter(adapter);
        listViewr.setOnTouchListener(new ListView.OnTouchListener() {
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

}
