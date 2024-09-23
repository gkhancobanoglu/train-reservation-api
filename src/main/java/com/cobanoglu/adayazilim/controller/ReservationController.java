package com.cobanoglu.adayazilim.controller;

import com.cobanoglu.adayazilim.dto.ReservationRequest;
import com.cobanoglu.adayazilim.dto.ReservationResponse;
import com.cobanoglu.adayazilim.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody ReservationRequest request) {
        try {
            ReservationResponse response = reservationService.processReservation(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Hata durumunda uygun bir yanıt döndür
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ReservationResponse(false, null));
        }
    }
}
