package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v)
    {
        // Get refereces toa ll elements on app screen
        EditText num1EditTExt = (EditText) findViewById(R.id.num1EditText);
        EditText num2EditTExt = (EditText) findViewById(R.id.num2EditText);
        TextView ansTextView = (TextView) findViewById(R.id.ansTextView);

        int num1 = 0;
        int num2 = 0;
        // get the values from the EditText boxes and convert them to int data types
        // use a try catch block to avoid the app crashing if nothing is entered.
        try {
            num1 = Integer.parseInt(num1EditTExt.getText().toString());
            num2 = Integer.parseInt(num2EditTExt.getText().toString());
        }
        catch(Exception e) {
            Log.e("DENNA", "No number entered, using default of 0");
            Toast.makeText(getApplicationContext(),"Please enter values for BOTH nums",Toast.LENGTH_SHORT).show();
        }

        // add the two ints
        int sum = num1 + num2;

        // set the text for the answer
        ansTextView.setText("Answer: " + sum);

        closeKeyboard();
            // if wanted to delete values in the Edit Text, just setText = ""
            // num1EditTExt.setText("");
            // num2EditTExt.setText("");
    }

    public void subt(View v)
    {
        // Get refereces toa ll elements on app screen
        EditText num1EditTExt = (EditText) findViewById(R.id.num1EditText);
        EditText num2EditTExt = (EditText) findViewById(R.id.num2EditText);
        TextView ansTextView = (TextView) findViewById(R.id.ansTextView);


        int num1 = 0;
        int num2 = 0;

        // get the values from the EditText boxes and convert them to int data types
        // use a try catch block to avoid the app crashing if nothing is entered.
        try {
            num1 = Integer.parseInt(num1EditTExt.getText().toString());
            num2 = Integer.parseInt(num2EditTExt.getText().toString());
            Log.e("DENNA", "The values of num1 and num2 are " + num1 + " " + num2);
        }
        catch(Exception e) {
            Log.e("DENNA", "No number entered, using default of 0");
            Toast.makeText(getApplicationContext(),"Please enter values for BOTH nums",Toast.LENGTH_SHORT).show();
        }

        // subt the two ints
        int diff = num1 - num2;

        // set the text for the answer
        ansTextView.setText("Answer: " + diff);

        closeKeyboard();
    }

    /*
        How to close the keyboard on buttonClick
        https://www.geeksforgeeks.org/how-to-programmatically-hide-android-soft-keyboard/
     */


    private void closeKeyboard()
    {
        // this will give us the view
        // which is currently focus
        // in this layout
        View view = this.getCurrentFocus();

        // if nothing is currently
        // focus then this will protect
        // the app from crash
        if (view != null) {

            // now assign the system
            // service to InputMethodManager
            InputMethodManager manager
                    = (InputMethodManager)
                    getSystemService(
                            Context.INPUT_METHOD_SERVICE);
            manager
                    .hideSoftInputFromWindow(
                            view.getWindowToken(), 0);
        }
    }

}