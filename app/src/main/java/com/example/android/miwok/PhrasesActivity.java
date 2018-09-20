package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Adding a list of phrases
        ArrayList<Word> objectPhrases = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectPhrases.add(new Word("Minto wuksus","Where are you going?"));
        objectPhrases.add(new Word("tinne oyaase'ne","What is your name?"));
        objectPhrases.add(new Word("oyaaset","My name is"));
        objectPhrases.add(new Word("michekses?","How are you feeling?"));
        objectPhrases.add(new Word("kuchi achit","I'm feeling good"));
        objectPhrases.add(new Word("eenes'aa","Are you comming?"));
        objectPhrases.add(new Word("hee'eenem","Yes, I'm coming"));
        objectPhrases.add(new Word("eenem","I'm coming"));
        objectPhrases.add(new Word("yoowutis","Let's go"));
        objectPhrases.add(new Word("enni'nem","Come here"));


        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_phrases, objectPhrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

    }
}
