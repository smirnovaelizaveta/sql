package model;

import java.sql.Timestamp;
import java.util.Random;

public class Flight {
    private Integer flight_id;
    private String name;
    private Airplane airplane;
    private Timestamp departure;
    private Timestamp arrival;
    private Integer cost;
    private Integer purchared_tickets = 0;


    public Integer getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(Integer flight_id) {
        this.flight_id = flight_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Timestamp getDeparture() {
        return departure;
    }

    public void setDeparture(Timestamp departure) {
        this.departure = departure;
    }

    public Timestamp getArrival() {
        return arrival;
    }

    public void setArrival(Timestamp arrival) {
        this.arrival = arrival;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getPurchared_tickets() {
        return purchared_tickets;
    }

    public void setPurchared_tickets(Integer purchared_tickets) {
        this.purchared_tickets = purchared_tickets;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flight_id=" + flight_id +
                ", name='" + name + '\'' +
                ", airplane=" + airplane +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", cost=" + cost +
                ", purchared_tickets=" + purchared_tickets +
                '}';
    }
}
