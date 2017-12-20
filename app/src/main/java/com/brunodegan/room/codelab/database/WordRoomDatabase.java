package com.brunodegan.room.codelab.database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.brunodegan.room.codelab.asynctask.PopulateDBasynkTask;
import com.brunodegan.room.codelab.dao.WordDao;
import com.brunodegan.room.codelab.model.Word;

@Database(entities = {Word.class}, version = 1, exportSchema = false)

public abstract class WordRoomDatabase extends RoomDatabase {

    private static WordRoomDatabase DATABASE_INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context) {
        if(DATABASE_INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
               DATABASE_INSTANCE =
                       Room.databaseBuilder(context.getApplicationContext()
                               ,WordRoomDatabase.class,
                               "word_database").addCallback(roomDatabaseCallback).build();
            }
        }
        return DATABASE_INSTANCE;
    }

    public abstract WordDao wordDao();

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDBasynkTask(DATABASE_INSTANCE).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
}
