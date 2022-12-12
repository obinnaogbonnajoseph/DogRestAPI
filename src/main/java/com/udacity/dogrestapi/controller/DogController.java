package com.udacity.dogrestapi.controller;

import com.udacity.dogrestapi.model.Dog;
import com.udacity.dogrestapi.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dogs")
public class DogController {

    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        return new ResponseEntity<>(dogService.retrieveDogs(), HttpStatus.OK);
    }

    @GetMapping("breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        return new ResponseEntity<>(dogService.retrieveDogBreed(), HttpStatus.OK);
    }

    @GetMapping("{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long id) {
        return new ResponseEntity<>(dogService.retrieveDogBreedById(id), HttpStatus.OK);
    }

    @GetMapping("name")
    public ResponseEntity<List<String>> getDogNames() {
        return new ResponseEntity<>(dogService.retrieveDogNames(), HttpStatus.OK);
    }

}
