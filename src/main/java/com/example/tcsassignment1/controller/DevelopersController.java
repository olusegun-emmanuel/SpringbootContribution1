package com.example.tcsassignment1.controller;

import com.example.tcsassignment1.model.DevelopersModel;
import com.example.tcsassignment1.services.DevelopersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/developers")
public class DevelopersController {

    @Autowired
    DevelopersServices developersServices;

    @GetMapping("")
    public List<DevelopersModel> getAllDevelopers(){
        return developersServices.getAllDevelopers();
    }

    @PostMapping("")
    public ResponseEntity<?> addNewDeveloper(@RequestBody DevelopersModel developersModel){
        boolean developerCreated = developersServices.createNewDeveloper(developersModel);
        if(developerCreated)
            return new ResponseEntity<>("Developer is created successfully", HttpStatus.CREATED);
        else{
            return new ResponseEntity<>("Error creating new developer", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDeveloper(@RequestBody DevelopersModel developersModel, @PathVariable Long id){
        boolean developerUpdated = developersServices.updateDeveloper(developersModel, id);
        if(developerUpdated)
            return new ResponseEntity<>("Developer is updated successfully", HttpStatus.CREATED);
        else{
            return new ResponseEntity<>("Error updating developer", HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDeveloper(@PathVariable Long id){
        developersServices.deleteDeveloper(id);
        return new ResponseEntity<>("Error creating new developer", HttpStatus.OK);
    }
}
