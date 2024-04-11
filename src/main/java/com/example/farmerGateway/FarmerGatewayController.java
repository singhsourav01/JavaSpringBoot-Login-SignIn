package com.example.farmerGateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/farmers")
 class FarmerController {
    @Autowired
    private FarmerRepository farmerRepository;

    
    @PostMapping("/signup")
    public ResponseEntity<Farmer> signUp(@RequestBody Farmer farmer) {
        Farmer createdFarmer = farmerRepository.save(farmer);
        if (createdFarmer != null) {
            return new ResponseEntity<>(createdFarmer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Farmer loginUser) {
        Optional<Farmer> userOptional = farmerRepository.findByUsername(loginUser.getUsername());
        if (userOptional.isPresent()) {
            return ResponseEntity.ok("Login successful");

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        }
    }
    // Other controller methods for CRUD operations
}
