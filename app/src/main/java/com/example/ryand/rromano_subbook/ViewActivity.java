/*
 * ViewActivity
 *
 * February 4, 2018
 *
 * Copyright © 2018. CMPUT 301. University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license un this project. Otherwise please contact contact@abc.ca
 */

package com.example.ryand.rromano_subbook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * The view activity allows the user to see the information regarding the selected
 * subscription. Gives the user the option to edit the information or delete the
 * subscription.
 */
public class ViewActivity extends AppCompatActivity {
    private TextView nameView;
    private TextView dateView;
    private TextView priceView;
    private TextView commentView;

    private int objectPosition;
    private Subscription sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        objectPosition = MainActivity.position;

        //Button definitions
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button editButton = (Button) findViewById(R.id.editButton);

        //Subscription
        sub = MainActivity.sublist.get(objectPosition);

        //Print proper name information
        nameView = (TextView) findViewById(R.id.nameView);
        nameView.setText(sub.getSubName());

        //Print proper date information
        dateView = (TextView) findViewById(R.id.dateView);
        dateView.setText(sub.getSubDate());

        //Print proper price information
        priceView = (TextView) findViewById(R.id.priceView);
        priceView.setText(Float.toString(sub.getSubCharge()));

        //Print proper comment information
        commentView = (TextView) findViewById(R.id.commentView);
        commentView.setText(sub.getSubComment());

        /**
         * Takes the user to the editActivity when the edit button is pressed
         */
        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ViewActivity.this, EditActivity.class));

            }
        });

        /**
         * When the user selects the delete button, the user is asked if they really
         * want to continue with this action. If yes, the current subscription is removed from the
         * subscription list
         */
        // AlertDialog code based on video: https://www.youtube.com/watch?v=G3FgdUsceDM
        // 2018-02-03
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Confirm deletion and return to main page
                AlertDialog.Builder builder = new AlertDialog.Builder(ViewActivity.this);
                builder
                        .setMessage("Are you sure you want to delete this subscription?")
                        .setPositiveButton("Yes",  new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                //GET RID OF THE SUBSCRIPTION THAT YOU ARE CURRENTLY VIEWING
                                MainActivity.price = MainActivity.price - Float.parseFloat(priceView.getText().toString());

                                MainActivity.sublist.remove(objectPosition);

                                /*
                                //Save to file
                                try {
                                    FileOutputStream fos = openFileOutput(MainActivity.FILENAME,
                                            Context.MODE_PRIVATE);
                                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

                                    Gson gson = new Gson();

                                    gson.toJson(MainActivity.sublist, out);
                                    //gson.toJson(MainActivity.price, out);

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

                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }

                        })
                        .show();
            }
        });

    }

    /**
     * Reloads the information into the textboxes when returning to the ViewActivity
     */
    @Override
    protected void onStart() {
        super.onStart();

        nameView = (TextView) findViewById(R.id.nameView);
        nameView.setText(sub.getSubName());

        dateView = (TextView) findViewById(R.id.dateView);
        dateView.setText(sub.getSubDate().toString());

        priceView = (TextView) findViewById(R.id.priceView);
        priceView.setText(Float.toString(sub.getSubCharge()));

        commentView = (TextView) findViewById(R.id.commentView);
        commentView.setText(sub.getSubComment());
    }

}
