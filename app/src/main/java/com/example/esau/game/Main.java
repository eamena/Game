package com.example.esau.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Hashtable;

/**
 * Created by Esau Mena on 9/21/2014.
 *
 * Description: This application simulates an agenda by getting
 * the start and end dates from the user. It displays an
 * image at the home screen with three buttons in order to navigate
 * trough the application. the buttons are as follows:
 *
 * 1.New Start-End date = When this button is activated it will take the user to a
 *       new layout where the user is able to input the pair of dates. At
 *       this point it can only take 3 pairs of dates but could be done to
 *       add as many dates as wanted.
 *
 * 2.Query of Start-End Pairs = When this button is activated it will take the user to a
 *       new layout where the user is able to input a start date and the application
 *       will return true if its allowed or false if is not allowed.
 *
 * 3.List of All Start-End Date = When this button is activated it will take the user to a
 *      new layout where the user will be able to see all its pairs of dates. Since the
 *      application only takes three pairs when created then it will only generate
 *      a list of three pairs.
 *
 * To navigate back from any layout the native back button of android devices will
 * be need to be pressed.
 *
 * Reason of use of a Hash Table: A hash table was implemented as the database to prove knowledge
 * of the data structure hash table. Since the database in this case the hash table is not of
 * a big size then is faster to travers the data.
 *
 */
public class Main extends Activity {

    public static Hashtable dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //creating database using a hash table
        dates = new Hashtable();

        //selecting "new start-end date" button will send you to newSEDate.java
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button newSE = (Button) findViewById(R.id.newSE);
        newSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newStartEndDate = new Intent(v.getContext(), newSEDate.class);
                startActivity(newStartEndDate);
            }
        });

        //selecting "query od start-end date" button will send you to querySEDate.java
        Button querySE = (Button) findViewById(R.id.querySE);
        querySE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent queryStartEndDate = new Intent(v.getContext(), querySEDate.class);
                startActivity(queryStartEndDate);
            }
        });

        //selecting "list all start-end date" button will send you to listSEDate.java
        Button listSE = (Button) findViewById(R.id.listSE);
        listSE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listStartEndDate = new Intent(v.getContext(), listSEDate.class);
                startActivity(listStartEndDate);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
