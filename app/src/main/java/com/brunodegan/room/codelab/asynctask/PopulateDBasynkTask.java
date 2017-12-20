package com.brunodegan.room.codelab.asynctask;

import android.os.AsyncTask;

import com.brunodegan.room.codelab.dao.WordDao;
import com.brunodegan.room.codelab.database.WordRoomDatabase;
import com.brunodegan.room.codelab.model.Word;

/**
 * Created by brunodegan on 20/12/17.
 */

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

        mDao.insert(word);
        mDao.insert(word2);

        return null;
    }
}
