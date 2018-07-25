package com.xiongxh.interviewpractice.data;

import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;

import io.reactivex.Single;

public class InterviewsRepository implements InterviewsDataSource {
    @Override
    public Single<List<Interview>> getInterviews() {
        return null;
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
