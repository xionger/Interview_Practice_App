package com.xiongxh.interviewpractice.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.xiongxh.interviewpractice.data.bean.Interview;
import com.xiongxh.interviewpractice.data.bean.Question;

@Database(entities = {Interview.class, Question.class}, version = 1)
public abstract class InterviewsDatabase extends RoomDatabase {
    public abstract InterviewsDao interviewsDao();
}
