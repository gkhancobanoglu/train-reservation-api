package com.cobanoglu.adayazilim.service;


import com.cobanoglu.adayazilim.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoachService {

    @Autowired
    private CoachRepository coachRepository;
}
