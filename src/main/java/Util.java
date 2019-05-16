import model.Flight;
import repository.FlightRepository;
import repository.JdbcFlightRepository;

import java.sql.Timestamp;
import java.util.Random;

public class Util {
    private static Long yearPerMillis = 365*24*60*60*1000L;
    private static Long hourPerMillis = 60*60*1000L;
    static Random random = new Random();
    public static Flight createRandomFlight() {
        Flight flight = new Flight();
        long currentTime = System.currentTimeMillis();
        long leftLimit = currentTime-yearPerMillis;
        long rightLimit = currentTime;
        long departure = leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
        long arrival = departure + hourPerMillis*8;
        flight.setDeparture(new Timestamp(departure));
        flight.setArrival(new Timestamp(arrival));
        flight.setCost(random.nextInt(200));
        return flight;
    }

    public static boolean buyTicket(Flight flight, FlightRepository flightRepository) {
       int seats = flight.getAirplane().getAirplaneModel().getSeats();
        Integer purchared_tickets = flight.getPurchared_tickets();
        System.out.println(" seats="+ seats +" purchared="+purchared_tickets);
        if (purchared_tickets<seats) {
            flight.setPurchared_tickets(purchared_tickets+1);
            flightRepository.update(flight);
            return true;
        }
        return false;
    }
}
