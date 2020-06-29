package com.example.myapplication.repository;

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
        Call<StadiumListResponse> call = apiCalls.getStadiums();
        call.enqueue(new Callback<StadiumListResponse>() {
            @Override
            public void onResponse(Call<StadiumListResponse> call, Response<StadiumListResponse> response) {
                if (response.isSuccessful())
                    callbackInterface.onSuccess(response.body().getStadiums());
                else
                    callbackInterface.onFailure();
            }

            @Override
            public void onFailure(Call<StadiumListResponse> call, Throwable t) {
                callbackInterface.onFailure();
            }
        });
    }

}
