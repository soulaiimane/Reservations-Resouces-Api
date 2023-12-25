package org.sid.reservationservice.dtos;

import lombok.*;
import org.sid.reservationservice.enums.ResourceType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ResourceDto {
    private Long id ;
    private String name;
    private ResourceType resourceType;

}
