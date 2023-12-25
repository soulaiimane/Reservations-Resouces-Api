package org.sid.reservationservice.services;

import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;

import java.util.List;

public interface ReservationService {
    public List<ReservationDto> reservations();
    public ReservationDto reservationById(Long reservationId) throws ReservationNotFoundException;


}
