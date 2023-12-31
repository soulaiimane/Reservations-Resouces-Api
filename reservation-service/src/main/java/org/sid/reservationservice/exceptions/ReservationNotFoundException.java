package org.sid.reservationservice.exceptions;

public class ReservationNotFoundException extends Exception {
    public ReservationNotFoundException(String ReservationNotFoundMessage) {
        super(ReservationNotFoundMessage);
    }
}
