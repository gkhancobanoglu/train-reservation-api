package com.cobanoglu.adayazilim.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "trains")
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trains_id")
    private Long trainsId;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Coach> coaches;

    // Varsayılan yapıcı
    public Train() {}

    public Train(Long trainsId, String name, List<Coach> coaches) {
        this.trainsId = trainsId;
        this.name = name;
        this.coaches = coaches;
    }

    // Getter ve Setter'lar
    public Long getTrainsId() {
        return trainsId;
    }

    public void setTrainsId(Long trainsId) {
        this.trainsId = trainsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
