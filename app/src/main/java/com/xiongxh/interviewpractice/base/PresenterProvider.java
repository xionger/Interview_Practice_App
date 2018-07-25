package com.xiongxh.interviewpractice.base;


import com.xiongxh.interviewpractice.Interviews.InterviewsContract;
import com.xiongxh.interviewpractice.Interviews.InterviewsPresenter;

public class PresenterProvider {
    public InterviewsContract.Presenter provideInterviews() {
        return new InterviewsPresenter();
    }

    /*
    public InterviewQuestionsContract.Presenter provideQuestions() {
        return new InterviewQuestionsPresenter();
    }
    */
}
