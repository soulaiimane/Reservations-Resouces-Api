package org.sid.reservationservice;

import org.sid.reservationservice.OpenFeign.ResourceRestClientService;
import org.sid.reservationservice.dtos.PersonDto;
import org.sid.reservationservice.dtos.ReservationDto;
import org.sid.reservationservice.dtos.ResourceDto;
import org.sid.reservationservice.entities.Person;
import org.sid.reservationservice.entities.Reservation;
import org.sid.reservationservice.repositories.PersonRepository;
import org.sid.reservationservice.repositories.ReservationRepository;
import org.sid.reservationservice.services.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(PersonRepository personRepository , ReservationRepository reservationRepository,
							ReservationService reservationService, ResourceRestClientService resourceRestClientService){
		return args -> {
			List<ResourceDto> resourceList = resourceRestClientService.resourceList();
			Random random=new Random();
			Stream.of("Ahmed","Khalid","Said","Saad","Hassan").forEach(p->{
				Person person=new Person();
				person.setName(p);
				person.setEmail(p+"@Gmail.com");
				person.setFunction(Math.random()>0.3?"Prof":"Student");
				Person savedP = personRepository.save(person);
				for (ResourceDto resourceDto:resourceList) {
					Reservation reservation=new Reservation();
					reservation.setName("reservation of "+resourceDto.getName());
					reservation.setDate(new Date());
					reservation.setDurationPerDay(random.nextInt(1,10));
					reservation.setResourceId(resourceDto.getId());
					reservation.setResourceName(resourceDto.getName());
					reservation.setContext(Math.random()>0.5?"Réunion d'équipe":"Présentation client");
					reservation.setPerson(savedP);
					reservationRepository.save(reservation);
				}

			});

		};
	}

}
