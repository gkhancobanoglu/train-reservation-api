package com.cobanoglu.adayazilim.controller;


import com.cobanoglu.adayazilim.dto.TrainResponse;
import com.cobanoglu.adayazilim.model.Train;
import com.cobanoglu.adayazilim.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trains")
public class TrainController {

    @Autowired
    private TrainService trainService;

    @GetMapping("/{trainName}")
    public ResponseEntity<TrainResponse> getTrain(@PathVariable String trainName) {
        TrainResponse response = trainService.getTrainDetails(trainName);
        if (response == null) {
            return ResponseEntity.notFound().build(); // veya uygun bir hata durumu
        }
        return ResponseEntity.ok(response);
    }
}


