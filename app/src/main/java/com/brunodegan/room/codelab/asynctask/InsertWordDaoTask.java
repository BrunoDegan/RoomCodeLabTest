package com.brunodegan.room.codelab.asynctask;

import android.os.AsyncTask;

import com.brunodegan.room.codelab.dao.WordDao;
import com.brunodegan.room.codelab.model.Word;

public class InsertWordDaoTask extends AsyncTask<Word, Void, Void> {

    private WordDao mAsyncTaskDao;

    public InsertWordDaoTask(WordDao wordDao) {
        this.mAsyncTaskDao = wordDao;
    }

    @Override
    protected Void doInBackground(Word... words) {
        mAsyncTaskDao.insert(words[0]);
        return null;
    }
}
