package org.sid.resourcesservice;

import org.sid.resourcesservice.dtos.ResourceDto;
import org.sid.resourcesservice.enums.ResourceType;
import org.sid.resourcesservice.service.ResourceService;
import org.sid.resourcesservice.service.ResourceServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class ResourcesServiceApplication {
	Random random=new Random();

	public static void main(String[] args) {
		SpringApplication.run(ResourcesServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(ResourceServiceImpl resourceService){
		return args -> {
			Stream.of("Pc","Phone","Microphone","Mouse","KeyBord","AirPods","Charger","Router","Remote").forEach(r->{
				ResourceDto resourceDto=new ResourceDto();
				resourceDto.setName(r);
				resourceDto.setResourceType(Math.random()>0.2? ResourceType.MATERIEL_INF0:ResourceType.MATERIEL_AUDIO_VUSUEL);
				resourceDto.setId(random.nextLong());
				resourceService.addResource(resourceDto);
			});
		};
	}

}
