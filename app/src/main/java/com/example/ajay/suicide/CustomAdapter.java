package com.example.ajay.suicide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Detail> {
    public CustomAdapter(Activity context , ArrayList<Detail> words){
        super(context , 0 , words) ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View listItemView = convertView ;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_item,parent, false);
        }
        Detail customWord = getItem(position) ;

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.head) ;
        nameTextView.setText(customWord.getName());

        TextView numberTextView = (TextView) listItemView.findViewById(R.id.tail) ;
        numberTextView.setText(customWord.getNumber());

        return listItemView ;
    }
}

