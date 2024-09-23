package com.cobanoglu.adayazilim.model;

import jakarta.persistence.*;

@Entity
@Table(name = "coaches")
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coach_id")
    private Long coachId;

    @ManyToOne
    @JoinColumn(name = "train_id", nullable = false)
    private Train train; // İsim değişikliği

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "occupied_seats", nullable = false)
    private int occupiedSeats;

    // Varsayılan yapıcı
    public Coach() {}

    // Getter ve Setter'lar
    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    public Train getTrain() {
        return train; // İsim değişikliği
    }

    public void setTrain(Train train) {
        this.train = train; // İsim değişikliği
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
