package com.cobanoglu.adayazilim.service;

import com.cobanoglu.adayazilim.dto.CoachDetail;
import com.cobanoglu.adayazilim.dto.TrainDetail;
import com.cobanoglu.adayazilim.dto.TrainResponse;
import com.cobanoglu.adayazilim.model.Coach;
import com.cobanoglu.adayazilim.model.Train;
import com.cobanoglu.adayazilim.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    public TrainResponse getTrainDetails(String trainName) {
        Train train = trainRepository.findByName(trainName);
        if (train == null) {
            return null;
        }

        List<CoachDetail> coachDetails = new ArrayList<>();
        for (Coach coach : train.getCoaches()) {
            coachDetails.add(new CoachDetail(coach.getName(), coach.getCapacity(), coach.getOccupiedSeats()));
        }

        TrainDetail trainDetail = new TrainDetail(train.getName(), coachDetails);
        return new TrainResponse(trainDetail);
    }
}

