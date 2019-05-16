package repository;

import model.Flight;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcFlightRepository extends JdbcRepository implements FlightRepository {
    static String insertQuery = "insert into airport.flight(departure, arrival, cost, purchared_tickets, airplane_id, flight_id) values(?,?,?,?,?, ?)";
    static String readQuery = "SELECT name, departure, arrival, cost, purchared_tickets, airplane_id, flight_id FROM airport.flight where flight_id=?;";
    static String updateQuery = "UPDATE airport.flight SET purchared_tickets=? WHERE flight_id = ?;";


    @Override
    public void create(Flight flight) {
        int id = 0;

        try(PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) FROM airport.flight;")) {

            //preparedStatement.executeQuery()
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("count")+1; }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setTimestamp(1, flight.getDeparture());
            preparedStatement.setTimestamp(2, flight.getArrival());
            preparedStatement.setInt(3, flight.getCost());
            preparedStatement.setInt(4, flight.getPurchared_tickets());
            preparedStatement.setInt(5, flight.getAirplane().getAirplane_id());
            preparedStatement.setInt(6, id); flight.setFlight_id(id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Flight read(Integer integer) throws SQLException {
        return withConnection( conn -> {
            try (PreparedStatement preparedStatement = conn.prepareStatement(readQuery)) {
                preparedStatement.setInt(1, integer);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (!resultSet.next())
                    return null;

                Flight flight = new Flight();
                flight.setPurchared_tickets(resultSet.getInt("Purchared_tickets"));
                flight.setAirplane(new JdbcAirplaneRepository().read(resultSet.getInt("airplane_id")));
                flight.setCost(resultSet.getInt("cost"));
                flight.setDeparture(resultSet.getTimestamp("departure"));
                flight.setArrival(resultSet.getTimestamp("arrival"));
                flight.setName(resultSet.getString("name"));
                flight.setFlight_id(resultSet.getInt("flight_id"));
                return flight;
            }
        } );
    }

    @Override
    public void update(Flight flight) throws SQLException {
        Flight flightToUpdate = read(flight.getFlight_id());
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setInt(1, flight.getPurchared_tickets());
            preparedStatement.setInt(2, flightToUpdate.getFlight_id());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Integer integer) {

    }
}
