package com.xiongxh.interviewpractice.QuestionDetail;

import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.interactor.InterviewInteractor;

import io.reactivex.disposables.CompositeDisposable;

public class QuestionDetailPresenter implements QuestionDetailContract.Presenter {

    CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private QuestionDetailContract.View mQuestionDetailView;
    private int mInterviewId;
    private int mQuestionId;
    private Interview mInterview;

    private InterviewInteractor mInterviewInteractor;
    //private int mCurrentQuestion = -1;

    @Override
    public void loadQuestionDetail() {

    }

    @Override
    public void setInterviewId(int interviewId) {

    }

    @Override
    public void setQuestionId(int questionId) {

    }

    @Override
    public QuestionDetailContract.View getView() {
        return null;
    }

    @Override
    public void subscribe(QuestionDetailContract.View view) {

    }

    @Override
    public void unsubscribe() {

    }
}
