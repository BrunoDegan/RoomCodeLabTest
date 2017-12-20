package com.brunodegan.room.codelab.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brunodegan.room.codelab.R;
import com.brunodegan.room.codelab.model.Word;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    final class WordViewHolder extends RecyclerView.ViewHolder {
        private TextView wordTextView;

        public WordViewHolder(View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.textView);
        }
    }

    public WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if(mWords != null) {
            Word current = mWords.get(position);
            holder.wordTextView.setText(current.getWord());
        } else {
            holder.wordTextView.setText("No word!");
        }
    }

    public void setWord(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        if(mWords != null)
            return mWords.size();
        else return 0;
    }

}
