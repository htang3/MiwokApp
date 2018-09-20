package com.example.android.miwok;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView number = (TextView) findViewById(R.id.numbers);
        number.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent i = new Intent(MainActivity.this, NumbersActivity.class);
                                          startActivity(i);
                                      }
                                  }

        );
        //FamilyMember clickListener
        TextView familyMember = (TextView) findViewById(R.id.familymember);
        familyMember.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent i = new Intent(MainActivity.this, FamilyActivity.class);
                                          startActivity(i);
                                      }
                                  }

        );
        //Colors clickListener
        TextView color =(TextView) findViewById(R.id.colors);
        color.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent i = new Intent(MainActivity.this,ColorsActivity.class);
                                          startActivity(i);
                                      }
                                  }

        );
        //Phrases clickListener
        TextView phrasesListener =(TextView) findViewById(R.id.phrases);
        phrasesListener.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent i = new Intent(MainActivity.this,PhrasesActivity.class);
                                          startActivity(i);
                                      }
                                  }

        );
    }

}
