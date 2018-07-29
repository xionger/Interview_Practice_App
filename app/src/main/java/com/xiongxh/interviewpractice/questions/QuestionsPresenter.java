package com.xiongxh.interviewpractice.questions;

import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;
import com.xiongxh.interviewpractice.data.interactor.InterviewInteractor;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import timber.log.Timber;

public class QuestionsPresenter implements QuestionsContract.Presenter {

    private QuestionsContract.View mInterviewView;
    private InterviewInteractor mInterviewInteractor;
    private CompositeDisposable mDisposableInterview = new CompositeDisposable();
    private int mInterviewId;

    public QuestionsPresenter(){
        mInterviewInteractor = new InterviewInteractor();
    }

    @Override
    public QuestionsContract.View getView() {
        return mInterviewView;
    }

    @Override
    public void subscribe(QuestionsContract.View view) {
        Timber.d("Entering subscribe ...");
        this.mInterviewView = view;
        loadInterviewDetails();
    }

    @Override
    public void unsubscribe() {
        mDisposableInterview.clear();
    }

    @Override
    public void loadInterviewDetails() {
        Timber.d("Loading interview questions ...");

        Disposable disposableQuestions = mInterviewInteractor
                .getInterviewDetails(mInterviewId)
                .subscribeWith(new DisposableSingleObserver<Interview>(){
                    @Override
                    public void onSuccess(@NonNull Interview interview){
                        mInterviewView.showInterviewDetails(interview);
                        mInterviewView.showQuestions(interview.getQuestions());
                        mInterviewView.showInterviewCategory(interview.getCategory());
                    }

                    @Override
                    public void onError(@NonNull Throwable e){
                        Timber.e(e);
                        mInterviewView.showErrorMessage(e.getMessage());
                    }
                });

        mDisposableInterview.add(disposableQuestions);
    }

    @Override
    public void fetchQuestionData(int questionId) {
        Timber.d("Loading question data ..., questionId: " + questionId);
        Disposable disposableQuestion = mInterviewInteractor
                .getInterviewDetails(mInterviewId)
                .subscribeWith(new DisposableSingleObserver<Interview>(){
                    @Override
                    public void onSuccess(@NonNull Interview interview){
                        Question question = interview.getQuestions().get(questionId);
                        mInterviewView.refreshQuestionContainer(
                                question.getDescription(),
                                question.getShortDescription(),
                                questionId);
                    }

                    @Override
                    public void onError(@NonNull Throwable e){
                        Timber.e(e);
                        mInterviewView.showErrorMessage(e.getMessage());
                    }
                });

        mDisposableInterview.add(disposableQuestion);
    }

    @Override
    public void openQuestionDetails(int questionId) {
        mInterviewView.showQuestionDetails(questionId);
    }

    @Override
    public void setInterviewId(int interviewId) {
        this.mInterviewId = interviewId;
    }

}
