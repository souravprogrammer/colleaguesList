package com.example.colleagueslist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class listadapter extends ArrayAdapter<PersonInfo> {

    public listadapter(Activity context, ArrayList<PersonInfo> persons) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, persons);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_card, parent, false);
        }
        PersonInfo info = getItem(position) ;
        TextView nametitle = listItemView.findViewById(R.id.nameview);
        nametitle.setText(info.getName());
        TextView phone = listItemView.findViewById(R.id.phoneview);
        phone.setText(info.getPhone());
        return listItemView ;
    }
}
