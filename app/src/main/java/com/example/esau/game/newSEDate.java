package com.example.esau.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 *
 * Created by Esau Mena on 9/21/2014.
 *
 * Description: In this class the dates provided from the user will
 * be stored in a hash table called dates. For now we will only be working
 * for 3 start dates with its respective end date.
 */
public class newSEDate extends Activity {

    @Override
    protected void onCreate (final Bundle saveInstanceSate){
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.input);
        // When the button is pressed after the input of the data it
        // is stored in the hash table
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Getting the dates as Edit Text fields from the
                // user and making them a string

                EditText startDate1 = (EditText) findViewById(R.id.StartDate1);
                EditText startDate2 = (EditText) findViewById(R.id.StartDate2);
                EditText startDate3 = (EditText) findViewById(R.id.StartDate3);
                EditText endDate1 = (EditText) findViewById(R.id.EndDate1);
                EditText endDate2 = (EditText) findViewById(R.id.EndDate2);
                EditText endDate3 = (EditText) findViewById(R.id.EndDate3);

                String sd1 = startDate1.getText().toString();
                String sd2 = startDate2.getText().toString();
                String sd3 = startDate3.getText().toString();
                String ed1 = endDate1.getText().toString();
                String ed2 = endDate2.getText().toString();
                String ed3 = endDate3.getText().toString();

                saveDatesInHash(sd1, sd2, sd3, ed1, ed2, ed3);
                // Letting know the user that the dates have been saved
                Toast.makeText(getBaseContext(), "Your dates have been saved ", Toast.LENGTH_LONG).show();
            }
        });
    }
    // This method receives the strings of dates
    // and are store in the hastable called names
    public void saveDatesInHash(String sd1, String sd2, String sd3, String ed1, String ed2, String ed3){
        Main.dates.put(sd1,ed1);
        Main.dates.put(sd2,ed2);
        Main.dates.put(sd3,ed3);

    }
}
