package com.apap.tutorial7.service;

import java.util.List;
import java.util.Optional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDb flightDb;
    
    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDb.save(flight);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        flightDb.deleteByFlightNumber(flightNumber);
    }

    @Override
    public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
        return flightDb.findByFlightNumber(flightNumber);
    }
    
    @Override
    public FlightModel getFlightDetailById(long flightId) {
        return flightDb.getOne(flightId);
    }
    
    @Override
	public void updateFlight(long flightId, FlightModel flight) {
		FlightModel oldFlight = flightDb.getOne(flightId);
		oldFlight.setDestination(flight.getDestination());
		oldFlight.setOrigin(flight.getOrigin());
	}
    
    @Override
    public List<FlightModel> getAllFlight() {
        return flightDb.findAll();
    }
}