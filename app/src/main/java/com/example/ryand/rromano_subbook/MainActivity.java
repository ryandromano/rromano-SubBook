package com.example.ryand.rromano_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView subscriptionList;

    public static float price = 0;

    public static ArrayList<String> sublist = new ArrayList<String>();

    public TextView textView;

    public ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.totalPriceView);
        textView.setText("$" + String.format("%.2f", price));


        Button addbutton = (Button)findViewById(R.id.add_button);
        subscriptionList = (ListView) findViewById(R.id.subcriptionList);


        //SUB LIST FUNCTIONS AND STUFF
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, sublist);
        subscriptionList.setAdapter(adapter);
        subscriptionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this, sublist.get(i), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, ViewActivity.class));

            }
        });

        //Go to the AddActivity to make a new subscription
        addbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, AddActivity.class));

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        subscriptionList.setAdapter(adapter);
        textView.setText("$" + String.format("%.2f", price));
    }

}
