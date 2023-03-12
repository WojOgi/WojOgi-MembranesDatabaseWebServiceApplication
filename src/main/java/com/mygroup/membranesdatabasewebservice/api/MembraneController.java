package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Membrane>> getAllMembranes() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Get", "Get All Membranes From Database");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body(databaseRepository.getAllMembranes());
        //tutaj getAllMembranes nie powinien zwracac naszych wewnętrznych membranes
        //trzeba przemapować
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

    @PostMapping(value = "/membranes")
    public ResponseEntity<String> addMembrane(@RequestBody AddMembraneRequest membrane) {
        databaseRepository.addMembraneToDatabase(toMembrane(membrane));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Post", "Adding a New Entry to the Membrane Database");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body("Added Entry: " + membrane);
    }

    private Membrane toMembrane(AddMembraneRequest inputMembraneData) {
        return new Membrane(inputMembraneData.getPolymerPrecursor(), inputMembraneData.getPyrolysisTemperature());
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

}
