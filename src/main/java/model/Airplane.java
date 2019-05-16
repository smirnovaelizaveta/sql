package model;

public class Airplane {
    private Integer airplane_id;
    private AirplaneModel airplaneModel;

    public Integer getAirplane_id() {
        return airplane_id;
    }

    public void setAirplane_id(Integer airplane_id) {
        this.airplane_id = airplane_id;
    }

    public AirplaneModel getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(AirplaneModel airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public Airplane(Integer airplane_id, AirplaneModel airplaneModel) {
        this.airplane_id = airplane_id;
        this.airplaneModel = airplaneModel;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "airplane_id=" + airplane_id +
                ", airplaneModel=" + airplaneModel +
                '}';
    }
}
