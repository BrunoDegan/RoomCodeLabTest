package com.brunodegan.room.codelab.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.brunodegan.room.codelab.database.WordRepository;
import com.brunodegan.room.codelab.model.Word;

import java.util.List;


public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWords() {
        return wordRepository.getAllWords();
    }

    public void insert(Word word) {
        wordRepository.insertWord(word);
    }
}
