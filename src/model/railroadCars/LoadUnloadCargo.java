package model.railroadCars;

import java.util.List;

public interface LoadUnloadCargo<T> {
    void addCargo(T cargo);
    void removeCargo(T cargo);
}
