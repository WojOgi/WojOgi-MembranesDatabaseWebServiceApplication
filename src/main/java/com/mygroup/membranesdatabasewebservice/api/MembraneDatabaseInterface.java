package com.mygroup.membranesdatabasewebservice.api;

import java.util.List;
import java.util.Optional;

public interface MembraneDatabaseInterface {
    //the interface declares a set of methods which will be implemented (or concretely defined) by a class that implements the interface

    List<MembraneInternalEntity> getAllMembranes();

    Optional<MembraneInternalEntity> getOneMembrane(Long id);

    void addMembraneToDatabase(MembraneInternalEntity membraneInternalEntity);

    void clearMembraneDatabase();

    void clearMembraneDatabaseById(Long id);

    long countEntries();
}
