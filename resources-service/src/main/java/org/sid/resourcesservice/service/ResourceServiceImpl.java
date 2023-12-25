package org.sid.resourcesservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.sid.resourcesservice.dtos.ResourceDto;
import org.sid.resourcesservice.entities.Resource;
import org.sid.resourcesservice.exceptions.ResourceNotFoundException;
import org.sid.resourcesservice.mappers.ResourceMapper;
import org.sid.resourcesservice.repositories.ResourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ResourceServiceImpl implements ResourceService{
    private ResourceRepository resourceRepository;
    private ResourceMapper mapper;

    @Override
    public List<ResourceDto> resourceList() {
        List<ResourceDto> resourceDtoList = resourceRepository.findAll().stream().map(resource ->
                mapper.fromResource(resource)).toList();
        return resourceDtoList;
    }

    @Override
    public ResourceDto resourceById(Long resourceId) throws ResourceNotFoundException {
        Resource resource = resourceRepository.findById(resourceId).orElse(null);
        if (resource==null){
            log.info("Resource Not Found With Id= " + resourceId);
            throw new ResourceNotFoundException("Resource Not Found");
        }
        return mapper.fromResource(resource);
    }

    @Override
    public ResourceDto addResource(ResourceDto resourceDto) {
        Resource resource=new Resource();
        resource.setResourceType(resourceDto.getResourceType());
        resource.setName(resourceDto.getName());
        Resource savedResource = resourceRepository.save(resource);
        return mapper.fromResource(savedResource);
    }
}
