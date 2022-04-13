package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value="/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam (name="year", required = false) Integer year,
            @RequestParam (name="region", required = false) String region
    ){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if (region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        else
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
    

    @GetMapping(value="/whiskies/{age}/{name}")
    public ResponseEntity<List<Whisky>> getWhiskyByDistAndYear(@PathVariable int age, @PathVariable String name){
        return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryName(age, name), HttpStatus.OK);
    }

}
