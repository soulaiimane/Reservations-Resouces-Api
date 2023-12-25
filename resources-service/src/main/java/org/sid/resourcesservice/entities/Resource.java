package org.sid.resourcesservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.sid.resourcesservice.enums.ResourceType;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Resource {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name;
    private ResourceType resourceType;

}
