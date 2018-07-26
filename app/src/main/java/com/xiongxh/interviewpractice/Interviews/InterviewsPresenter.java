package com.xiongxh.interviewpractice.Interviews;

import android.support.annotation.NonNull;

import com.xiongxh.interviewpractice.InterviewApp;
import com.xiongxh.interviewpractice.data.InterviewsRepository;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.interactor.InterviewsInteractor;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;
import timber.log.Timber;

public class InterviewsPresenter implements InterviewsContract.Presenter {

    private InterviewsContract.View mInterviewsView;
    private InterviewsRepository mInterviewsRepository;

    private InterviewsInteractor mInterviewsInteractor;

    private CompositeDisposable mDisposableInterviews = new CompositeDisposable();

    public InterviewsPresenter(){
        mInterviewsInteractor = new InterviewsInteractor();
    }

    @Override
    public void loadInterviews() {
        Timber.d("Loading interviews ...");
        mInterviewsView.showLoadingIndicator(true);

        Disposable disposableInterviews = mInterviewsInteractor
                .getInterviews()
                .subscribeWith(new DisposableSingleObserver<List<Interview>>() {
                    @Override
                    public void onSuccess(@NonNull List<Interview> interviews) {
                        mInterviewsView.showLoadingIndicator(false);
                        mInterviewsView.showInterviewList(interviews);
                        mInterviewsView.showLoadingInterviewsCompletedMessage();
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Timber.e(e);
                        mInterviewsView.showLoadingIndicator(false);
                        mInterviewsView.showLoadingInterviewsErrorMessage(e.getMessage());
                    }
                });

        mDisposableInterviews.add(disposableInterviews);
    }

    @Override
    public void openInterviewQuestions(int interviewId) {
        mInterviewsView.showInterviewQuestions(interviewId);
    }

    @Override
    public void syncData() {
        Timber.d("Set syncData to FALSE.");
        InterviewApp.get().interviewPreferences.setInterviewsSynced(false);
        loadInterviews();
    }

    @Override
    public InterviewsContract.View getView() {
        return mInterviewsView;
    }

    @Override
    public void subscribe(InterviewsContract.View view) {
        this.mInterviewsView = view;
        loadInterviews();
    }

    @Override
    public void unsubscribe() {
        mDisposableInterviews.clear();
    }
}
