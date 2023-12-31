package org.sid.resourcesservice.controller;

import lombok.AllArgsConstructor;
import org.sid.resourcesservice.dtos.ResourceDto;
import org.sid.resourcesservice.exceptions.ResourceNotFoundException;
import org.sid.resourcesservice.service.ResourceServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ResourceRestController {
    private ResourceServiceImpl resourceService;
    @GetMapping("/resources")
    public List<ResourceDto> resourceList(){
        return resourceService.resourceList();

    }
    @GetMapping("/resources/{resourceId}")
    public ResourceDto resourceById(@PathVariable Long resourceId) throws ResourceNotFoundException{
        return resourceService.resourceById(resourceId);
    }
}
