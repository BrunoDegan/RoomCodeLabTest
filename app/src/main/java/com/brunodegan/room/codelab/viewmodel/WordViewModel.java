package com.brunodegan.room.codelab.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.brunodegan.room.codelab.database.WordRepository;
import com.brunodegan.room.codelab.model.Word;

import java.util.List;

/**
 * Created by brunodegan on 20/12/17.
 */

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
        mAllWords = wordRepository.getAllWords();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert(Word word) {
        wordRepository.insertWord(word);
    }
}
