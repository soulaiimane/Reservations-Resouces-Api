package org.sid.reservationservice.controller;

import lombok.AllArgsConstructor;
import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.exceptions.PersonNotFoundException;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;
import org.sid.reservationservice.services.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "*")
public class ReservationRestController {
    private ReservationService reservationService;
    @GetMapping("/reservations")
    public List<ReservationDto> reservationList(){
        return reservationService.reservations();
    }
    @GetMapping("/reservations/{reservationsId}")
    //@PreAuthorize("hasAuthority('USER')")
    public ReservationDto reservationById(@PathVariable Long reservationsId) throws ReservationNotFoundException {
        return reservationService.reservationById(reservationsId);
    }
    @GetMapping("/reservations/Person/{id}")
    //@PreAuthorize("hasAuthority('USER')")
    public List<ReservationDto> reservationsByPerson(PersonDto personDto) throws PersonNotFoundException {
        return reservationService.reservationsByPerson(personDto);
    }
    @GetMapping("/reservations/resources/{resourceId}")
    //@PreAuthorize("hasAuthority('USER')")
    public List<ReservationDto> reservationsByResourceId(@PathVariable Long resourceId)  {
        return reservationService.reservationsByResource(resourceId);
    }
    @DeleteMapping("/reservations/{reservationId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public boolean DeleteReservation(@PathVariable Long reservationId) throws ReservationNotFoundException {
        return reservationService.DeleteReservation(reservationId);
    }
    @PostMapping("/reservations/newReservations/{personId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ReservationDto newReservation(@RequestBody ReservationDto reservationDto,@PathVariable Long personId) throws PersonNotFoundException {
        return reservationService.newReservation(reservationDto,personId);
    }
}
