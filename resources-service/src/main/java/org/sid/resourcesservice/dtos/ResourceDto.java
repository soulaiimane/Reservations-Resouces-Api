package org.sid.resourcesservice.dtos;

import lombok.*;
import org.sid.resourcesservice.enums.ResourceType;

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
