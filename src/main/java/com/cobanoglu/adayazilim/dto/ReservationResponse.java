package com.cobanoglu.adayazilim.dto;

import java.util.ArrayList;
import java.util.List;


// Rezervasyon yanıtı için DTO
public class ReservationResponse {

    private boolean reservationPossible;
    private List<AllocationDetail> allocationDetails;

    public ReservationResponse(boolean canReserve, List<AllocationDetail> allocationDetails) {
        this.reservationPossible = canReserve;
        this.allocationDetails = allocationDetails;
    }

    public boolean isReservationPossible() {
        return reservationPossible;
    }

    public void setReservationPossible(boolean reservationPossible) {
        this.reservationPossible = reservationPossible;
    }

    public List<AllocationDetail> getAllocationDetails() {
        return allocationDetails;
    }

    public void setAllocationDetails(List<AllocationDetail> allocationDetails) {
        this.allocationDetails = allocationDetails;
    }
}
