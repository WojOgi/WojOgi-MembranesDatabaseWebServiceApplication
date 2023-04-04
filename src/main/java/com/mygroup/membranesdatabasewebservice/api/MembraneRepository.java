package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.data.repository.CrudRepository;

public interface MembraneRepository extends CrudRepository<MembraneInternalEntity,Long> {
}
