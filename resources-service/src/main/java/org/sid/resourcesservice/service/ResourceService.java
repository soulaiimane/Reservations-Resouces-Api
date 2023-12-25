package org.sid.resourcesservice.service;

import org.sid.resourcesservice.dtos.ResourceDto;
import org.sid.resourcesservice.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ResourceService {
    public List<ResourceDto> resourceList();
    public ResourceDto resourceById(Long resourceId) throws ResourceNotFoundException;
    public ResourceDto addResource(ResourceDto resourceDto);
}
