package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component

public class SimpleMembraneDatabaseInterface implements MembraneDatabaseInterface {

    private static final List<MembraneInternalEntity> MEMBRANE_INTERNAL_ENTITY_DATABASE = new ArrayList<>();

    @Override
    public List<MembraneInternalEntity> getAllMembranes() {
        return MEMBRANE_INTERNAL_ENTITY_DATABASE;
    }

    @Override
    public Optional<MembraneInternalEntity> getOneMembrane(Long id) {
        return Optional.empty();
    }

    // @Override
   // public Optional<Membrane> getOneMembrane(Long id) {
   //     return membraneDatabase.get(id);
   //}

    @Override
    public void addMembraneToDatabase(MembraneInternalEntity membraneInternalEntity) {
        MEMBRANE_INTERNAL_ENTITY_DATABASE.add(membraneInternalEntity);
    }

    @Override
    public void clearMembraneDatabase() {
        MEMBRANE_INTERNAL_ENTITY_DATABASE.clear();
    }
    @Override
    public void clearMembraneDatabaseById(Long id) {
    }
    @Override
    public long countEntries(){return 1;}
}
