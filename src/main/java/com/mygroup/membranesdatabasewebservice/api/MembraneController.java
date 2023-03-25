package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

        List<Membrane> allMembranes = databaseRepository.getAllMembranes();
        List<MembraneResponse> membraneResponses = toMembraneResponse(allMembranes);
        //method toMembraneResponse maps a list of our internal entries of type Membrane
        //onto a list of MembraneResponse - we decide what we want to show to the client
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body(membraneResponses);
    }

    private List<MembraneResponse> toMembraneResponse(List<Membrane> allMembranes) {
        List<MembraneResponse> membraneResponses = new ArrayList<>();
        for (int i = 0; i < allMembranes.size(); i++) {
            MembraneResponse membraneResponse = new MembraneResponse(allMembranes.get(i).getPolymerPrecursor(),
                    allMembranes.get(i).getPyrolysisTemperature());
            //for each element in our internal list allMembranes, we create an object of type MembraneResponse
            //and using getters we extract and save values of the fields
            membraneResponses.add(membraneResponse);
        }
        return membraneResponses;
    }

    @GetMapping(value = "/membranes/{id}")
    public ResponseEntity<Optional<Membrane>> getOneMembraneByItsId(@PathVariable Long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Get Membrane by Id", "Get One Membrane By Its Id");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body(databaseRepository.getOneMembrane(id));
    }
//TODO get by id should not give the internal entry of type Membrane - need to map it as well to only give prec and temp

    @PostMapping(value = "/membranes")
    public ResponseEntity<String> addMembrane(@RequestBody AddMembraneRequest membraneToBeAdded) {
        databaseRepository.addMembraneToDatabase(toMembrane(membraneToBeAdded));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Post", "Adding a New Entry to the Membrane Database");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body("Added Entry: " + membraneToBeAdded);
    }

    private Membrane toMembrane(AddMembraneRequest inputMembraneData) {
        return new Membrane(inputMembraneData.getPolymerPrecursor(), inputMembraneData.getPyrolysisTemperature(),
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
        return ResponseEntity
                .ok()
                .headers(responseHeader)
                .body("Database Cleared");

    }

    //zaimplementować metodę rodzaju delete by id, żeby usunąć konkretne entry w bazie

    //być może zaimplementować też coś to liczy entries (count())

}
