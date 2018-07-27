package com.xiongxh.interviewpractice.Interviews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiongxh.interviewpractice.R;
import com.xiongxh.interviewpractice.data.bean.Interview;

import java.util.List;


public class InterviewsFragment extends Fragment implements InterviewsContract.View {

    public InterviewsFragment() {
        // Required empty public constructor
    }

    public static InterviewsFragment newInstance() {
        return new InterviewsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_interviews, container, false);
    }

    @Override
    public void showInterviewList(List<Interview> interviewList) {

    }

    @Override
    public void showLoadingIndicator(boolean show) {

    }

    @Override
    public void showLoadingInterviewsErrorMessage(String error) {

    }

    @Override
    public void showLoadingInterviewsCompletedMessage() {

    }

    @Override
    public void showInterviewQuestions(long interviewId) {

    }

    @Override
    public InterviewsContract.Presenter getPresenter() {
        return null;
    }

    @Override
    public void setPresenter(InterviewsContract.Presenter presenter) {

    }
}
