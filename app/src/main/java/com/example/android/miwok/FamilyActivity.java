package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Adding a list of family
        ArrayList<Word> objectColor = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectColor.add(new Word(R.drawable.family_father,"Epe","Father"));
        objectColor.add(new Word(R.drawable.family_mother,"Eta","Mother"));
        objectColor.add(new Word(R.drawable.family_son,"Angsi","Son"));
        objectColor.add(new Word(R.drawable.family_daughter,"Tune","Daughter"));
        objectColor.add(new Word(R.drawable.family_older_brother,"Taachi","Older brother"));
        objectColor.add(new Word(R.drawable.family_younger_brother,"Chalitti","Younger Brother"));
        objectColor.add(new Word(R.drawable.family_older_sister,"Tete","Older Sister"));
        objectColor.add(new Word(R.drawable.family_younger_sister,"Kolliti","Younger sister"));
        objectColor.add(new Word(R.drawable.family_grandmother,"Ama","Grandmother"));
        objectColor.add(new Word(R.drawable.family_grandfather,"Paape","Grandfather"));



        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_family, objectColor);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}
