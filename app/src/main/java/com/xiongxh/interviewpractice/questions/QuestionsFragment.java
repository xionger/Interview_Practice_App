package com.xiongxh.interviewpractice.questions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiongxh.interviewpractice.R;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;


public class QuestionsFragment extends Fragment implements QuestionsContract.View{


    public QuestionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false);
    }

    @Override
    public void showInterviewDetails(Interview interview) {

    }

    @Override
    public void showQuestions(List<Question> questionList) {

    }

    @Override
    public void showQuestionDetails(int questionId) {

    }

    @Override
    public void showInterviewCategory(String interviewCategory) {

    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void refreshQuestionContainer(String desc, String shortDesc, int questionId) {

    }

    @Override
    public void setPresenter(QuestionsContract.Presenter presenter) {

    }
}
