package com.example.android.miwok;

import android.media.MediaPlayer;

/**
 * this class contain method to present vocabulary in both version Miwok and English
 */

public class Word {

    private String mMiwokWord;

    private String mEnglishWord;
    private  int mAudioid;

    private int mIconID =NOIMAGE;

    private static final int NOIMAGE =-1;

    public Word(String miwokWord, String englishWord, int audioId){
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mAudioid =audioId;


    }
    public Word(int icon, String miwokWord, String englishWord, int audioId){
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
        mAudioid=audioId;
        mIconID=icon;
    }

    /**
     * Allow user to get the English version of the word
     * @return English version of Miwok word
     */
    public String getmEnglishWord() {
        return mEnglishWord;
    }

    /**
     * Allow user to get the Miwok version of the word
     * @return miwork
     */
    public String getmMiwokWord() {
        return mMiwokWord;
    }
    /**
     *@return icon resource id
     */
    public int getmIcon(){
        return mIconID;
    }

    public int getmAudioid(){
        return mAudioid;
    }


    public boolean hasImage(){
        return mIconID != NOIMAGE;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokWord='" + mMiwokWord + '\'' +
                ", mEnglishWord='" + mEnglishWord + '\'' +
                ", mAudioid=" + mAudioid +
                ", mIconID=" + mIconID +
                '}';
    }
}
