package org.sid.reservationservice.OpenFeign;

import org.sid.reservationservice.dtos.ResourceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "resource-service")

public interface ResourceRestClientService {
    @GetMapping("/resources")
    public List<ResourceDto> resourceList();

    @GetMapping("/resources/{resourceId}")
    public ResourceDto resourceById(@PathVariable Long resourceId);

}
