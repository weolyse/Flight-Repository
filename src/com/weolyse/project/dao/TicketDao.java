package com.weolyse.project.dao;

import com.weolyse.project.entity.Ticket;
import com.weolyse.project.util.ConnectionManager;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDao implements Dao<Long, Ticket> {

    private static final TicketDao INSTANCE = new TicketDao();

    private static final String FIND_ALL = """
            SELECT * 
            FROM ticket
            """;

    private static final String FIND_ALL_BY_FLIGHTID = FIND_ALL + """
            WHERE flight_id=?;
            """;

    private TicketDao() {};

    public static TicketDao getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    public List<Ticket> findAllByFlightId(Long flightId) {

        try (var connection = ConnectionManager.open();
             var statement = connection.prepareStatement(FIND_ALL_BY_FLIGHTID)) {

            statement.setLong(1, flightId);
            ResultSet resultSet = statement.executeQuery();
            ArrayList<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(build(resultSet));
            }

            return tickets;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public Ticket create(Ticket entity) {
        return null;
    }

    @Override
    public void update(Ticket entity) {

    }

    private Ticket build(ResultSet resultSet) throws SQLException {
        return new Ticket(
                resultSet.getObject("id", Long.class),
                resultSet.getObject("passenger_no", String.class),
                resultSet.getObject("passenger_name", String.class),
                resultSet.getObject("flight_id", Long.class),
                resultSet.getObject("seat_no", String.class),
                resultSet.getObject("cost", BigDecimal.class)
        );
    }
}
