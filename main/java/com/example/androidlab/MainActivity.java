package com.example.androidlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;//
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> target;
    private ArrayAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String[] values = new String[] { "Pies",
                "Kot", "Koń", "Gołąb", "Kruk", "Dzik", "Karp",
                "Osioł", "Chomik", "Mysz", "Jeż", "Kraluch" };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.target = new ArrayList<String>();
        this.target.addAll(Arrays.asList(values));
        this.adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,this.target);
        ListView listview = (ListView) findViewById(R.id.lalala);
        listview.setAdapter(this.adapter);

                //to do lalala alal
        //dodałam komenta
        //jakies dodatkowe zmiany

    }
}
