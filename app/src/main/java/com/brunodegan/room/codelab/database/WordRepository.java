package com.brunodegan.room.codelab.database;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.brunodegan.room.codelab.asynctask.InsertWordDaoTask;
import com.brunodegan.room.codelab.dao.WordDao;
import com.brunodegan.room.codelab.model.Word;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase roomDatabase =
                WordRoomDatabase.getDatabase(application.getApplicationContext());

        mWordDao = roomDatabase.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insertWord(Word newWord) {
        new InsertWordDaoTask(mWordDao).execute(newWord);
    }
}
