package com.example.ryand.rromano_subbook;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    private TextView nameView;
    private TextView dateView;
    private TextView priceView;
    private TextView commentView;

    @Override
    protected void onCreate(Bundle savedInstanceState, Subscription sub) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        //Button definitions
        Button deleteButton = (Button) findViewById(R.id.deleteButton);
        Button editButton = (Button) findViewById(R.id.editButton);



        //Print proper information
        nameView = (TextView) findViewById(R.id.nameView);
        nameView.setText(sub.getSubName());

        dateView = (TextView) findViewById(R.id.dateView);
        dateView.setText(sub.getSubDate());

        priceView = (TextView) findViewById(R.id.priceView);
        priceView.setText(sub.getSubCharge());

        commentView = (TextView) findViewById(R.id.commentView);
        commentView.setText(sub.getSubComment());




        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ViewActivity.this, EditActivity.class));

            }
        });

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

}
