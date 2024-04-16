package org.sii.performance.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor @NoArgsConstructor @Setter @Getter @Builder

public class BilanPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
}
