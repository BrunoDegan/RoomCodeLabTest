package com.brunodegan.room.codelab.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.brunodegan.room.codelab.model.Word;

import java.util.List;


@Dao
public interface WordDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(Word word);

    @Delete
    void delete(Word word);

    @Query("DELETE FROM word_table")
    void deleteAllwords();

    @Query("SELECT * from word_table ORDER BY word ASC")
    List<Word> getAllWords();

}
