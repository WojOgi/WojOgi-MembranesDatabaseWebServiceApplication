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
    public List<MembraneInternalEntity> getAllMembranes() {

        return (List<MembraneInternalEntity>) membraneRepository.findAll();
        //może tutaj dać np stream?
    }

    public Optional<MembraneInternalEntity> getOneMembrane(Long id) {

        return membraneRepository.findById(id);
    }

    @Override
    public void addMembraneToDatabase(MembraneInternalEntity membraneInternalEntity) {

        membraneRepository.save(membraneInternalEntity);
    }

    @Override
    public void clearMembraneDatabase() {

        membraneRepository.deleteAll();
    }
    @Override
    public void clearMembraneDatabaseById(Long id) {

        membraneRepository.deleteById(id);
    }
    @Override
    public long countEntries(){return membraneRepository.count();}

}
