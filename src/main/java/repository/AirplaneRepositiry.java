package repository;

import model.Airplane;

public interface AirplaneRepositiry extends Repository<Integer, Airplane>{
    Airplane findAirplane();
}
