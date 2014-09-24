package com.example.esau.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.StringTokenizer;

/**
 * Created by Esau Mena on 9/21/2014.
 *
 * Description: This class the use will be able to enter a new date. The new
 * date will be compared to the dates from the start-end dates in the data base
 * to check if they fall either inside or outside. The application will
 * return true if they fall within the start-end date or false otherwise.
 */
public class querySEDate extends Activity {


    @Override
    protected void onCreate (Bundle saveInstanceSate){
        super.onCreate(saveInstanceSate);
        setContentView(R.layout.query);
        // When the button is pressed the date entered will be compared
        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Getting date from user
                EditText startDate1q = (EditText) findViewById(R.id.StartDate1q);
                EditText startDate2q = (EditText) findViewById(R.id.StartDate2q);
                EditText startDate3q = (EditText) findViewById(R.id.StartDate3q);

                // Converting date  into Strings
                String sd1 = startDate1q.getText().toString();
                String sd2 = startDate2q.getText().toString();
                String sd3 = startDate3q.getText().toString();

                // Getting the Key elements from data base(hash table)
                String sd1db = Main.dates.keys().nextElement().toString();
                String sd2db = Main.dates.keys().nextElement().toString();
                String sd3db = Main.dates.keys().nextElement().toString();

                // Getting start date and being parse
                //key from hash table
                int [] startDateInteger1 = myTokenizer(sd1db);
                int [] startDateInteger2 = myTokenizer(sd2db);
                int [] startDateInteger3 = myTokenizer(sd3db);

                // Getting end date and being parse
                // Value of keys in hash table
                int [] endDateInteger1 = myTokenizer(Main.dates.get(sd1db).toString());
                int [] endDateInteger2 = myTokenizer(Main.dates.get(sd2db).toString());
                int [] endDateInteger3 = myTokenizer(Main.dates.get(sd3db).toString());

                // Getting new date and being parse
                // Keys to compare to
                int [] newDateInteger1 = myTokenizer(sd1);
                int [] newDateInteger2 = myTokenizer(sd2);
                int [] newDateInteger3 = myTokenizer(sd3);

                // Getting result from comparison
                Boolean resultBool1 = compareDates(startDateInteger1, endDateInteger1, newDateInteger1);
                Boolean resultBool2 = compareDates(startDateInteger2, endDateInteger2, newDateInteger2);
                Boolean resultBool3 = compareDates(startDateInteger3, endDateInteger3, newDateInteger3);

                // Where result is being display to the user
                TextView result1 = (TextView) findViewById(R.id.Result1);
                TextView result2 = (TextView) findViewById(R.id.Result2);
                TextView result3 = (TextView) findViewById(R.id.Result3);

                // Converting result into Strings
                result1.setText(resultBool1.toString());
                result2.setText(resultBool2.toString());
                result3.setText(resultBool3.toString());

            }
        });
    }

    // This method compares the year month and day of the new date to the ones
    // stored in the data base(hash table)
    public boolean compareDates(int arrayStart[], int arrayEnd[], int arrayCheck[]){
        //If the year is the same it goes to the else
        // Year comparison

        if(arrayStart[0] < arrayCheck[0] && arrayCheck[0] < arrayEnd[0]) {
            return false;

        }
        else if(arrayStart[0] == arrayCheck[0]) {

            // Month Comparison
            if (arrayStart[1] < arrayCheck[1]) {

                return false;
            }
            else if (arrayStart[1] == arrayCheck[1] || arrayCheck[1] == arrayEnd[1]) {

                // Day comparison
                if (arrayStart[2] < arrayCheck[2]) {
                    return false;
                }
                else if (arrayStart[2] == arrayCheck[2] || arrayCheck[2] == arrayEnd[2]){
                    return false;
                }
            }
        }
        // Else if the month is the same goes in
        else if(arrayCheck[0] == arrayEnd[0]){
            // Month comparison
            if (arrayCheck[1] < arrayEnd[1]) {

                return false;
            }
            else if (arrayStart[1] == arrayCheck[1] || arrayCheck[1] == arrayEnd[1]) {

                // Day comparison
                if (arrayEnd[2] > arrayCheck[2]) {
                    return false;
                }
                else if (arrayStart[2] == arrayCheck[2] || arrayCheck[2] == arrayEnd[2]){
                    return false;
                }
            }
        }
        return true;
    }

    // This method is used to parse the dates in order to make a comparison
    // by year month and date
    public int []  myTokenizer(String x){

        if(x.equals("")){
            return new int[] {0,0,0};
        }

        StringTokenizer token = new StringTokenizer(x, "/");
        int[] yearMonthDay = new int[3];
        int i = 0;

        while(token.hasMoreTokens()){
            yearMonthDay[i] = Integer.parseInt(token.nextToken());
            i++;
        }
        return yearMonthDay;
    }
}
