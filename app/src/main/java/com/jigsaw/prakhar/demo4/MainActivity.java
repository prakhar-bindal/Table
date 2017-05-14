package com.jigsaw.prakhar.demo4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;


    public void genereatetable(int table){

        ArrayList<String> content = new ArrayList<String>();

        for(int i =1;i<11;i++)
        {
            content.add(Integer.toString(i*table));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,content);

        list.setAdapter(adapter);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar bar = (SeekBar)findViewById(R.id.seekBar);
        list = (ListView) findViewById(R.id.listview);

        bar.setMax(20);
        bar.setProgress(10);


        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int table;

                if(i< min){
                    table = min;
                    bar.setProgress(min);
                }
                else
                {
                    table = i;
                }

                genereatetable(table);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        genereatetable(10);




    }
}

