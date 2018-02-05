/*
 * EditActivity
 *
 * February 4, 2018
 *
 * Copyright © 2018. CMPUT 301. University of Alberta - All Rights Reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta.
 * You can find a copy of the license un this project. Otherwise please contact contact@abc.ca
 */

package com.example.ryand.rromano_subbook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class EditActivity extends AppCompatActivity {



    private EditText subNameEntered;
    private EditText subDateEntered;
    private EditText subPriceEntered;
    private EditText subCommentEntered;

    private String fullDate;
    private String[] dateParts;

    private float originalPrice;
    private int objectPosition;

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        objectPosition = MainActivity.position;
        subscription = MainActivity.sublist.get(objectPosition);


        Button confirmEditButton = (Button) findViewById(R.id.confirmEdit);

        //Print proper information
        subNameEntered = (EditText) findViewById(R.id.subNameEdit);
        subNameEntered.setText(subscription.getSubName());

        subDateEntered = (EditText) findViewById(R.id.subDateEdit);
        subDateEntered.setText(subscription.getSubDate());

        subPriceEntered = (EditText) findViewById(R.id.subPriceEdit);
        subPriceEntered.setText(Float.toString(subscription.getSubCharge()));

        subCommentEntered = (EditText) findViewById(R.id.subCommentEdit);
        subCommentEntered.setText(subscription.getSubComment());


        confirmEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                originalPrice = subscription.getSubCharge();

                fullDate = subDateEntered.getText().toString();
                dateParts = fullDate.split("-");

                if (subNameEntered.getText().toString().length() > 20 || subNameEntered.getText().toString().length() == 0) {
                    Toast.makeText(EditActivity.this, "Subscription name is an improper length", Toast.LENGTH_LONG).show();
                }
                else if (dateParts.length != 3) {
                    Toast.makeText(EditActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(dateParts[1]) > 12 || Integer.parseInt(dateParts[1]) < 1) {
                    Toast.makeText(EditActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(dateParts[2]) > 31 || Integer.parseInt(dateParts[2]) < 1) {
                    Toast.makeText(EditActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (Integer.parseInt(dateParts[0]) / 1000 < 1 || Integer.parseInt(dateParts[0]) / 1000 > 9) {
                    Toast.makeText(EditActivity.this, "Improper date value entered", Toast.LENGTH_LONG).show();
                } else if (subCommentEntered.getText().toString().length() > 30) {
                    Toast.makeText(EditActivity.this, "Comment is too long", Toast.LENGTH_LONG).show();
                }
                else {
                    subscription.setSubName(subNameEntered.getText().toString());
                    subscription.setSubDate(subDateEntered.getText().toString());
                    subscription.setSubCharge(Float.parseFloat(subPriceEntered.getText().toString()));
                    subscription.setSubComment(subCommentEntered.getText().toString());

                    //Minus the total amount of money by the old amount and add the new value to it
                    MainActivity.price = MainActivity.price - originalPrice + subscription.getSubCharge();

                    //Taken from the lonely twitter lab example, which was taken from
                    // https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
                    // 2018-01-24
                    //Save to file
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

                    //Return to newly edited info
                    finish();
                }
            }
        });
    }
}
