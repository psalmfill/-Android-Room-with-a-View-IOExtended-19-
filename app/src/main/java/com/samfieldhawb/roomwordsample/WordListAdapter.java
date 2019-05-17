package com.samfieldhawb.roomwordsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordHolder> {
    private LayoutInflater mLayoutInflater;
    private List<Word> mWords ;

    public WordListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WordHolder(mLayoutInflater.inflate(R.layout.recyclerview_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull WordHolder holder, int position) {
        if(mWords !=null) {
            holder.wordItemView.setText(mWords.get(position).getWord());
        }else {
            holder.wordItemView.setText("no word");
        }
    }
    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mWords !=null?mWords.size():0;
    }

    class WordHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        public WordHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
