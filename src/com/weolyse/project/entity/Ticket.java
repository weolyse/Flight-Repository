package com.weolyse.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Ticket {

    Long id;
    String passengerNo;
    String passengerName;
    Long flightId;
    String seatNo;
    BigDecimal cost;

}
