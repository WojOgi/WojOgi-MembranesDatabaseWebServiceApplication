package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Primary
public class SimpleMembraneDatabaseInterface implements MembraneDatabaseInterface {

    private static final List<Membrane> membraneDatabase = new ArrayList<>();

    @Override
    public List<Membrane> getAllMembranes() {
        return membraneDatabase;
    }

    @Override
    public void addMembraneToDatabase(Membrane membrane) {
        membraneDatabase.add(membrane);
    }

    @Override
    public void clearMembraneDatabase() {
        membraneDatabase.clear();
    }
}
