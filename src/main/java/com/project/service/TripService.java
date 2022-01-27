package com.project.service;

import com.project.domain.Trip;
import com.project.messaging.EmailController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private EmailController emailController;


    public Trip saveTrip(Trip trip){
        return this.tripRepository.save(trip);
    }

    public List<Trip> findAllTrips(){
        return (List<Trip>) tripRepository.findAll();
    }

    public void deleteTrip(long id){
           tripRepository.delete(id);
    }

    public Trip editTrip(Trip trip){
            return this.tripRepository.save(trip);
    }

    public List<Trip> findLateUndoneTrips(){
        return tripRepository.findLateUndoneTrips();
    }

    public void sendEmailWithUndoneTrips(){
        List<Trip> trips = findLateUndoneTrips();
        if (trips.isEmpty()) return;
        emailController.send();
    }

}
