package com.udacity.dogrestapi.service;

import com.udacity.dogrestapi.model.Dog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DogService {
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();
}
