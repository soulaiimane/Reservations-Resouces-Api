package org.sid.resourcesservice.mappers;

import org.sid.resourcesservice.dtos.ResourceDto;
import org.sid.resourcesservice.entities.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ResourceMapper {
    public ResourceDto fromResource(Resource resource){
        ResourceDto resourceDto=new ResourceDto();
        BeanUtils.copyProperties(resource,resourceDto);
        return resourceDto;
    }
    public Resource fromResourceDto(ResourceDto resourceDto){
        Resource resource=new Resource();
        BeanUtils.copyProperties(resourceDto,resource);
        return resource;
    }
}
