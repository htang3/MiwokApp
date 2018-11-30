package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Adding a list of phrases
        final ArrayList<Word> objectPhrases = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectPhrases.add(new Word("Minto wuksus","Where are you going?",R.raw.phrase_where_are_you_going));
        objectPhrases.add(new Word("tinne oyaase'ne","What is your name?",R.raw.phrase_what_is_your_name));
        objectPhrases.add(new Word("oyaaset","My name is",R.raw.phrase_my_name_is));
        objectPhrases.add(new Word("michekses?","How are you feeling?",R.raw.phrase_how_are_you_feeling));
        objectPhrases.add(new Word("kuchi achit","I'm feeling good",R.raw.phrase_im_feeling_good));
        objectPhrases.add(new Word("eenes'aa","Are you comming?",R.raw.phrase_are_you_coming));
        objectPhrases.add(new Word("hee'eenem","Yes, I'm coming",R.raw.phrase_yes_im_coming));
        objectPhrases.add(new Word("eenem","I'm coming",R.raw.phrase_im_coming));
        objectPhrases.add(new Word("yoowutis","Let's go",R.raw.phrase_lets_go));
        objectPhrases.add(new Word("enni'nem","Come here",R.raw.phrase_come_here));


        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_phrases, objectPhrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = objectPhrases.get(position);
                releaseMediaPlayer();
                mp =MediaPlayer.create(PhrasesActivity.this,word.getmAudioid());
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
