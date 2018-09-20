package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Adding a list of number
        ArrayList<Word> objectNumber = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectNumber.add(new Word(R.drawable.number_one,"Lutti","One"));
        objectNumber.add(new Word(R.drawable.number_two,"otiiko","two"));
        objectNumber.add(new Word(R.drawable.number_three,"tolookosu","three"));
        objectNumber.add(new Word(R.drawable.number_four,"oyyisa","four"));
        objectNumber.add(new Word(R.drawable.number_five,"massokka","five"));
        objectNumber.add(new Word(R.drawable.number_six,"temmokka","six"));
        objectNumber.add(new Word(R.drawable.number_seven,"kenekaku","seven"));
        objectNumber.add(new Word(R.drawable.number_eight,"kawinta","eight"));
        objectNumber.add(new Word(R.drawable.number_nine,"wo'e","nine"));
        objectNumber.add(new Word(R.drawable.number_ten,"na'aacha","ten"));


        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_numbers, objectNumber);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);


    }
}
