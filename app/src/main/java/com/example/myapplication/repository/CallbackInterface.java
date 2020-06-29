package com.example.myapplication.repository;

import com.example.myapplication.model.Stadium;

import java.util.List;

public interface CallbackInterface {
    void onSuccess(List<Stadium> carList);

    void onFailure();
}
