package com.mygroup.membranesdatabasewebservice.api;

import java.util.List;
import java.util.Optional;

public interface MembraneDatabaseInterface {

    List<Membrane> getAllMembranes();

    Optional<Membrane> getOneMembrane(Long id);

    void addMembraneToDatabase(Membrane membrane);

    void clearMembraneDatabase();


}
