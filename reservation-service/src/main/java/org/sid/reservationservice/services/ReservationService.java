package org.sid.reservationservice.services;

import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.exceptions.PersonNotFoundException;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;

import java.util.List;

public interface ReservationService {
    public List<ReservationDto> reservations();
    public ReservationDto reservationById(Long reservationId) throws ReservationNotFoundException;
    public List<ReservationDto> reservationsByPerson(PersonDto personDto) throws PersonNotFoundException;
    public List<ReservationDto> reservationsByResource(Long resourceId) ;
    public ReservationDto newReservation(ReservationDto reservationDto,Long personId) throws PersonNotFoundException ;
    public boolean DeleteReservation(Long reservationId) throws ReservationNotFoundException;
    public ReservationDto updateReservation(ReservationDto reservationDto) throws ReservationNotFoundException;
    public Reservation findReservationById(Long reservationId) throws ReservationNotFoundException;



}
