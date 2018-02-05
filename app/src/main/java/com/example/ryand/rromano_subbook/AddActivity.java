/*
 * AddActivity
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
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.System.in;


/**
 * The AddActivity creates a new subscription object after verifying the users input for valid
 * information
 */
public class AddActivity extends AppCompatActivity {

    private EditText nameEntered;
    private EditText dateEntered;
    private EditText priceEntered;
    private EditText commentEntered;
    private String fullDate;
    private String[] dateParts;

    /**
     * On the creation of the activity, prepares the program to record the data entered from
     * each of the corresponding EditText boxes to get information from the user
     *
     * @param savedInstanceState the current activity the program is on
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button confirmAddButton = (Button) findViewById(R.id.confirm_add);
        nameEntered = (EditText) findViewById(R.id.subName);
        dateEntered = (EditText) findViewById(R.id.subDate);
        priceEntered = (EditText) findViewById(R.id.subPrice);
        commentEntered = (EditText) findViewById(R.id.subComment);

        /**
         * Once the user enters the values into the corresponding EditText boxes input
         * validation needs to occur. If inputs are valid, a new Subscription object is created.
         */
        confirmAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fullDate = dateEntered.getText().toString();
                dateParts = fullDate.split("-");

                // Name validation. Cannot be longer that 20 characters. Cannot be left blank.
                if (nameEntered.getText().toString().length() > 20 || nameEntered.getText().toString().length() == 0) {
                    Toast.makeText(AddActivity.this, "Subscription name is an improper length", Toast.LENGTH_LONG).show();
                }
                // Date validation. Date must be in proper (yyyy/MM-dd) format
                else if (dateParts.length != 3) {
                    Toast.makeText(AddActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(dateParts[1]) > 12 || Integer.parseInt(dateParts[1]) < 1) {
                    Toast.makeText(AddActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(dateParts[2]) > 31 || Integer.parseInt(dateParts[2]) < 1) {
                    Toast.makeText(AddActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(dateParts[0]) / 1000 < 1 || Integer.parseInt(dateParts[0]) / 1000 > 9) {
                    Toast.makeText(AddActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                }
                // Comment validation. Can be empty, but cannot be longer than 30 characters.
                else if (commentEntered.getText().toString().length() > 30) {
                    Toast.makeText(AddActivity.this, "Comment is too long", Toast.LENGTH_LONG).show();
                }
                else {
                    //String name = nameEntered.getText().toString();
                    Subscription sub = new Subscription(nameEntered.getText().toString(), dateEntered.getText().toString(),
                            Float.parseFloat(priceEntered.getText().toString()),
                            commentEntered.getText().toString());

                    //Adds value entered to the total subscription cost
                    MainActivity.price = MainActivity.price + Float.parseFloat(priceEntered.getText().toString());

                    //Add entered values to the subscription list
                    MainActivity.sublist.add(sub);

                    //Save to file
                    /*
                    try {
                        FileOutputStream fos = openFileOutput(MainActivity.FILENAME,
                                Context.MODE_PRIVATE);
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

                        Gson gson = new Gson();

                        gson.toJson(MainActivity.sublist, out);

                        out.flush();

                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    */

                    finish();
                }
            }
        });
    }
}
