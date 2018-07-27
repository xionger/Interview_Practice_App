package com.xiongxh.interviewpractice.Interviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;

import com.xiongxh.interviewpractice.InterviewApp;
import com.xiongxh.interviewpractice.R;

import butterknife.ButterKnife;

public class InterviewsActivity extends AppCompatActivity {
    private static final String TAG_FRAGMENT_INTERVIEWS = "TAG_FRAGMENT_INTERVIEWS";

    private InterviewsContract.View mInterviewsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interviews);

        ButterKnife.bind(this);

        if (savedInstanceState == null){
            mInterviewsFragment = InterviewsFragment.newInstance();

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.interviews_fragment_container, (Fragment) mInterviewsFragment, TAG_FRAGMENT_INTERVIEWS)
                    .commit();
        }

        if (mInterviewsFragment == null){
            mInterviewsFragment = (InterviewsContract.View) getSupportFragmentManager()
                            .findFragmentByTag(TAG_FRAGMENT_INTERVIEWS);
        }

        InterviewsContract.Presenter presenter = InterviewApp.get().presenterProvider.provideInterviews();
        mInterviewsFragment.setPresenter(presenter);
    }
}
