package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.data.repository.CrudRepository;

public interface MembraneRepository extends CrudRepository<MembraneInternalEntity,Long> {
    //here we do not define any custom methods - MembraneRepository simply inherits a set of standard methods from CrudRepository
}
