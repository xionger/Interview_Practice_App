package com.xiongxh.interviewpractice.data;

import com.xiongxh.interviewpractice.InterviewApp;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;
import com.xiongxh.interviewpractice.data.local.InterviewsLocalDataSource;
import com.xiongxh.interviewpractice.data.remote.InterviewsRemoteDataSource;

import java.util.List;

import io.reactivex.Single;
import timber.log.Timber;

public class InterviewsRepository implements InterviewsDataSource {
    private InterviewsLocalDataSource mInterviewsLocalDataSource;
    private InterviewsRemoteDataSource mInterviewsRemoteDataSource;

    public InterviewsRepository(InterviewsLocalDataSource localDataSource, InterviewsRemoteDataSource remoteDataSource){
        this.mInterviewsLocalDataSource = localDataSource;
        this.mInterviewsRemoteDataSource = remoteDataSource;
    }

    public boolean isSynced(){
        return InterviewApp.get().interviewPreferences.isInterviewsSynced();
    }

    @Override
    public Single<List<Interview>> getInterviews() {
        if (isSynced()){
            return mInterviewsLocalDataSource.getInterviews();
        }else {
            Timber.d("Data is not up to date.");
            return mInterviewsRemoteDataSource.getInterviews();
        }
    }

    @Override
    public Single<Interview> getInterview(int interviewId) {
        Timber.d("Get single interview data from local database");
        return mInterviewsLocalDataSource.getInterview(interviewId);
    }

    @Override
    public Single<List<Question>> getQuestionsOfInterview(int interviewId) {
        return null;
    }

    @Override
    public void setInterviews(List<Interview> interviews) {
        mInterviewsLocalDataSource.setInterviews(interviews);
    }
}
