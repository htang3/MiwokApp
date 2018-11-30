package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Adding a list of family
        final ArrayList<Word> objectColor = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectColor.add(new Word(R.drawable.family_father,"Epe","Father",R.raw.family_father));
        objectColor.add(new Word(R.drawable.family_mother,"Eta","Mother",R.raw.family_mother));
        objectColor.add(new Word(R.drawable.family_son,"Angsi","Son",R.raw.family_son));
        objectColor.add(new Word(R.drawable.family_daughter,"Tune","Daughter",R.raw.family_daughter));
        objectColor.add(new Word(R.drawable.family_older_brother,"Taachi","Older brother",R.raw.family_older_brother));
        objectColor.add(new Word(R.drawable.family_younger_brother,"Chalitti","Younger Brother",R.raw.family_younger_brother));
        objectColor.add(new Word(R.drawable.family_older_sister,"Tete","Older Sister",R.raw.family_older_sister));
        objectColor.add(new Word(R.drawable.family_younger_sister,"Kolliti","Younger sister",R.raw.family_younger_sister));
        objectColor.add(new Word(R.drawable.family_grandmother,"Ama","Grandmother",R.raw.family_grandmother));
        objectColor.add(new Word(R.drawable.family_grandfather,"Paape","Grandfather",R.raw.family_grandfather));



        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_family, objectColor);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = objectColor.get(position);
                releaseMediaPlayer();
                mp =MediaPlayer.create(FamilyActivity.this, word.getmAudioid());
                mp.start();
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });

    }
    private void releaseMediaPlayer(){
        if (mp!=null){
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }
}
