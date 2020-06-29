package com.example.myapplication.view;

import com.example.myapplication.model.Stadium;

import java.util.List;

public interface StadiumsListContract {

    interface View {
        void showList(List<Stadium> carList);

        void showProgressDialog(boolean visibilityState);

        void showErrorMessage();
    }

    interface Presenter {
        void onViewCreated();

        void onViewDestroyed();
    }
}
