package com.xiongxh.interviewpractice;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.xiongxh.interviewpractice.api.InterviewApiService;
import com.xiongxh.interviewpractice.data.local.InterviewsDatabase;
import com.xiongxh.interviewpractice.data.local.InterviewsDbContract;

import okhttp3.OkHttpClient;
import timber.log.Timber;

public class InterviewApp extends Application {
    private static InterviewApp INSTANCE;
    public OkHttpClient client = new OkHttpClient();

    public InterviewsDatabase database;
    //public InterviewPreferences interviewPreferences;
    //public PresenterProvider presenterProvider;

    public static InterviewApp get(){ return INSTANCE; }

    @Override
    public void onCreate(){
        super.onCreate();

        INSTANCE = this;

        Timber.plant(new Timber.DebugTree());
        Stetho.initializeWithDefaults(this);
        client = new OkHttpClient.Builder().addInterceptor(new StethoInterceptor()).build();
        InterviewApiService.initRetrofit(client);

        database = Room.databaseBuilder(this,
                InterviewsDatabase.class,
                InterviewsDbContract.DATABASE_NAME)
                .build();

        //interviewPreferences = new InterviewPreferences(this);
        //presenterProvider = new PresenterProvider();
    }
}
