package com.project.service;

import com.project.domain.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends CrudRepository<Trip, Long> {


    @Query(nativeQuery = true, value = "SELECT * FROM Trip WHERE done=0 AND date < CURDATE() - INTERVAL 2 DAY ORDER BY date DESC")
    List<Trip> findLateUndoneTrips();

    }
