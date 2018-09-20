package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Adding a list of number
        ArrayList<Word> objectColor = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectColor.add(new Word(R.drawable.color_red,"wetetti","Red"));
        objectColor.add(new Word(R.drawable.color_green,"Chokokki","Green"));
        objectColor.add(new Word(R.drawable.color_brown,"takaakki","Brown"));
        objectColor.add(new Word(R.drawable.color_gray,"Topoppi","Gray"));
        objectColor.add(new Word(R.drawable.color_black,"Kululli","Black"));
        objectColor.add(new Word(R.drawable.color_white,"Kelelli","White"));
        objectColor.add(new Word(R.drawable.color_dusty_yellow,"Topiise","Dusty Yellow"));
        objectColor.add(new Word(R.drawable.color_mustard_yellow,"Chiwitte","Mustard Yellow"));



        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_colors, objectColor);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
