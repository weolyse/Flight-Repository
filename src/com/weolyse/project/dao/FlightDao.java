package com.weolyse.project.dao;

import com.weolyse.project.entity.Flight;
import com.weolyse.project.entity.FlightStatus;
import com.weolyse.project.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Long, Flight> {

    private static final FlightDao INSTANCE = new FlightDao();

    private static final String FIND_ALL_SQL = """
            SELECT *
            FROM flight
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE id=?
            """;

    private FlightDao(){};

    public static FlightDao getInstance() {
        return INSTANCE;
    }


    @Override
    public List<Flight> findAll() {
        try (Connection connection = ConnectionManager.open();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL_SQL)) {

            List<Flight> flights = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flights.add(build(resultSet));
            }
            return flights;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Flight create(Flight entity) {
        return null;
    }

    @Override
    public void update(Flight entity) {

    }

    private Flight build(ResultSet resultSet) {
        try {
            return new Flight(
                    resultSet.getObject("id", Long.class),
                    resultSet.getObject("flight_no", String.class),
                    resultSet.getObject("departure_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("departure_airport_code", String.class),
                    resultSet.getObject("arrival_date", Timestamp.class).toLocalDateTime(),
                    resultSet.getObject("arrival_airport_code", String.class),
                    resultSet.getObject("aircraft_id", Integer.class),
                    FlightStatus.valueOf(resultSet.getObject("status", String.class))
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
