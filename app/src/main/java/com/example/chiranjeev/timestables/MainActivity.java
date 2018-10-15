package com.example.chiranjeev.timestables;
/**
 * Step 1 :  Set put the seek bar and list view widgets in the layout and give them proper ID's
 * Step 2 : Declare SeekBar and ListView objects in the MainActivity class
 * Step 3 : define the seekBar object by using findViewById and set it's max value to 19 ( 1 less than the max it's supposed to go to )
 * Step 4 : define a method in which ,
 * an array and an arrayAdapter and connect both of them and finally connect the arrayAdapter with the list using the listView's setAdapter() method
 * Step 5 : in the onSeekBarChangeListener function , of the seekBar ,in the progressChanged module put in the code for the declaration and initialization for the table
 */


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static android.R.layout.simple_list_item_1;

public class MainActivity extends AppCompatActivity {
    //Step 2 :
    private SeekBar values;
    private ListView timesList;

    //Step 4 :
    public void setList(int progress) {

        timesList = findViewById(R.id.timesList);


        final ArrayList<Integer> numbers = new ArrayList<>(10);
        for (int i = 0; i < 10; i++)
            numbers.add((i + 1) * (progress + 1));

        final ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, simple_list_item_1, numbers);

        timesList.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Step 3 :
        values = findViewById(R.id.seekBar);
        values.setMax(19);


        values.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Step 5 :
                setList(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
