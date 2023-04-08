package com.mygroup.membranesdatabasewebservice.api;

import java.util.List;
import java.util.Optional;

public interface MembraneDatabaseInterface {

    List<MembraneInternalEntity> getAllMembranes();

    Optional<MembraneInternalEntity> getOneMembrane(Long id);

    void addMembraneToDatabase(MembraneInternalEntity membraneInternalEntity);

    void clearMembraneDatabase();

    void clearMembraneDatabaseById(Long id);

    long countEntries();
}
