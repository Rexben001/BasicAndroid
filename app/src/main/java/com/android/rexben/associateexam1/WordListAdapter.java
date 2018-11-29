package com.android.rexben.associateexam1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder>{

    private LinkedList<String> mWordList;
    private LayoutInflater layoutInflater;

    public WordListAdapter(Context context, LinkedList<String> wordList){
        layoutInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }
    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.word_list_item, parent, false);
        return new WordViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.wordItemVIew.setText(mCurrent);

    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    public class WordViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
        TextView wordItemVIew;
        WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemVIew = itemView.findViewById(R.id.word);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int mPosition = getLayoutPosition();

            String element = mWordList.get(mPosition);

            mWordList.set(mPosition, "Clicked "+ element);

            mAdapter.notifyDataSetChanged();
        }
    }
}
