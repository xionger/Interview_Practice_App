package com.xiongxh.interviewpractice.data.interactor;

import com.xiongxh.interviewpractice.InterviewApp;
import com.xiongxh.interviewpractice.data.InterviewsRepository;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.local.InterviewsLocalDataSource;
import com.xiongxh.interviewpractice.data.remote.InterviewsRemoteDataSource;
import com.xiongxh.interviewpractice.rx.RxScheduler;

import java.util.List;

import io.reactivex.Single;
import timber.log.Timber;

public class InterviewsInteractor {
    private InterviewsRepository mInterviewsRepository;

    public InterviewsInteractor(){
        this.mInterviewsRepository =
                new InterviewsRepository(new InterviewsLocalDataSource(),
                        new InterviewsRemoteDataSource());
    }

    public Single<List<Interview>> getInterviews(){
        if (mInterviewsRepository.isSynced()){
            Timber.d("Data are updated. Retrieve data from local database.");
            return mInterviewsRepository.getInterviews().compose(RxScheduler.applySchedulersSingle());
        }

        return mInterviewsRepository.getInterviews()
                .doOnSuccess(interviews -> {
                    Timber.d("Saving interview list into the database");
                    mInterviewsRepository.setInterviews(interviews);
                    InterviewApp.get().interviewPreferences.setInterviewsSynced(true);
                })
                .compose(RxScheduler.applySchedulersSingle());
    }
}
