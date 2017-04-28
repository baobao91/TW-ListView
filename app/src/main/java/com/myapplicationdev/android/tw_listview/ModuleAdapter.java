package com.myapplicationdev.android.tw_listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.myapplicationdev.android.tw_listview.R.id.ivProg;
import static com.myapplicationdev.android.tw_listview.R.id.tvYear;

public class ModuleAdapter extends ArrayAdapter<Module> {

    private ArrayList<Module> module;
    private TextView tvYear;
    private ImageView ivProg;
    private Context context;

    public ModuleAdapter(Context context, int resource, ArrayList<Module> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        module = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvYear = (TextView) rowView.findViewById(R.id.tvModule);
        ivProg = (ImageView) rowView.findViewById(R.id.ivProg);

       Module currentModule = module.get(position);

        if(currentModule.isCode()) {
            ivProg.setImageResource(R.drawable.prog);
        }
        else {
            ivProg.setImageResource(R.drawable.nonprog);
        }
        // Set the TextView to show the food
        tvYear.setText(currentModule.getModule());

        return rowView;
    }


}
