package com.xiongxh.interviewpractice.base;

public class PresenterProvider {
    public InteriewsContract.Presenter provideInterviews() {
        return new InterviewsPresenter();
    }

    /*
    public InterviewQuestionsContract.Presenter provideQuestions() {
        return new InterviewQuestionsPresenter();
    }
    */
}
