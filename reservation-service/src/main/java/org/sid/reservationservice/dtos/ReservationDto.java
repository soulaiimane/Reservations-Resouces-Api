package org.sid.reservationservice.dtos;

import jakarta.persistence.*;
import lombok.*;
import org.sid.reservationservice.entities.Person;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReservationDto {
    private Long id;
    private String name;
    private String context ;
    private Date date;
    private int durationPerDay;
    private Long resourceId;
    private String resourceName;
    private PersonDto personDto;


}
