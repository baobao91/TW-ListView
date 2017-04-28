package com.myapplicationdev.android.tw_listview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    ListView lvYear;

    ArrayList<String> module;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvYear = (ListView)findViewById(R.id.lvYear);


        module = new ArrayList<String>();
        module.add("Year 1");
        module.add("Year 2");
        module.add("Year 3");

        aa = new ArrayAdapter(this,android.R.layout.simple_list_item_1, module);
        lvYear.setAdapter(aa);

        lvYear.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String selectedYear = module.get(position);

                Intent i = new Intent (FirstActivity.this,
                        SecondActivity.class);

                i.putExtra("year", selectedYear);
                Toast.makeText(FirstActivity.this, selectedYear,
                        Toast.LENGTH_LONG).show();

                startActivity(i);
            }
        });





    }
}
