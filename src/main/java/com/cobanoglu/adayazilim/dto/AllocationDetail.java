package com.cobanoglu.adayazilim.dto;


// Yerleşim detayları için DTO
public class AllocationDetail {
    private String coachName;
    private int numberOfPeople;

    public AllocationDetail(String name, int seatsToAllocate) {
        this.coachName=name;
        this.numberOfPeople=seatsToAllocate;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
}
