package com.project.web;

import com.project.domain.Trip;
import com.project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trips")
public class TripController {


    @Autowired
    private TripService tripService;

    @PostMapping
    public Trip create(@RequestBody Trip trip) {
        return tripService.saveTrip(trip);
    }

    @GetMapping
    public List<Trip> getTrips() {
        return (List<Trip>) tripService.findAllTrips();
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable ("id") long id) {
        tripService.deleteTrip(id);
    }


    @PutMapping ("/{id}")
    public Trip edit (@RequestBody Trip trip, @PathVariable ("id") long id) {
       return this.tripService.editTrip(trip);
    }

}
