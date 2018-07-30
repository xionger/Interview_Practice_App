package com.xiongxh.interviewpractice.QuestionDetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiongxh.interviewpractice.R;

public class QuestionDetailFragment extends Fragment implements QuestionDetailContract.View{
    private static final String QUESTION_ID_KEY = "QUESTION_ID_KEY";

    public QuestionDetailFragment() {
        // Required empty public constructor
    }

    public static QuestionDetailFragment newInstance(int questionId) {

        Bundle args = new Bundle();
        QuestionDetailFragment fragment = new QuestionDetailFragment();
        args.putInt(QUESTION_ID_KEY, questionId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_detail, container, false);
    }

    @Override
    public void showErrorMessage(String message) {

    }

    @Override
    public void showInterviewCategory(String interviewCategory) {

    }

    @Override
    public void setPresenter(QuestionDetailContract.Presenter presenter) {

    }
}
