package com.xiongxh.interviewpractice.Interviews;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.xiongxh.interviewpractice.R;
import com.xiongxh.interviewpractice.data.InterviewPreferences;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.questions.QuestionsActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class InterviewsFragment extends Fragment implements InterviewsContract.View {

    @BindView(R.id.rv_list_interview)
    RecyclerView mInterviewsRecyclerView;

    @BindView(R.id.pb_list_interview)
    ProgressBar mInterviewsProgressbar;

    Unbinder unbinder;

    private InterviewsContract.Presenter mInterviewsPresenter;
    private InterviewsAdapter mInterviewsAdapter;
    private LinearLayoutManager mLinearLayoutManager;

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
        View rootView = inflater.inflate(R.layout.fragment_interviews, container, false);
        unbinder = ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);

        mInterviewsAdapter = new InterviewsAdapter(
                interview -> QuestionsActivity.onStartActivity(getContext(), interview.getId())
        );

        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mInterviewsRecyclerView.setLayoutManager(mLinearLayoutManager);

        mInterviewsRecyclerView.setAdapter(mInterviewsAdapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        mInterviewsPresenter.subscribe(this);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        mInterviewsPresenter.unsubscribe();
        unbinder.unbind();
    }

    @Override
    public void onPause(){
        super.onPause();
    }

    @Override
    public void showInterviewList(List<Interview> interviewList) {
        if (interviewList.size() <= 0){
            InterviewPreferences interviewPreferences = new InterviewPreferences(getContext());
            interviewPreferences.setInterviewsSynced(false);
            mInterviewsPresenter.subscribe(this);
        }
        Log.d("interview list size:", "" + interviewList.size());

        mInterviewsAdapter.refreshInterviews(interviewList);
    }

    @Override
    public void showLoadingIndicator(boolean show) {
        if (show){
            mInterviewsRecyclerView.setVisibility(View.INVISIBLE);
            mInterviewsProgressbar.setVisibility(View.VISIBLE);
        } else {
            mInterviewsRecyclerView.setVisibility(View.VISIBLE);
            mInterviewsProgressbar.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void showLoadingInterviewsErrorMessage(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingInterviewsCompletedMessage() {
        final Snackbar snackbar = Snackbar
                .make(mInterviewsRecyclerView, "Load Finished", Snackbar.LENGTH_LONG);

        snackbar.setActionTextColor(Color.MAGENTA)
                .setAction("Refresh", new View.OnClickListener(){
                    @Override
                    public void onClick(View view){
                        refresh();
                    }
                });

        snackbar.show();
    }

    @Override
    public void showInterviewQuestions(long interviewId) {

    }

    @Override
    public InterviewsContract.Presenter getPresenter() {
        return mInterviewsPresenter;
    }

    @Override
    public void setPresenter(InterviewsContract.Presenter presenter) {
        this.mInterviewsPresenter = presenter;
    }

    public void refresh(){
        mInterviewsPresenter.syncData();
    }
}
