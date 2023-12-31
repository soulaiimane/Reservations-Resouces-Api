package org.sid.reservationservice.services;

import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.exceptions.PersonNotFoundException;

import java.util.List;

public interface PersonService {
    public List<PersonDto> persons();
    public PersonDto newPerson(PersonDto personDto);
    public boolean DeletePerson(Long personId) throws PersonNotFoundException;
    public PersonDto updatePerson(PersonDto personDto) throws PersonNotFoundException;
    public Person findPersonById(Long personId) throws PersonNotFoundException;

}
