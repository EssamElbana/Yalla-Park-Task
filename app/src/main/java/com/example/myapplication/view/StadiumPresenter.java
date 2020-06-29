package com.example.myapplication.view;

import com.example.myapplication.model.Stadium;
import com.example.myapplication.repository.CallbackInterface;
import com.example.myapplication.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class StadiumPresenter implements StadiumsListContract.Presenter {

    private StadiumsListContract.View mView;
    private Repository repository;
    private List<Stadium> stadiums;

    public StadiumPresenter(StadiumsListContract.View view) {
        mView = view;
        repository = new Repository();
        stadiums = new ArrayList<>();
    }

    @Override
    public void onViewCreated() {
        if (mView != null) {
            mView.showProgressDialog(true);
            getStadiumsForView(new CallbackInterface() {
                @Override
                public void onSuccess(List<Stadium> stadiumsList) {
                    if (mView != null) {
                        mView.showProgressDialog(false);
                        mView.showList(stadiumsList);
                    }
                }

                @Override
                public void onFailure() {
                    if (mView != null) {
                        mView.showProgressDialog(false);
                        mView.showErrorMessage();
                    }
                }
            });
        }
    }

    @Override
    public void onViewDestroyed() {
        repository = null;
        mView = null;
    }


    private void getStadiumsForView(CallbackInterface callbackInterface) {
        if (repository != null)
            repository.getStadiums(callbackInterface);
    }
}
