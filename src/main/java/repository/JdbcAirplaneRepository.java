package repository;

import model.Airplane;
import model.AirplaneModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class JdbcAirplaneRepository extends JdbcRepository implements AirplaneRepositiry {
    static String findAirplaneQuery = "select * from (select * from airport.Airplane   ORDER BY RANDOM ()    LIMIT 1   ) As l1   join airport.airplanemodel as l4 on l1.airplanemodel_id=l4.airplanemodel_id";


    @Override
    public Airplane findAirplane() {
        int seats = 0;
        int airplane_id = 0;
        String name = "";
        int airplanemodel_id = 0;
        AirplaneModel airplaneModel = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(findAirplaneQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                airplane_id = resultSet.getInt("airplane_id");
                seats = new Random().nextInt(resultSet.getInt("seats"));
                name = resultSet.getString("name");
                airplanemodel_id = resultSet.getInt("airplanemodel_id");
                airplaneModel = new AirplaneModel(airplanemodel_id, name, seats);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Airplane(airplane_id, airplaneModel);
    }

    @Override
    public void create(Airplane airplane) {

    }

    @Override
    public Airplane read(Integer integer) {
        return null;
    }

    @Override
    public void update(Airplane airplane) {

    }

    @Override
    public void delete(Integer integer) {

    }
}
