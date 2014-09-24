package com.example.esau.game;

import android.app.Activity;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by Esau Mena on 9/21/2014.
 *
 * Description: In this class the user will be able to see all the start and end dates
 * stored in the data bade(hash table).
 */
public class listSEDate extends Activity {

    @Override
    protected void onCreate(Bundle saveInstanceSate) {
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.list);
        //Calling display method
        displayDates();
    }

    // This method displays the dates saved by the user
    public void displayDates(){

        Set<Entry<String, String>> entries = Main.dates.entrySet();
        for(Entry<String,String> ent:entries){

            // Getting start dates
            TextView StartDate1v = (TextView) findViewById(R.id.StartDate1v);
            StartDate1v.setText(ent.getKey());
            TextView StartDate2v = (TextView) findViewById(R.id.StartDate2v);
            StartDate2v.setText(ent.getKey());
            TextView StartDate3v = (TextView) findViewById(R.id.StartDate3v);
            StartDate3v.setText(ent.getKey());

            // Getting  end dates
            TextView EndDate1v = (TextView) findViewById(R.id.EndDate1v);
            EndDate1v.setText(ent.getValue());
            TextView EndDate2v = (TextView) findViewById(R.id.EndDate2v);
            EndDate2v.setText(ent.getValue());
            TextView EndDate3v = (TextView) findViewById(R.id.EndDate3v);
            EndDate3v.setText(ent.getValue());

            // Testing dates
            Toast.makeText(getBaseContext()," Start Date " + ent.getKey() + " End date " + ent.getValue(), Toast.LENGTH_LONG).show();
        }
    }
}
