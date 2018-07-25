package com.xiongxh.interviewpractice.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

import java.util.List;

@Dao
public interface InterviewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInterviews(List<Interview> interviews);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInterview(Interview interview);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertquestions(List<Question> questions);

    @Query("SELECT * FROM " + InterviewsDbContract.INTERVIEWS_TABLE_NAME)
    List<Interview> getInterviews();

    @Query("SELECT * FROM " + InterviewsDbContract.INTERVIEWS_TABLE_NAME + " WHERE id=:interviewId")
    Interview getInterview(int interviewId);

    @Query("SELECT * FROM " + InterviewsDbContract.QUESTIONS_TABLE_NAME + " WHERE interviewId=:interviewId")
    List<Question> getQuestions(int interviewId);

    @Query("DELETE FROM " + InterviewsDbContract.INTERVIEWS_TABLE_NAME)
    void deleteInterviews();
}
