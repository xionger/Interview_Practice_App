package com.xiongxh.interviewpractice.questions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiongxh.interviewpractice.InterviewApp;
import com.xiongxh.interviewpractice.R;

public class QuestionsActivity extends AppCompatActivity {
    public static final String INTERVIEW_ID_KEY = "INTERVIEW_ID_KEY";
    public static final String TAG_QUESTIONS_FRAGMENT = "TAG_QUESTIONS_FRAGMENT";

    QuestionsFragment mQuestionsFragment;
    int mInterviewId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        mInterviewId = getIntent().getIntExtra(INTERVIEW_ID_KEY, -1);

        if (savedInstanceState == null) {
            mQuestionsFragment = QuestionsFragment.newInstance(mInterviewId);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.questions_container, mQuestionsFragment, TAG_QUESTIONS_FRAGMENT)
                    .commit();
        }

        if (mQuestionsFragment == null){
            mQuestionsFragment =
                    (QuestionsFragment) getSupportFragmentManager().findFragmentByTag(TAG_QUESTIONS_FRAGMENT);
        }

        QuestionsContract.Presenter presenter = InterviewApp.get().presenterProvider.provideQuestions();

        presenter.setInterviewId(mInterviewId);
        mQuestionsFragment.setPresenter(presenter);
    }

    public static void onStartActivity(Context context, int interviewId){
        context.startActivity(
                new Intent(context, QuestionsActivity.class)
                .putExtra(INTERVIEW_ID_KEY, interviewId)
        );
    }
}
