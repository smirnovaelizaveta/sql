package model;

public class AirplaneModel {
    private Integer airplaneModel_id;
    private String name;
    private Integer seats;

    public Integer getAirplaneModel_id() {
        return airplaneModel_id;
    }

    public void setAirplaneModel_id(Integer airplaneModel_id) {
        this.airplaneModel_id = airplaneModel_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public AirplaneModel(Integer airplaneModel_id, String name, Integer seats) {
        this.airplaneModel_id = airplaneModel_id;
        this.name = name;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "AirplaneModel{" +
                "airplaneModel_id=" + airplaneModel_id +
                ", name='" + name + '\'' +
                ", seats=" + seats +
                '}';
    }
}
