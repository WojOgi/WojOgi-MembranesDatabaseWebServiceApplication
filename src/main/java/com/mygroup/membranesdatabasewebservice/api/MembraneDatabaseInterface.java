package com.mygroup.membranesdatabasewebservice.api;

import java.util.List;

public interface MembraneDatabaseInterface {

    List<Membrane> getAllMembranes();

    void addMembraneToDatabase(Membrane membrane);

    void clearMembraneDatabase();



}
