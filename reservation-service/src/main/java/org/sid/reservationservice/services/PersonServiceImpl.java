package org.sid.reservationservice.services;

import lombok.AllArgsConstructor;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.repositories.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;

    @Override
    public List<Person> persons() {
        return personRepository.findAll();
    }
}
