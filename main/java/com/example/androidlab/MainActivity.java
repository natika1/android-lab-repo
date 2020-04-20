package com.example.androidlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewCompat;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;//
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
   // private ArrayList<String> target;
    private SimpleCursorAdapter adapter;
    MySQLite db = new MySQLite(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //MySQLite db = new MySQLite(getApplicationContext());
        //MySQLite db = new MySQLite(this);

        String nazw = db.getDatabaseName();

        String[] values = new String[] { "Pies",
                "Kot", "Koń", "Gołąb", "Kruk", "Dzik", "Karp",
                "Osioł", "Chomik", "Mysz", "Jeż", "Kraluch" };
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Toast.makeText(getApplicationContext(),
                "Nazwa Bazy danych :" + nazw,
                Toast.LENGTH_SHORT).show();*/



      //  this.target = new ArrayList<String>();
       // this.target.addAll(Arrays.asList(values));
        this.adapter = new SimpleCursorAdapter( this, android.R.layout.simple_list_item_2, db.lista(), new String[] {"_id", "gatunek"}, new int[] {android.R.id.text1,
                android.R.id.text2},SimpleCursorAdapter.IGNORE_ITEM_VIEW_TYPE );

        ListView listview = (ListView) findViewById(R.id.lalala);
        listview.setAdapter(this.adapter);

        //to do lalala alal
        //dodałam komenta
        //jakies dodatkowe zmiany

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    public void nowyWpis(MenuItem mi)
    {
        Intent intencja = new Intent(this,
                DodajWpis.class);
        startActivityForResult(intencja, 1);
    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, Intent data)
    {

        if(requestCode==1 && resultCode==RESULT_OK)
        {
           Bundle extras = data.getExtras();
           /* Toast.makeText(getApplicationContext(),
                    "Data : " + data,
                    Toast.LENGTH_SHORT).show();*/

            Animal nowy = (Animal) extras.getSerializable("nowy");
            if (nowy == null) {
                Toast.makeText(getApplicationContext(),
                        "Nie powiodło się",
                        Toast.LENGTH_SHORT).show();
            } else {
            //String nowy = (String)extras.get("wpis");

            this.db.dodaj(nowy);
            adapter.changeCursor(db.lista());
            adapter.notifyDataSetChanged(); }
            //target.add(nowy);
            //adapter.notifyDataSetChanged();
        }
    }
}
