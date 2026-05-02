package com.weolyse.project.servlet;

import com.weolyse.project.service.FlightService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/flights")
public class FlightServlet extends HttpServlet {

    private final FlightService flightService = FlightService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = resp.getWriter()) {
            writer.write("<ul>");
            flightService.getAllFlights().forEach( flightDto -> {
                        writer.write("<li>");
                        writer.write("""
                                %d. %s
                                """.formatted(flightDto.getId(), flightDto.getDescription()));
                        writer.write("</li>");
            });
            writer.write("</ul>");
        }
    }
}