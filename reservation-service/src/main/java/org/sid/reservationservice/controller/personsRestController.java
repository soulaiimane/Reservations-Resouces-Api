package org.sid.reservationservice.controller;

import lombok.AllArgsConstructor;
import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.exceptions.PersonNotFoundException;
import org.sid.reservationservice.services.PersonService;
import org.sid.reservationservice.services.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
//@CrossOrigin(origins = "*")
public class personsRestController {
    private PersonServiceImpl personService;
    @GetMapping("/persons")
    //@PreAuthorize("hasAuthority('USER')")
    public List<PersonDto> reservationList(){
        return personService.persons();
    }
    @PostMapping("/persons/newPerson")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public PersonDto newPerson(@RequestBody PersonDto personDto){
        return personService.newPerson(personDto);
    }
    @PutMapping("/persons/updatePerson")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public PersonDto updatePerson(@RequestBody PersonDto personDto) throws PersonNotFoundException {
        return personService.updatePerson(personDto);
    }
    @DeleteMapping("/persons/{personId}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public boolean DeletePerson(@PathVariable Long personId) throws PersonNotFoundException {
        return personService.DeletePerson(personId);
    }
}
