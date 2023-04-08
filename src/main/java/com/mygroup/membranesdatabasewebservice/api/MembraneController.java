package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MembraneController {

    @Autowired
    private MembraneDatabaseInterface databaseRepository;
    //tutaj mamy zautowirewany databaseRepository typu MembraneDatabaseInterface
    //on nam definiuje metody, a implementuje go SimpleMembraneDatabaseInterface
    //oraz nasz H2Repository - w tym momencie H2Repository jest oznaczony jako @Primary
    //SimpleMembraneDatabaseInterface jest zatem ignorowany

    @GetMapping(value = "/membranes")
    public ResponseEntity<List<MembraneResponse>> getAllMembranes() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Get", "Get All Membranes From Database");

        List<MembraneInternalEntity> allMembraneInternalEntities = databaseRepository.getAllMembranes();
        List<MembraneResponse> membraneResponses = toMembraneResponse(allMembraneInternalEntities);
        //method toMembraneResponse maps a list of our internal entries of type Membrane
        //onto a list of MembraneResponse - we decide what we want to show to the client
        return ResponseEntity.ok().headers(responseHeaders).body(membraneResponses);
    }

    private List<MembraneResponse> toMembraneResponse(List<MembraneInternalEntity> allMembraneInternalEntities) {
        //null pointer exception
        List<MembraneResponse> membraneResponses = new ArrayList<>();
        for (int i = 0; i < allMembraneInternalEntities.size(); i++) {
            MembraneInternalEntity currentElement = allMembraneInternalEntities.get(i);
            MembraneResponse membraneResponse = new MembraneResponse(currentElement.getPolymerPrecursor(), currentElement.getPyrolysisTemperature());
            //for each element in our internal list allMembranes, we create an object of type MembraneResponse
            //and using getters we extract and save values of the fields
            membraneResponses.add(membraneResponse);
        }
        return membraneResponses;
    }

    @GetMapping(value = "/membranes/{id}")
    public ResponseEntity<MembraneResponse> getOneMembraneByItsId(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Get Membrane by Id", "Get One Membrane By Its Id");

        MembraneResponse membraneResponse = databaseRepository.getOneMembrane(id)
                .map(it -> new MembraneResponse(it.getPolymerPrecursor(), it.getPyrolysisTemperature())).orElse(null);

        if (membraneResponse == null) {
            return ResponseEntity.status(404).headers(responseHeaders).body(null);
        }

        return ResponseEntity.ok().headers(responseHeaders).body(membraneResponse);
    }

    @PostMapping(value = "/membranes")
    public ResponseEntity<String> addMembrane(@RequestBody AddMembraneRequest membraneToBeAdded) {
        databaseRepository.addMembraneToDatabase(toMembrane(membraneToBeAdded));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Post", "Adding a New Entry to the Membrane Database");
        return ResponseEntity.ok().headers(responseHeaders).body("Added Entry: " + membraneToBeAdded);
    }

    private MembraneInternalEntity toMembrane(AddMembraneRequest inputMembraneData) {
        return new MembraneInternalEntity(inputMembraneData.getPolymerPrecursor(), inputMembraneData.getPyrolysisTemperature(),
                inputMembraneData.getSolvent(), inputMembraneData.getSolutionConcentrationWtPerc());
    }
    //metoda toMembrane zwraca typ Membrane, przyjmuje argument typu AddMemReq
    //i na podstawie jego danych przemapowuje go na nasz wewnętrzny obiekt który trafia do
    //bazy danych

    @DeleteMapping(value = "/membranes/clear")
    public ResponseEntity<String> clearMembraneDatabase() {
        databaseRepository.clearMembraneDatabase();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("Clear Database", "Membrane Database Cleared");
        return ResponseEntity.ok().headers(responseHeader).body("Database Cleared");

    }

    @DeleteMapping(value = "/membranes/{id}")
    public ResponseEntity<String> clearMembraneDatabaseById(@PathVariable Long id) {
        databaseRepository.clearMembraneDatabaseById(id);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("Clear Database", "Membrane Database Cleared");
        return ResponseEntity.ok().headers(responseHeader).body("Entry with id: " + id + " removed from Database.");
    }

    @GetMapping(value = "/membranes/count")
    public ResponseEntity<String> countEntries() {
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("Count entries", "Entries counted");

        return ResponseEntity.ok().headers(responseHeader).body("There are " + databaseRepository.countEntries()
                + " entries in the Database.");
    }


}
