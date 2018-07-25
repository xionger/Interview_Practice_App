package com.xiongxh.interviewpractice.Interviews;

import com.xiongxh.interviewpractice.base.BasePresenter;
import com.xiongxh.interviewpractice.base.BaseView;
import com.xiongxh.interviewpractice.data.bean.Interview;

import java.util.List;

public interface InterviewsContract {
    interface View extends BaseView<Presenter> {
        void showInterviewList(List<Interview> interviewList);
        void showLoadingIndicator(boolean show);
        void showLoadingInterviewsErrorMessage(String error);
        void showLoadingInterviewsCompletedMessage();
        void showInterviewQuestions(long interviewId);

        Presenter getPresenter();
    }

    interface Presenter extends BasePresenter<View> {
        void loadInterviews();
        void openInterviewQuestions(int interviewId);

        void syncData();
    }
}
