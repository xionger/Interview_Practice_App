package com.xiongxh.interviewpractice.questions;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xiongxh.interviewpractice.R;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.QuestionViewHolder> {

    private List<Question> mQuestions = new ArrayList<>();

    final OnQuestionClickListener questionClickListener;

    int currentPos;

    interface OnQuestionClickListener {

        void stepClicked(int stepId);
    }

    QuestionsAdapter(List<Question> questions, OnQuestionClickListener listener) {
        setQuestions(questions);
        questionClickListener = listener;
    }

    @NonNull
    @Override
    public QuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_question, parent, false);

        return new QuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestionViewHolder holder, int position) {
        if (mQuestions == null){
            return;
        }

        holder.bindQuestion(mQuestions.get(position), position);
    }

    @Override
    public int getItemCount() {
        if (mQuestions == null){
            return 0;
        }
        return mQuestions.size();
    }

    @Override
    public long getItemId(int position) {
        return mQuestions.get(position).getId();
    }

    void refreshQuestions(List<Question> questions) {
        setQuestions(questions);
        notifyDataSetChanged();
    }

    private void setQuestions(@NonNull List<Question> questions) {
        this.mQuestions = questions;
    }

    class QuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.item_question_layout)
        RelativeLayout stepItemLayout;

        @BindView(R.id.tv_question_short_description)
        TextView mShortDescriptionView;

        private int mQuestionId;

        QuestionViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(this);
        }

        void bindQuestion(@NonNull Question question, int bindPosition) {

            mQuestionId = question.getIdx();
            String shortDescription = question.getShortDescription();

            mShortDescriptionView.setText(String.format(Locale.US, "%d. %s", mQuestionId, shortDescription));

            /*
            String video = question.getVideoURL();

            if (video.isEmpty()) {
                videoIcon.setVisibility(View.INVISIBLE);
            } else {
                videoIcon.setVisibility(View.VISIBLE);
            }
            */

            /*
            if (currentPos == bindPosition && UiUtils.isTablet()) {
                stepItemLayout.setBackgroundColor(currentItemBackground);
            }else {
                stepItemLayout.setBackgroundColor(normalItemBackground);
            }
            */

        }

        @Override
        public void onClick(View view) {
            currentPos = mQuestionId;
            questionClickListener.stepClicked(mQuestionId);
            notifyDataSetChanged();
        }
    }
}
