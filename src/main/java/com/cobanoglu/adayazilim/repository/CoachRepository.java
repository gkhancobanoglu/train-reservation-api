package com.cobanoglu.adayazilim.repository;

import com.cobanoglu.adayazilim.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Long> {
}
