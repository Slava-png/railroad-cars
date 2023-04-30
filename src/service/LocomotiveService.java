package service;

import model.locomotive.Locomotive;
import model.railroadCars.RailroadCar;

public interface LocomotiveService {
    void addRailRoadCar(Locomotive locomotive, RailroadCar railroadCar);

    void removeRailRoadCar(Locomotive locomotive, RailroadCar railroadCar);
}
