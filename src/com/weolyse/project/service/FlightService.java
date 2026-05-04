package com.weolyse.project.service;

import com.weolyse.project.dao.FlightDao;
import com.weolyse.project.dto.FlightDto;

import java.util.List;

public class FlightService {

    private static final FlightService INSTANCE = new FlightService();
    private final FlightDao flightDao = FlightDao.getInstance();

    private FlightService() {};

    public static FlightService getInstance() {
        return INSTANCE;
    }

    public List<FlightDto> getAllFlights() {
        return flightDao.findAll().stream()
                .map(flight -> new FlightDto(
                        flight.getId(),
                        """
                                Departure date: %s Arrival date: %s Status: %s
                                """.formatted(flight.getDepartureDate().toString(), flight.getArrivalDate().toString(), flight.getStatus().toString())
                        )
                ).toList();
    }

}
