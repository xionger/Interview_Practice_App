package com.xiongxh.interviewpractice.api;

import retrofit2.http.GET;

public interface ApiService {
    @GET("interviews.json")
    Single<List<Interview>> fetchInterviewsFromServer();
}
