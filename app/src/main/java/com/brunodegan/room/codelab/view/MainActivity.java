package com.brunodegan.room.codelab.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.brunodegan.room.codelab.R;
import com.brunodegan.room.codelab.asynctask.PopulateDBasynkTask;
import com.brunodegan.room.codelab.model.Word;
import com.brunodegan.room.codelab.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    private WordViewModel mWordViewModel;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rcView = findViewById(R.id.recyclerview);

        final WordListAdapter wordListAdapter = new WordListAdapter(getApplicationContext());
        rcView.setAdapter(wordListAdapter);
        rcView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable List<Word> words) {
                wordListAdapter.setWord(words);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(getApplicationContext(),
                    R.string.empty_not_saved, Toast.LENGTH_SHORT).show();
        }
    }
}
