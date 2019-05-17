package com.samfieldhawb.roomwordsample;
import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mWordRepository;
    private LiveData<List<Word>> mWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mWordRepository = new WordRepository(application);
        mWords = mWordRepository.getAllWords();
    }

    public LiveData<List<Word>> getWords() {
        return mWords;
    }
    public void insert(Word word){
        mWordRepository.insert(word);
    }
}
