package com.xiongxh.interviewpractice.data;

import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;

import io.reactivex.Single;

public interface InterviewsDataSource {
    Single<List<Interview>> getInterviews();
    Single<Interview> getInterview(int interviewId);

    Single<List<Question>> getQuestionsOfInterview(int interviewId);

    void setInterviews(List<Interview> interviews);
}
