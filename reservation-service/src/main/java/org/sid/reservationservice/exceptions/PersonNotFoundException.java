package org.sid.reservationservice.exceptions;

public class PersonNotFoundException extends Exception {
    public PersonNotFoundException(String personNotFoundMessage) {
        super(personNotFoundMessage);
    }
}
