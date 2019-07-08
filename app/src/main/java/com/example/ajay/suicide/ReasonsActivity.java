package com.example.ajay.suicide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ReasonsActivity extends AppCompatActivity {
    ArrayList<String> reason = new ArrayList<String>() ;
    ArrayAdapter<String> adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reasons);


        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , reason) ;
        ListView listViewr = (ListView) findViewById(R.id.list_reason) ;

        Button button = (Button) findViewById(R.id.add) ;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // your handler code here
                EditText editText = (EditText) findViewById(R.id.edit_text_1) ;
                String s = editText.getText().toString() ;
                reason.add(s) ;
                adapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

        listViewr.setAdapter(adapter);
    }

}
