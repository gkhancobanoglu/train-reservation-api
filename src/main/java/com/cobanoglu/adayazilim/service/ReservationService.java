package com.cobanoglu.adayazilim.service;

import com.cobanoglu.adayazilim.dto.AllocationDetail;
import com.cobanoglu.adayazilim.dto.ReservationRequest;
import com.cobanoglu.adayazilim.dto.ReservationResponse;
import com.cobanoglu.adayazilim.dto.AllocationDetail;
import com.cobanoglu.adayazilim.model.Coach;
import com.cobanoglu.adayazilim.model.Train;
import com.cobanoglu.adayazilim.repository.TrainRepository;
import com.cobanoglu.adayazilim.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private CoachRepository coachRepository;

    public ReservationResponse processReservation(ReservationRequest request) {
        if (request.getNumberOfPeople() <= 0) {
            return new ReservationResponse(false, new ArrayList<>());
        }

        Train train = trainRepository.findByName(request.getTrainName());
        if (train == null) {
            return new ReservationResponse(false, new ArrayList<>());
        }

        List<AllocationDetail> allocationDetails = new ArrayList<>();
        int remainingPassengers = request.getNumberOfPeople();

        for (Coach coach : train.getCoaches()) {
            int availableSeats = coach.getCapacity() - coach.getOccupiedSeats();

            // Vagon doluluk oranını kontrol et
            if (availableSeats > 0 && (double) coach.getOccupiedSeats() / coach.getCapacity() < 0.7) {
                int seatsToAllocate = Math.min(availableSeats, remainingPassengers);
                allocationDetails.add(new AllocationDetail(coach.getName(), seatsToAllocate));
                coach.setOccupiedSeats(coach.getOccupiedSeats() + seatsToAllocate);
                coachRepository.save(coach); // Vagonu güncelle

                System.out.println("Vagon: " + coach.getName() + ", Güncellenen Dolu Koltuk Sayısı: " + coach.getOccupiedSeats());

                remainingPassengers -= seatsToAllocate;

                if (remainingPassengers <= 0) {
                    break;
                }
            }
        }

        boolean canReserve = remainingPassengers == 0;
        return new ReservationResponse(canReserve, allocationDetails);
    }
}
