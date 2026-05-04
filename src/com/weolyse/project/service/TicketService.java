package com.weolyse.project.service;

import com.weolyse.project.dao.TicketDao;
import com.weolyse.project.dto.TicketDto;

import java.util.List;

public class TicketService {

    private final TicketDao ticketDao = TicketDao.getInstance();
    private static final TicketService INSTANCE = new TicketService();

    private TicketService() {};

    public static TicketService getInstance() {
        return INSTANCE;
    }

    public List<TicketDto> getAllTicketByFlightId(Long flightId) {
        return ticketDao.findAllByFlightId(flightId).stream()
                .map(ticket -> new TicketDto(ticket.getId(), ticket.getSeatNo()))
                .toList();
    }
}
