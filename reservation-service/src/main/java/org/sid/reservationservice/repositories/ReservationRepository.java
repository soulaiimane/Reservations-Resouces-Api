package org.sid.reservationservice.repositories;

import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}
