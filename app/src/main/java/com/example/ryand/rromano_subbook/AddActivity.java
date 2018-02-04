package com.example.ryand.rromano_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    private EditText priceEntered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button confirmAddButton = (Button) findViewById(R.id.confirm_add);
        priceEntered = (EditText) findViewById(R.id.subPrice);



        confirmAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Adds value entered to the total subscription cost
                MainActivity.price = MainActivity.price + Float.parseFloat(priceEntered.getText().toString());

                //Add entered values to the subscription list
                MainActivity.sublist.add(priceEntered.getText().toString());

                finish();
                //startActivity(new Intent(AddActivity.this, MainActivity.class));
            }
        });

        //confirmConfigure();
    }




    /**
    private void confirmConfigure() {
        Button confirmAddButton = (Button) findViewById(R.id.confirm_add);
        priceEntered = (EditText) findViewById(R.id.editText4);

        confirmAddButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //Adds value entered to the total subscription cost
                MainActivity.price = MainActivity.price + Float.parseFloat(priceEntered.getText().toString());

                finish();
                //startActivity(new Intent(AddActivity.this, MainActivity.class));

            }
        });
    }
     */

}
