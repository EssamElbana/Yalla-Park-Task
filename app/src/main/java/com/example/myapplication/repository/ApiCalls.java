package com.example.myapplication.repository;

import com.example.myapplication.model.Stadium;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCalls {
    @GET("api/football/stadiums")
    Call<StadiumListResponse> getStadiums();
}
