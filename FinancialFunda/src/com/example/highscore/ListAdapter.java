package com.example.highscore;

import com.example.aaa.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

// here's our beautiful adapter
public class ListAdapter extends ArrayAdapter<ListItem> {

    Context mContext;
    int layoutResourceId;
    ListItem data[] = null;

    public ListAdapter(Context mContext, int layoutResourceId, ListItem[] data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        ListItem objectItem = data[position];

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(objectItem.itemName);
        textViewItem.setTag(objectItem.itemId);
        
        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.rating);
        ratingBar.setNumStars(5);
       
        ratingBar.setClickable(false);
        ratingBar.setRating(objectItem.ratingValue);

        return convertView;

    }

}
