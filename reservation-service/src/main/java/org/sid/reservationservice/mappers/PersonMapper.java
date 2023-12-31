package org.sid.reservationservice.mappers;

import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {
    public PersonDto fromPerson(Person person){
        PersonDto personDto=new PersonDto();
        BeanUtils.copyProperties(person,personDto);
        return personDto;
    }
    public Person fromPersonDto(PersonDto personDto){
        Person person=new Person();
        BeanUtils.copyProperties(personDto,person);
        return person;
    }
}
