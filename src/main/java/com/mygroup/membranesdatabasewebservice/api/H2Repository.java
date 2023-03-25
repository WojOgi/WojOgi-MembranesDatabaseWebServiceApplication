package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class H2Repository implements MembraneDatabaseInterface {
    @Autowired
    MembraneRepository membraneRepository;
    //H2Repository sobie zautowirewał coś co potrafi zrobić save (bo extenduje Crud)

    @Override
    public List<Membrane> getAllMembranes() {

        return (List<Membrane>) membraneRepository.findAll();
        //może tutaj dać np stream?
    }

    public Optional<Membrane> getOneMembrane(Long id) {

        return membraneRepository.findById(id);
    }

    @Override
    public void addMembraneToDatabase(Membrane membrane) {

        membraneRepository.save(membrane);
    }

    @Override
    public void clearMembraneDatabase() {

        membraneRepository.deleteAll();
    }
}
