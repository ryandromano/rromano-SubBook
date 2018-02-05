package com.example.ryand.rromano_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {



    private EditText subNameEntered;
    private EditText subDateEntered;
    private EditText subPriceEntered;
    private EditText subCommentEntered;

    private String originalPrice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);


        Button confirmEditButton = (Button) findViewById(R.id.confirmEdit);

        //Print proper information
        subNameEntered = (EditText) findViewById(R.id.subNameEdit);
        subNameEntered.setText("OH");

        subDateEntered = (EditText) findViewById(R.id.subDateEdit);
        subDateEntered.setText("MY");


        subPriceEntered = (EditText) findViewById(R.id.subPriceEdit);
        originalPrice = subPriceEntered.getText().toString();
        subPriceEntered.setText("Gosh");

        subCommentEntered = (EditText) findViewById(R.id.subCommentEdit);
        subCommentEntered.setText("Bleh, this sucks.");

        confirmEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Minus the total amount of money by the old amount and add the new value to it
                MainActivity.price = MainActivity.price - Float.parseFloat(originalPrice) + Float.parseFloat(subPriceEntered.getText().toString());

                //Add entered values to the subscription list
                //MainActivity.sublist.add("1");

                //Return to newly edited info
                finish();


                //startActivity(new Intent(EditActivity.this, MainActivity.class));
            }
        });

        //confirmConfigure();
    }




}
