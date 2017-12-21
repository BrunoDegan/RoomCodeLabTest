package com.brunodegan.room.codelab.asynctask;

import android.os.AsyncTask;

import com.brunodegan.room.codelab.dao.WordDao;
import com.brunodegan.room.codelab.database.WordRoomDatabase;
import com.brunodegan.room.codelab.model.Word;

public class PopulateDBasynkTask extends AsyncTask {

    private WordDao mDao;

    public PopulateDBasynkTask(WordRoomDatabase roomDB) {
        this.mDao = roomDB.wordDao();
    }
    @Override
    protected Object doInBackground(Object[] objects) {
        mDao.deleteAllwords();
        Word word = new Word("Hello");
        Word word2 = new Word("Hi");
        Word word3 = new Word("Hi");
        Word word4 = new Word("Hi");
        Word word5 = new Word("Hi");
        Word word6 = new Word("Hi");
    
    
        mDao.insert(word);
        mDao.insert(word2);
        mDao.insert(word3);
        mDao.insert(word4);
        mDao.insert(word5);
        mDao.insert(word6);
        mDao.insert(word2);

        return null;
    }
}
