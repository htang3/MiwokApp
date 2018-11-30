package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        // Adding a list of number
        final ArrayList<Word> objectColor = new ArrayList<Word>();
        //Word w = new Word("Lutti", "One");
        objectColor.add(new Word(R.drawable.color_red,"wetetti","Red",R.raw.color_red));
        objectColor.add(new Word(R.drawable.color_green,"Chokokki","Green",R.raw.color_green));
        objectColor.add(new Word(R.drawable.color_brown,"takaakki","Brown",R.raw.color_brown));
        objectColor.add(new Word(R.drawable.color_gray,"Topoppi","Gray",R.raw.color_gray));
        objectColor.add(new Word(R.drawable.color_black,"Kululli","Black",R.raw.color_black));
        objectColor.add(new Word(R.drawable.color_white,"Kelelli","White",R.raw.color_white));
        objectColor.add(new Word(R.drawable.color_dusty_yellow,"Topiise","Dusty Yellow",R.raw.color_dusty_yellow));
        objectColor.add(new Word(R.drawable.color_mustard_yellow,"Chiwitte","Mustard Yellow",R.raw.color_mustard_yellow));



        //Create a Linear Layout by find the view related to the activity
        WordAdapter itemsAdapter = new WordAdapter(this,R.color.category_colors, objectColor);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = objectColor.get(position);
                releaseMediaPlayer();
                mp =MediaPlayer.create(ColorsActivity.this,word.getmAudioid());
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
