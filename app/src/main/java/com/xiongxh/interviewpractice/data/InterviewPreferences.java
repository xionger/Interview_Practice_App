package com.xiongxh.interviewpractice.data;

import android.content.Context;
import android.content.SharedPreferences;

import timber.log.Timber;

public class InterviewPreferences {
    public static final String PREF_APP = "app_prefs";

    private static final String PREF_SYNCED = "app_synced";

    private SharedPreferences appPreferences;

    public InterviewPreferences (Context context){
        appPreferences = context.getSharedPreferences(PREF_APP, Context.MODE_PRIVATE);
    }

    public void setInterviewsSynced(boolean syncState){
        Timber.d("Set interviews sync state as: " + syncState);
        appPreferences.edit().putBoolean(PREF_SYNCED, syncState).apply();
    }

    public boolean isInterviewsSynced(){
        Timber.d("Check whether interviews are synced ...");
        boolean isSynced = appPreferences.getBoolean(PREF_SYNCED, false);
        Timber.d("Sync status is : " + isSynced);
        return isSynced;
    }
}
