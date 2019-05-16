import model.Flight;
import repository.AirplaneRepositiry;
import repository.FlightRepository;
import repository.JdbcAirplaneRepository;
import repository.JdbcFlightRepository;

import java.sql.*;
import java.util.Random;
/*PreparedStatement*/
public class JDBCExample {
    /*static Long yearPerMillis = 365*24*60*60*1000L;
    static Long hourPerMillis = 60*60*1000L;
    static final String DB_URL = "jdbc:postgresql://msk1-cbox215.unix.nspk.ru:5432/smirnovaea";
    static final String USER = "smirnovaea";
    static final String PASS = "password";*/
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        AirplaneRepositiry airplaneRepositiry = new JdbcAirplaneRepository();
        FlightRepository flightRepository = new JdbcFlightRepository();
        Flight randomFlight = Util.createRandomFlight();
        randomFlight.setAirplane(airplaneRepositiry.findAirplane());
        flightRepository.create(randomFlight);
        System.out.println(randomFlight);

        int i1 = new Random().nextInt(500);
        System.out.println(i1);
        for (int i = 0; i< i1; i++) {
            System.out.print("i="+i+" ");
        Util.buyTicket(randomFlight, flightRepository); }







    }


}
