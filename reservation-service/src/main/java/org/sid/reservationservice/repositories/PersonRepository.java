package org.sid.reservationservice.repositories;

import org.sid.reservationservice.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
