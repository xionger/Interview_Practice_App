package com.xiongxh.interviewpractice.data.remote;

import com.xiongxh.interviewpractice.api.InterviewApiService;
import com.xiongxh.interviewpractice.data.InterviewsDataSource;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;

import io.reactivex.Single;
import timber.log.Timber;

public class InterviewsRemoteDataSource implements InterviewsDataSource{

    @Override
    public Single<List<Interview>> getInterviews() {
        Timber.d("Get interviews data from API");
        return InterviewApiService.initService().fetchInterviewsFromServer();
    }

    @Override
    public Single<Interview> getInterview(int interviewId) {
        return null;
    }

    @Override
    public Single<List<Question>> getQuestionsOfInterview(int interviewId) {
        return null;
    }

    @Override
    public void setInterviews(List<Interview> interviews) {

    }
}
