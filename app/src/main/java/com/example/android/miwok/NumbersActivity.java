package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    private MediaPlayer playSound;
    // call back to notify us when MediaPlayer finished playing the audio
    private MediaPlayer.OnCompletionListener mCompletion = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        // Adding a list of number
        final ArrayList<Word> objectNumber = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectNumber.add(new Word(R.drawable.number_one,"Lutti","One",R.raw.number_one));
        objectNumber.add(new Word(R.drawable.number_two,"otiiko","two",R.raw.number_two));
        objectNumber.add(new Word(R.drawable.number_three,"tolookosu","three",R.raw.number_three));
        objectNumber.add(new Word(R.drawable.number_four,"oyyisa","four",R.raw.number_four));
        objectNumber.add(new Word(R.drawable.number_five,"massokka","five",R.raw.number_five));
        objectNumber.add(new Word(R.drawable.number_six,"temmokka","six",R.raw.number_six));
        objectNumber.add(new Word(R.drawable.number_seven,"kenekaku","seven",R.raw.number_seven));
        objectNumber.add(new Word(R.drawable.number_eight,"kawinta","eight",R.raw.number_eight));
        objectNumber.add(new Word(R.drawable.number_nine,"wo'e","nine",R.raw.number_nine));
        objectNumber.add(new Word(R.drawable.number_ten,"na'aacha","ten",R.raw.number_ten));



        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_numbers, objectNumber);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                Word word = objectNumber.get(position);
//                releaseMediaPlayer();
//                playSound = MediaPlayer.create(NumbersActivity.this, word.getmAudioid());
//                playSound.start();
//                playSound.setOnCompletionListener(mCompletion);
//            }
//        });
        //setOnItemClickListener: Register a callback method to be invoked when an item in this AdapterView is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // interface a callback method to be invoked when an item in this AdapterView is clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //ArrayList above need to be final before get the postion
                        Word word = objectNumber.get(position);
                        releaseMediaPlayer();
                        playSound =MediaPlayer.create(NumbersActivity.this, word.getmAudioid());
                        playSound.start();
                        playSound.setOnCompletionListener(mCompletion);
            }
        });


    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (playSound != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            playSound.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            playSound = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();

        releaseMediaPlayer();
    }

}
