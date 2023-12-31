package org.sid.reservationservice.mappers;


import lombok.AllArgsConstructor;
import org.sid.reservationservice.OpenFeign.ResourceRestClientService;
import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.dtos.ResourceDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReservationMapper {
    private PersonMapper personMapper;
    private ResourceRestClientService resourceRestClientService;
    public ReservationDto fromReservation(Reservation reservation){
        ReservationDto reservationDto=new ReservationDto();
        BeanUtils.copyProperties(reservation,reservationDto);
        PersonDto personDto = personMapper.fromPerson(reservation.getPerson());
        reservationDto.setPersonDto(personDto);
        return reservationDto;
    }
    public Reservation fromReservationDto(ReservationDto reservationDto){
        Reservation reservation=new Reservation();
        BeanUtils.copyProperties(reservationDto,reservation);
        return reservation;
    }
}
