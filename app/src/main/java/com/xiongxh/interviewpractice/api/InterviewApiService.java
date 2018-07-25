package com.xiongxh.interviewpractice.api;

import com.xiongxh.interviewpractice.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class InterviewApiService {
    private static Retrofit retrofit;

    public static void initRetrofit(OkHttpClient client){
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASEURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static ApiService initService(){
        ApiService apiService = retrofit.create(ApiService.class);

        return apiService;
    }
}
