package org.sid.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String function;
    @OneToMany(mappedBy = "person")
    private List<Reservation> reservations;
}
