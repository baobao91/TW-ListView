package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.media.midi.MidiOutputPort;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvYear;
    ArrayList<Module> module;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        module = new ArrayList<Module>();
        module.add(new Module("Year 1", true));
        module.add(new Module("Year 2", true));
        module.add(new Module("Year 3", true));

        ModuleAdapter adapter = new ModuleAdapter(this, R.layout.row, module);

        lv = (ListView) this.findViewById(R.id.lvModules);
        tvYear = (TextView) findViewById(R.id.tvYear);

        lv.setAdapter(adapter);

        Intent i = getIntent();
        String year = i.getStringExtra("year");

        tvYear.setText(year);



    }



}
