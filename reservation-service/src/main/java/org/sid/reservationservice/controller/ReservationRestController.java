package org.sid.reservationservice.controller;

import lombok.AllArgsConstructor;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;
import org.sid.reservationservice.services.ReservationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ReservationRestController {
    private ReservationService reservationService;
    @GetMapping("/reservations")
    public List<ReservationDto> reservationList(){
        return reservationService.reservations();
    }
    @GetMapping("/reservations/{reservationsId}")

    public ReservationDto reservationById(@PathVariable Long reservationsId) throws ReservationNotFoundException {
        return reservationService.reservationById(reservationsId);
    }
}
