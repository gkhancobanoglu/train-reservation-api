package com.cobanoglu.adayazilim.repository;

import com.cobanoglu.adayazilim.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findByName(String name);
}
