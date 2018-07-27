package com.xiongxh.interviewpractice.questions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xiongxh.interviewpractice.R;

public class QuestionsActivity extends AppCompatActivity {
    public static final String INTERVIEW_ID_KEY = "INTERVIEW_ID_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
    }

    public static void onStartActivity(Context context, int interviewId){
        context.startActivity(
                new Intent(context, QuestionsActivity.class)
                .putExtra(INTERVIEW_ID_KEY, interviewId)
        );
    }
}
