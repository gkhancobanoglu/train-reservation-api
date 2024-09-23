package com.cobanoglu.adayazilim.dto;

import java.util.List;

public class TrainDetail {
    private String name;
    private List<CoachDetail> coaches;

    public TrainDetail(String name, List<CoachDetail> coaches) {
        this.name = name;
        this.coaches = coaches;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CoachDetail> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<CoachDetail> coaches) {
        this.coaches = coaches;
    }
}
