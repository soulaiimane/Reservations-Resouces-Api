package org.sid.reservationservice.repositories;

import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
    public List<Reservation> findReservationByPerson(Person person);
    public List<Reservation> findReservationByResourceId(Long resourceId);

}
