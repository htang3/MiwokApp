package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int backgroundColor;

    public WordAdapter(Activity context, int backGround, ArrayList<Word> words){
        super(context,0,words);//the constructor from ArrayAdapter
        backgroundColor =backGround;
    }

    /**
     * Provides a view for AdapterView(ListView, GridView, etc.)
     * @param position the AdapterView position that is requesting a view
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup is used for inflation.
     * @return view
     */

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Create an Object of word, and use it as a reference for miwok_word and English_word. Return a list of item
        //and index position. Return value is object with data type Word.
        Word currentWord  = getItem(position);

        //ConvertView
        View listItemVIew = convertView;
        if (listItemVIew==null){
            listItemVIew= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        ImageView iconView =(ImageView) listItemVIew.findViewById(R.id.icon_view);
        if (currentWord.hasImage()){
            iconView.setImageResource(currentWord.getmIcon());
            iconView.setVisibility(View.VISIBLE);
        }
        else{
            iconView.setVisibility(View.GONE);
        }


        TextView miwokView =(TextView) listItemVIew.findViewById(R.id.miwok_word);
        miwokView.setText(currentWord.getmMiwokWord());

        TextView englishText =(TextView) listItemVIew.findViewById(R.id.English_word);
        englishText.setText(currentWord.getmEnglishWord());

        /**
         * Add background color
         **/

        View textView = (View) listItemVIew.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),backgroundColor);
        textView.setBackgroundColor(color);




        return listItemVIew;
    }
}
