package com.xiongxh.interviewpractice.api;

import com.xiongxh.interviewpractice.data.bean.Interview;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface ApiService {
    @GET("interviews.json")
    Single<List<Interview>> fetchInterviewsFromServer();
}
