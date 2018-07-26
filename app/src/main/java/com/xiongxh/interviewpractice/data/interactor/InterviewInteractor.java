package com.xiongxh.interviewpractice.data.interactor;

import com.xiongxh.interviewpractice.data.InterviewsRepository;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.local.InterviewsLocalDataSource;
import com.xiongxh.interviewpractice.data.remote.InterviewsRemoteDataSource;
import com.xiongxh.interviewpractice.rx.RxScheduler;

import io.reactivex.Single;

public class InterviewInteractor {
    private InterviewsRepository mInterviewsRepository;

    public InterviewInteractor(){
        this.mInterviewsRepository =
                new InterviewsRepository(new InterviewsLocalDataSource(),
                        new InterviewsRemoteDataSource());
    }

    public Single<Interview> getQuestions(int interviewId){
        return mInterviewsRepository.getInterview(interviewId)
                .compose(RxScheduler.applySchedulersSingle());
    }
}
