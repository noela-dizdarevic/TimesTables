package com.noela.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView timesTableListView;



    public void generateTimesTable (int timesTable) {


    ArrayList<String> timesTableContent = new ArrayList<String>();
    for (int i = 1; i <= 10; i++) {                               // we use for loop to add content to our array list
        timesTableContent.add(Integer.toString(i * timesTable));  //this give us the number witch we want, i=1, 1 * timesTable (1*10)
    }

    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);


    timesTableListView.setAdapter(arrayAdapter);




    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar timesTableSeekbar = (SeekBar) findViewById(R.id.timesTableSeekBar);

        timesTableListView = (ListView) findViewById(R.id.timesTableListView);

        timesTableSeekbar.setMax(20);
        timesTableSeekbar.setProgress(10);

        timesTableSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

                int min = 1;
                int timesTable;

                if (progress < min) {
                    timesTable = min;
                    timesTableSeekbar.setProgress(min);
                } else {
                    timesTable = progress;
                }

              generateTimesTable(timesTable);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    generateTimesTable(10);

    }

}
