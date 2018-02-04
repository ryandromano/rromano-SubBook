package com.example.ryand.rromano_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private EditText priceEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);



        priceEntered = (EditText) findViewById(R.id.subPriceEdit);


        Button confirmEditButton = (Button) findViewById(R.id.confirmEdit);

        confirmEditButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Minus the total amount of money by the old amount and add the new value to it
                MainActivity.price = MainActivity.price + Float.parseFloat(priceEntered.getText().toString());

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
