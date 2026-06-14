package com.weolyse.project.entity;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Flight {

    Long id;
    String flightNo;
    LocalDateTime departureDate;
    String departureAirportCode;
    LocalDateTime arrivalDate;
    String arrivalAirportCode;
    Integer aircraftId;
    FlightStatus status;

}
