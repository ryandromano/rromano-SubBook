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
                subscription.setSubName(subNameEntered.getText().toString());
                //subscription.setSubDate();
                subscription.setSubCharge(Float.parseFloat(subPriceEntered.getText().toString()));
                subscription.setSubComment(subCommentEntered.getText().toString());

                //Minus the total amount of money by the old amount and add the new value to it
                MainActivity.price = MainActivity.price - originalPrice + subscription.getSubCharge();

                //Return to newly edited info
                finish();
            }
        });
    }
}
