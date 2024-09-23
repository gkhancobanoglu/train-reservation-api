package com.cobanoglu.adayazilim.dto;

public class TrainResponse {
    private TrainDetail train;

    public TrainResponse(TrainDetail train) {
        this.train = train;
    }

    public TrainDetail getTrain() {
        return train;
    }

    public void setTrain(TrainDetail train) {
        this.train = train;
    }
}