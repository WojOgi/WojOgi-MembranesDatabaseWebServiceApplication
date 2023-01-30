package com.mygroup.membranesdatabasewebservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MembraneController {

    @Autowired
    private SimpleMembraneDatabaseInterface simpleMembraneDatabaseInterface;

    @GetMapping(value = "/membranes")
    public ResponseEntity<List<Membrane>> getAllMembranes() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Get", "Get All Membranes From Database");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body(simpleMembraneDatabaseInterface.getAllMembranes());
    }

    @PostMapping(value = "/membranes")
    public ResponseEntity<String> addMembrane(@RequestBody Membrane membrane) {
        simpleMembraneDatabaseInterface.addMembraneToDatabase(membrane);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Post", "Adding a New Entry to the Membrane Database");
        return ResponseEntity
                .ok()
                .headers(responseHeaders)
                .body("Added Entry: " + membrane.toString());
    }

    @DeleteMapping(value = "/membranes/clear")
    public ResponseEntity<String> clearMembraneDatabase() {
        simpleMembraneDatabaseInterface.clearMembraneDatabase();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("Clear Database", "Membrane Database Cleared");
        return ResponseEntity
                .ok()
                .headers(responseHeader)
                .body("Database Cleared");

    }

}
