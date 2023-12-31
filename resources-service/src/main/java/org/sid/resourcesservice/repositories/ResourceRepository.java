package org.sid.resourcesservice.repositories;

import org.sid.resourcesservice.entities.Resource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceRepository extends JpaRepository<Resource,Long> {


}
