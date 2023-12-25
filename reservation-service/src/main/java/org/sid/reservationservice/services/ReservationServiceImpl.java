package org.sid.reservationservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;
import org.sid.reservationservice.mappers.PersonMapper;
import org.sid.reservationservice.mappers.ReservationMapper;
import org.sid.reservationservice.repositories.PersonRepository;
import org.sid.reservationservice.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;
    private PersonMapper personMapper;


    @Override
    public List<ReservationDto> reservations() {
        List<ReservationDto> reservationDtos = reservationRepository.findAll().stream().map(r -> reservationMapper.fromReservation(r)).toList();
        return reservationDtos;
    }

    @Override
    public ReservationDto reservationById(Long reservationId) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation==null){
            log.info("Reservation Not Found With Id= " + reservation);
            throw new ReservationNotFoundException("Reservation Not Found");
        }
        return reservationMapper.fromReservation(reservation);
    }
}
