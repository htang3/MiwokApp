package com.example.android.miwok;

/**
 * this class contain method to present vocabulary in both version Miwok and English
 */

public class Word {

    private String mMiwokWord;

    private String mEnglishWord;

    private int mIconID =NOIMAGE;

    private static final int NOIMAGE =-1;

    public Word(String miwokWord, String englishWord){
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;

    }
    public Word(int icon, String miwokWord, String englishWord){
        mMiwokWord = miwokWord;
        mEnglishWord = englishWord;
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

    public boolean hasImage(){
        return mIconID != NOIMAGE;
    }
}
