package com.example.myapplication.repository;

import com.example.myapplication.model.Stadium;

import java.util.List;

class StadiumListResponse {
    private List<Stadium> stadiums;

    public List<Stadium> getStadiums() {
        return stadiums;
    }

    public void setStadiums(List<Stadium> stadiums) {
        this.stadiums = stadiums;
    }
}
