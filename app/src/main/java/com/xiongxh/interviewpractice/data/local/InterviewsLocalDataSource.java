package com.xiongxh.interviewpractice.data.local;

import android.arch.persistence.room.Dao;

import com.xiongxh.interviewpractice.data.InterviewsDataSource;
import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

public class InterviewsLocalDataSource implements InterviewsDataSource {
    InterviewsDao mInterviewsDao;

    public InterviewsLocalDataSource(){
        mInterviewsDao = InterviewApp.get().database.recipesDao();
    }

    public InterviewsLocalDataSource(InterviewsDao dao){
        this.mInterviewsDao = dao;
    }

    private Observable<Interview> getQuestions(final Interview interview){
        return Observable.just(interview).map(interview1 -> {
            interview1.setQuestions(mInterviewsDao.getQuestions(interview1.getId()));
            return interview1;
        });
    }

    @Override
    public Single<List<Interview>> getInterviews() {
        return Observable.fromCallable(() -> mInterviewsDao.getInterviews())
                .flatMap(Observable::fromIterable)
                .flatMap(this::getQuestions)
                .toList();
    }

    @Override
    public Single<Interview> getInterview(int interviewId) {
        return Observable.fromCallable(()-> mInterviewsDao.getInterview(interviewId))
                .flatMap(this::getQuestions)
                .firstOrError();
    }

    @Override
    public Single<List<Question>> getQuestionsOfInterview(int interviewId) {
        return Single.fromCallable(() -> mInterviewsDao.getQuestions(interviewId));
    }

    @Override
    public void setInterviews(List<Interview> interviews) {
        mInterviewsDao.deleteInterviews();
        mInterviewsDao.insertInterviews(interviews);

        for (Interview interview : interviews){
            for (int i = 0; i < interview.getQuestions().size(); i++){
                interview.getQuestions().get(i).setInterviewId(interview.getId());
            }

            mInterviewsDao.insertQuestions(interview.getQuestions());
        }
    }
    }
}
