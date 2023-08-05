package com.example.demo.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Location;

@RestController
@CrossOrigin(origins = "*")
public class LocationController {
    

    @PostMapping("/api/saveLocation")
    public ResponseEntity<String> saveLocation(@RequestBody Location location) {
        // You can now process the received location data and save it to the database
        // For example, create a Location entity and use a service to save it to the database

        // Sample code to save the data to the database (replace with your actual logic)
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        long timestamp = location.getTimestamp();


        // Your service to save the location to the database

        // Return a response indicating success
        return ResponseEntity.ok("Location data received and saved successfully.");
    }
}