package com.example.ryand.rromano_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.System.in;

public class AddActivity extends AppCompatActivity {

    private EditText nameEntered;
    private EditText dateEntered;
    private EditText priceEntered;
    private EditText commentEntered;

    private Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button confirmAddButton = (Button) findViewById(R.id.confirm_add);
        nameEntered = (EditText) findViewById(R.id.subName);
        dateEntered = (EditText) findViewById(R.id.subDate);
        priceEntered = (EditText) findViewById(R.id.subPrice);
        commentEntered = (EditText) findViewById(R.id.subComment);

        //Date date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);


        confirmAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String sDate = dateEntered.getText().toString();
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse(sDate);
                } catch (ParseException e) {

                }


                //String name = nameEntered.getText().toString();
                Subscription sub = new Subscription(nameEntered.getText().toString(), date,
                                                       Float.parseFloat(priceEntered.getText().toString()),
                                                       commentEntered.getText().toString());

                MainActivity.sublist.add(sub);


                //Adds value entered to the total subscription cost
                MainActivity.price = MainActivity.price + Float.parseFloat(priceEntered.getText().toString());
                //Add entered values to the subscription list
                MainActivity.sublist.add(nameEntered.getText().toString());

                finish();
            }
        });

    }

}
