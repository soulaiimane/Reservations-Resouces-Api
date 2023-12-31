package org.sid.reservationservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.exceptions.PersonNotFoundException;
import org.sid.reservationservice.exceptions.ReservationNotFoundException;
import org.sid.reservationservice.mappers.PersonMapper;
import org.sid.reservationservice.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;
    private PersonMapper mapper;

    @Override
    public List<PersonDto> persons() {
        List<PersonDto> personDtoList = personRepository.findAll().stream().map(p -> mapper.fromPerson(p)
        ).toList();
        return personDtoList;
    }

    @Override
    public PersonDto newPerson(PersonDto personDto) {
        Person person= Person.builder()
                .name(personDto.getName())
                .email(personDto.getEmail())
                .function(personDto.getFunction())
                .build();
        Person savedPerson = personRepository.save(person);
        return mapper.fromPerson(savedPerson);
    }

    @Override
    public boolean DeletePerson(Long personId) throws PersonNotFoundException {
        Person person = findPersonById(personId);
        personRepository.delete(person);
        return true;
    }

    @Override
    public PersonDto updatePerson(PersonDto personDto) throws PersonNotFoundException {
        Person person = findPersonById(personDto.getId());
        if (person.getName()!=personDto.getName()) person.setName(personDto.getName());
        if (person.getEmail()!=personDto.getEmail()) person.setEmail(personDto.getEmail());
        if (person.getFunction()!=personDto.getFunction()) person.setFunction(personDto.getFunction());
        personRepository.save(person);
        return mapper.fromPerson(person);
    }

    @Override
    public Person findPersonById(Long personId) throws PersonNotFoundException {
        Person person = personRepository.findById(personId).orElse(null);
        if (person==null){
            log.info("Person Not Found With Id= " + personId);
            throw new PersonNotFoundException("Person Not Found");
        }
        return person;
    }
}
