package org.pupperpals.adoption.controller;


import org.pupperpals.adoption.model.Pupper;
import org.pupperpals.adoption.service.PupperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PupperController {

    @Autowired
    PupperService service;

    @GetMapping("/puppers")
    public ResponseEntity<Iterable<Pupper>> findAllPuppers(){
        return new ResponseEntity(service.findAllPuppers(), HttpStatus.OK);
    }

    @PostMapping("/pupper")
    public ResponseEntity<Pupper> addPupper(@RequestBody Pupper p) {

        service.addPupper(p);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }

    @PatchMapping("/pupper/{id}")
    public ResponseEntity<Pupper> updatePupper(@RequestBody Pupper p, @PathVariable long id) {
            Pupper result = service.updatePupper(p, id).orElse(null);
            if(result != null)
                return new ResponseEntity(result, HttpStatus.OK);
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
