package org.sid.reservationservice.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.sid.reservationservice.entities.Reservation;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonDto {
    private Long id;
    private String name;
    private String email;
    private String function;

}
