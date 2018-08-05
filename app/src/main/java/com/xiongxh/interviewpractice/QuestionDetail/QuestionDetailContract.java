package com.xiongxh.interviewpractice.QuestionDetail;

import com.xiongxh.interviewpractice.base.BasePresenter;
import com.xiongxh.interviewpractice.base.BaseView;

public interface QuestionDetailContract {
    interface View extends BaseView<Presenter> {
        void showErrorMessage(String message);
        void showInterviewCategory(String interviewCategory);
        //void showQuestionsInPager(List<Question> questions);
        //void moveToCurrentStepPage();
    }

    interface Presenter extends BasePresenter<View> {
        void loadQuestionDetail();
        void setInterviewId(int interviewId);
        void setQuestionId(int questionId);
    }
}
