package com.xiongxh.interviewpractice.base;


import com.xiongxh.interviewpractice.Interviews.InterviewsContract;
import com.xiongxh.interviewpractice.Interviews.InterviewsPresenter;
import com.xiongxh.interviewpractice.questions.QuestionsContract;
import com.xiongxh.interviewpractice.questions.QuestionsPresenter;

public class PresenterProvider {
    public InterviewsContract.Presenter provideInterviews() {
        return new InterviewsPresenter();
    }

    public QuestionsContract.Presenter provideQuestions() {
        return new QuestionsPresenter();
    }
}
