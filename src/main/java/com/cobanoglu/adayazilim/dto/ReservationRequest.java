package com.cobanoglu.adayazilim.dto;

import java.util.List;

// Rezervasyon isteği için DTO
public class ReservationRequest {

    private String trainName;
    private List<CoachRequest> coaches;
    private int numberOfPeople;
    private boolean canAllocateToDifferentCoaches;

    public ReservationRequest() {
    }

    public ReservationRequest(String trainName, List<CoachRequest> coaches, int numberOfPeople, boolean canAllocateToDifferentCoaches) {
        this.trainName = trainName;
        this.coaches = coaches;
        this.numberOfPeople = numberOfPeople;
        this.canAllocateToDifferentCoaches = canAllocateToDifferentCoaches;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public List<CoachRequest> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<CoachRequest> coaches) {
        this.coaches = coaches;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public boolean isCanAllocateToDifferentCoaches() {
        return canAllocateToDifferentCoaches;
    }

    public void setCanAllocateToDifferentCoaches(boolean canAllocateToDifferentCoaches) {
        this.canAllocateToDifferentCoaches = canAllocateToDifferentCoaches;
    }
}
