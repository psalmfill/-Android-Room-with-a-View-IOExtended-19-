package com.samfieldhawb.roomwordsample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }
    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new insertAsyncTask(mWordDao).execute(word);
    }

    //Asynctas to handle background insertion
    private static class insertAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao mAsyncTaskDoa;

        public insertAsyncTask(WordDao wordDao) {
            mAsyncTaskDoa = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mAsyncTaskDoa.insertWord(words[0]);
            return null;
        }
    }
}
