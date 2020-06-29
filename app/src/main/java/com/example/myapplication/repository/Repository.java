package com.example.myapplication.repository;

import com.example.myapplication.model.Stadium;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Repository {

    private Retrofit retrofit;
    private ApiCalls apiCalls;

    public Repository() {
        retrofit = NetworkClient.getRetrofitClient();
        apiCalls = retrofit.create(ApiCalls.class);
    }

    public void getStadiums(final CallbackInterface callbackInterface) {
        Call<List<Stadium>> call = apiCalls.getStadiums();
        call.enqueue(new Callback<List<Stadium>>() {
            @Override
            public void onResponse(Call<List<Stadium>> call, Response<List<Stadium>> response) {
                if (response.isSuccessful())
                    callbackInterface.onSuccess(response.body());
                else
                    callbackInterface.onFailure();
            }

            @Override
            public void onFailure(Call<List<Stadium>> call, Throwable t) {
                callbackInterface.onFailure();
            }
        });
    }

}
