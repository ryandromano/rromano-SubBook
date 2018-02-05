/*
 * MainActivity
 *
 * February 4, 2018
 *
 * Copyright © 2018. CMPUT 301. University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license un this project. Otherwise please contact contact@abc.ca
 */

package com.example.ryand.rromano_subbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.provider.Telephony.Mms.Part.FILENAME;

public class MainActivity extends AppCompatActivity {
    public static final String FILENAME = "newfile.sav";

    public ListView subscriptionList;

    public static ArrayList<Subscription> sublist = new ArrayList<Subscription>();
    public ArrayAdapter<Subscription> adapter;

    public static float price = 0;
    public static int position;

    public TextView totalPrice;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        totalPrice = findViewById(R.id.totalPriceView);
        totalPrice.setText("$" + String.format("%.2f", price));


        Button addbutton = (Button)findViewById(R.id.add_button);
        subscriptionList = (ListView) findViewById(R.id.subcriptionList);


        /**
         * Opens the item selected from the the listView.
         * Opens the ViewActivity based on the selected value from the listView
         */
        // Code based on information found at:
        // https://stackoverflow.com/questions/3184672/what-does-adapterview-mean-in-the-onitemclick-method-what-is-the-use-of-ot
        // 2018-02-03
        subscriptionList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                startActivity(new Intent(MainActivity.this, ViewActivity.class));

            }
        });

        /**
         * Go to the AddActivity to make a new subscription
         */
         addbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        loadFromFile();

        adapter = new ArrayAdapter<Subscription>(this, android.R.layout.simple_list_item_1, sublist);
        subscriptionList.setAdapter(adapter);

        totalPrice.setText("$" + String.format("%.2f", price));
    }


    private void loadFromFile() {

        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            //Taken from the lonely twitter lab example, which was taken from
            // https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
            // 2018-01-24
            Type listType = new TypeToken<ArrayList<Subscription>>(){}.getType();

            sublist = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            sublist = new ArrayList<Subscription>();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
/**
    @Override
    protected void onDestroy() {
        super.onDestroy();

        sublist.clear();
        price = 0;

        try {
            FileOutputStream fos = openFileOutput(MainActivity.FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();

            gson.toJson(MainActivity.sublist, out);

            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
