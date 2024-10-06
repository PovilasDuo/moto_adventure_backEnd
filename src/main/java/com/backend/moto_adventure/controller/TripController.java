package com.backend.moto_adventure.controller;

import com.backend.moto_adventure.entity.Trip;
import com.backend.moto_adventure.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/this-week")
    public List<Trip> getCurrentWeekTrips() {
        return tripService.getCurrentWeekTrips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id) {
        return tripService.getTripById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Trip createTrip(@RequestBody Trip trip) {
        return tripService.saveTrip(trip);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trip> updateTrip(@PathVariable Long id, @RequestBody Trip tripDetails) {
        return tripService.getTripById(id).map(trip -> {
            trip.setStartTime(tripDetails.getStartTime());
            trip.setStartDate(tripDetails.getStartDate());
            trip.setLocation(tripDetails.getLocation());
            return ResponseEntity.ok(tripService.saveTrip(trip));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrip(@PathVariable Long id) {
        return tripService.getTripById(id).map(trip -> {
            tripService.deleteTrip(id);
            return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
