package org.sid.reservationservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.reservationservice.OpenFeign.ResourceRestClientService;
import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.dtos.ResourceDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.exceptions.PersonNotFoundException;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;
import org.sid.reservationservice.mappers.PersonMapper;
import org.sid.reservationservice.mappers.ReservationMapper;
import org.sid.reservationservice.repositories.PersonRepository;
import org.sid.reservationservice.repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private ReservationMapper reservationMapper;
    private PersonMapper personMapper;
    private PersonServiceImpl personService;
    private ResourceRestClientService resourceRestClientService;


    @Override
    public List<ReservationDto> reservations() {
        List<ReservationDto> reservationDtos = reservationRepository.findAll().stream().map(r -> reservationMapper.fromReservation(r)).toList();
        return reservationDtos;
    }

    @Override
    public ReservationDto reservationById(Long reservationId) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation==null){
            log.info("Reservation Not Found With Id= " + reservationId);
            throw new ReservationNotFoundException("Reservation Not Found");
        }
        return reservationMapper.fromReservation(reservation);
    }

    @Override
    public List<ReservationDto> reservationsByPerson(PersonDto personDto) throws PersonNotFoundException {
        Person person = personService.findPersonById(personDto.getId());

        List<ReservationDto> reservationsDtos = reservationRepository.findReservationByPerson(person).stream().map(r -> reservationMapper.fromReservation(r))
                .toList();
        return reservationsDtos;
    }

    @Override
    public List<ReservationDto> reservationsByResource(Long resourceId){
        List<ReservationDto> reservationDtos = reservationRepository.findReservationByResourceId(resourceId).stream().map(r -> reservationMapper.fromReservation(r))
                .toList();
        return reservationDtos;
    }

    @Override
    public ReservationDto newReservation(ReservationDto reservationDto,Long personId) throws PersonNotFoundException {
        Reservation reservation = reservationMapper.fromReservationDto(reservationDto);
        reservation.setDate(new Date());
        reservation.setPerson(personService.findPersonById(personId));
        Reservation savedReservation= reservationRepository.save(reservation);
        return reservationMapper.fromReservation(savedReservation);
    }

    @Override
    public boolean DeleteReservation(Long reservationId) throws ReservationNotFoundException {
        Reservation reservation = findReservationById(reservationId);
        reservationRepository.deleteById(reservationId);
        return true;
    }

    @Override
    public ReservationDto updateReservation(ReservationDto reservationDto) throws ReservationNotFoundException {
        return null;
    }

    @Override
    public Reservation findReservationById(Long reservationId) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation==null){
            throw new ReservationNotFoundException("Reservation Not Found");
        }
        return reservation;
    }
}
