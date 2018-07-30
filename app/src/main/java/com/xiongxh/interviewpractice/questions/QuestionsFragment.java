package com.xiongxh.interviewpractice.questions;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xiongxh.interviewpractice.R;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import timber.log.Timber;

public class QuestionsFragment extends Fragment implements QuestionsContract.View{
    private static final String CURRENT_QUESTION_KEY = "CURRENT_QUESTION_KEY";
    private static final String RECYCLER_KEY = "RECYCLER_KEY";

    private int mInterviewId;
    private int mQuestionId;
    private QuestionsContract.Presenter mInterviewQuestionsPresenter;
    private QuestionsAdapter mInterviewQuestionsAdapter;

    private LinearLayoutManager mLayoutManager;
    private Unbinder unbinder;
    private Parcelable mStateBundle;

    @BindView(R.id.rv_questions_interview)
    RecyclerView mQuestionsRecyclerView;

    public QuestionsFragment() {
        // Required empty public constructor
    }

    public static QuestionsFragment newInstance(int interviewId){
        Bundle args = new Bundle();
        QuestionsFragment questionsFragment = new QuestionsFragment();
        args.putInt(QuestionsActivity.INTERVIEW_ID_KEY, interviewId);
        questionsFragment.setArguments(args);

        return questionsFragment;
    }

    @Override
    public void onCreate(@NonNull Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mInterviewId = getArguments().getInt(QuestionsActivity.INTERVIEW_ID_KEY);
        if (savedInstanceState != null) {
            mQuestionId = savedInstanceState.getInt(CURRENT_QUESTION_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_questions, container, false);

        unbinder = ButterKnife.bind(this, rootView);

        mInterviewQuestionsAdapter = new QuestionsAdapter(new ArrayList<>(0),
                questionId -> mInterviewQuestionsPresenter.openQuestionDetails(questionId));

        mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mQuestionsRecyclerView.setLayoutManager(mLayoutManager);

        if (savedInstanceState != null){
            mStateBundle = savedInstanceState.getParcelable(RECYCLER_KEY);
        }
        mQuestionsRecyclerView.setAdapter(mInterviewQuestionsAdapter);

        return rootView;
    }

    @Override
    public void onActivityCreated(@NonNull Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mInterviewQuestionsPresenter.subscribe(this);

//        if (UiUtils.isTablet()) {
//            mInterviewQuestionsPresenter.fetchQuestionData(mQuestionId);
//        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_QUESTION_KEY, mQuestionId);
        outState.putParcelable(RECYCLER_KEY, mLayoutManager.onSaveInstanceState());
    }

    @Override
    public void onResume(){
        super.onResume();
        if (mStateBundle != null) {
            mLayoutManager.onRestoreInstanceState(mStateBundle);
        }
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showInterviewDetails(Interview interview) {
        Timber.d("Interview category: " + interview.getCategory());
    }

    @Override
    public void showQuestions(List<Question> questionList) {
        mInterviewQuestionsAdapter.refreshQuestions(questionList);
    }

    @Override
    public void showQuestionDetails(int questionId) {
        mQuestionId = questionId;

        /*
        if (UiUtils.isTablet()){
            mInterviewQuestionsPresenter.fetchQuestionData(questionId);
        } else {
            Timber.d("Open question page, mInterviewId: " + mInterviewId + ", questionId: " + questionId);
            startActivity(QuestionDetailActivity.prepareIntent(getContext(), mInterviewId, questionId));
        }*/
    }

    @Override
    public void showInterviewCategory(String interviewCategory) {
        getActivity().setTitle(interviewCategory);
    }

    @Override
    public void showErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshQuestionContainer(String desc, String shortDesc, int questionId) {

    }

    @Override
    public void setPresenter(QuestionsContract.Presenter presenter) {
        this.mInterviewQuestionsPresenter = presenter;
    }
}
