package com.xiongxh.interviewpractice.questions;

import com.xiongxh.interviewpractice.base.BasePresenter;
import com.xiongxh.interviewpractice.base.BaseView;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;

public interface QuestionsContract {
    interface View extends BaseView<Presenter> {
        void showInterviewQuestions(Interview interview);

        void showSteps(List<Question> questionList);
        void showQuestionDetails(int questionId);
        void showInterviewCategory(String interviewCategory);
        void showErrorMessage(String message);

        void refreshQuestionContainer(String desc, String shortDesc, String videoUrl);
    }

    interface Presenter extends BasePresenter<View> {
        void loadInterviewQuestions();
        void openQuestionDetails(int questionId);
        void fetchQuestionData(int questionId);
        void setInterviewId(int interviewId);
    }
}
