package model.railroadCars;

import model.IdGenerator;
import model.locomotive.Locomotive;

import java.util.List;

public abstract class RailroadCar {
    private int id;
    private String name;
    private final int railroadCarWeight;
    private final int maxLoadWeight;
    private int currentLoadWeight;
    private Locomotive locomotive;
    private RailroadCar previousRailroadCar;
    private RailroadCar nextRailRoadCar;

    public RailroadCar(String name, int railroadCarWeight, int maxLoadWeight) {
        this.id = IdGenerator.getId();
        this.name = name;
        this.railroadCarWeight = railroadCarWeight;
        this.maxLoadWeight = maxLoadWeight;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRailroadCarWeight() {
        return railroadCarWeight;
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public void addLoadWeightToLocomotive(int weight) {
        locomotive.addLoadWeightToLocomotive(weight);
    }

    public void subtractLoadWeightFromLocomotive(int weight) {
        locomotive.subtractLoadWeightFromLocomotive(weight);
    }

    public RailroadCar getPreviousRailroadCar() {
        return previousRailroadCar;
    }

    public void setPreviousRailroadCar(RailroadCar previousRailroadCar) {
        this.previousRailroadCar = previousRailroadCar;
    }

    public RailroadCar getNextRailRoadCar() {
        return nextRailRoadCar;
    }

    public void setNextRailRoadCar(RailroadCar nextRailRoadCar) {
        this.nextRailRoadCar = nextRailRoadCar;
    }

    public int getCurrentLoadWeight() {
        return currentLoadWeight;
    }

    public void setCurrentLoadWeight(int currentLoadWeight) {
        this.currentLoadWeight = currentLoadWeight;
    }

    public abstract List getCargo();


    @Override
    public String toString() {
        return  "\n  id: " + id +
                "\n name: " + name +
                "\n  max load weight: " + maxLoadWeight +
                "\n  current load weight: " + currentLoadWeight;
    }
}
