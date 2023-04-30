package model.railroadCars;

import model.cargo.Dish;

import java.util.ArrayList;
import java.util.List;

public class RestaurantRailroadCar extends RailroadCar implements LoadUnloadCargo<Dish>, ElecGridConnection {
    private int maxSeatsNumber;
    private boolean dishService;
    private List<Dish> dishList = new ArrayList<>();

    public RestaurantRailroadCar(String name, int railroadCarWeight, int maxLoadWeight,
                                 int maxSeatsNumber, boolean dishService) {
        super(name, railroadCarWeight, maxLoadWeight);
        this.maxSeatsNumber = maxSeatsNumber;
        this.dishService = dishService;
    }

    @Override
    public List<Dish> getCargo() {
        return dishList;
    }

    @Override
    public boolean isElecConnectionStatus() {
        return true;
    }

    @Override
    public void addCargo(Dish dish) {
        if (dishList.contains(dish)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        dishList.add(dish);
    }

    @Override
    public void removeCargo(Dish dish) {
        dishList.remove(dish);
    }

    @Override
    public String toString() {
        return "RestaurantRailroadCar: " +
                super.toString() +
                "\n  max seats number: " + maxSeatsNumber +
                "\n  number of dishes: " + dishList.size();
    }
}
