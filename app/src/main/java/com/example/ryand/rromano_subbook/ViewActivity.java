package com.example.ryand.rromano_subbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button editButton = (Button) findViewById(R.id.editButton);


        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ViewActivity.this, EditActivity.class));

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Confirm deletion and return to main page



                //startActivity(new Intent(ViewActivity.this, Activity.class));

                //Return back to mainpage
                finish();
            }
        });

    }
}
