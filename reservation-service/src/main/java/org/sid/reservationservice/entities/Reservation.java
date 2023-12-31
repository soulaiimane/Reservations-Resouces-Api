package org.sid.reservationservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String context ;
    private Date date;
    private int durationPerDay;
    private Long resourceId;
    private String resourceName;
    @ManyToOne
    private Person person;


}
