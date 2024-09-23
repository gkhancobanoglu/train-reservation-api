package com.cobanoglu.adayazilim.dto;

public class CoachDetail {
    private String name;
    private int capacity;
    private int occupiedSeats;

    public CoachDetail(String name, int capacity, int occupiedSeats) {
        this.name = name;
        this.capacity = capacity;
        this.occupiedSeats = occupiedSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getOccupiedSeats() {
        return occupiedSeats;
    }

    public void setOccupiedSeats(int occupiedSeats) {
        this.occupiedSeats = occupiedSeats;
    }
}