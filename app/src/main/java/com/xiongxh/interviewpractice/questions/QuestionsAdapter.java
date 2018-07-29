package com.xiongxh.interviewpractice.questions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {


    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private int mQuestionId;

        QuestionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
