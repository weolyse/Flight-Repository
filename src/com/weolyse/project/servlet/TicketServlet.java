package com.weolyse.project.servlet;

import com.weolyse.project.service.FlightService;
import com.weolyse.project.service.TicketService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet {

    private final TicketService ticketService = TicketService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String flightId = req.getParameter("flightId");
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<ul>");
            ticketService.getAllTicketByFlightId(Long.valueOf(flightId)).forEach(ticketDto -> {
                writer.write("""
                        <li> id: %d  Seat Number: %s </li>
                        """.formatted(ticketDto.getId(), ticketDto.getSeatNo()));
            });
            writer.write("</ul>");
        }
    }
}
