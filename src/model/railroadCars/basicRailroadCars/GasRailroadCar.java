package model.railroadCars.basicRailroadCars;

import model.cargo.basicMaterials.BasicMaterials;
import model.cargo.basicMaterials.Gas;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class GasRailroadCar extends BasicRailroadCar implements LoadUnloadCargo<BasicMaterials> {
    private int maxPressure;
    private String innerCoverOfWalls;
    private List<Gas> gasList = new ArrayList<>();

    public GasRailroadCar(String name, int railroadCarWeight, int maxLoadWeight, int maxTimeStoredInRailcar,
                          String material, int maxPressure, String innerCoverOfWalls) {
        super(name, railroadCarWeight, maxLoadWeight, material, maxTimeStoredInRailcar);
        this.maxPressure = maxPressure;
        this.innerCoverOfWalls = innerCoverOfWalls;
    }

    public int getMaxPressure() {
        return maxPressure;
    }

    public List<Gas> getCargo() {
        return gasList;
    }

    @Override
    public void addCargo(BasicMaterials cargo) {
        Gas gas = (Gas) cargo;
        if (gasList.contains(gas)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        gasList.add(gas);
        setCurrentLoadWeight(getCurrentLoadWeight() + gas.getWeight());
        addLoadWeightToLocomotive(gas.getWeight());
    }

    @Override
    public void removeCargo(BasicMaterials cargo) {
        Gas gas = (Gas) cargo;
        if (gasList.contains(gas)) {
            gasList.remove(gas);
            setCurrentLoadWeight(getCurrentLoadWeight() - gas.getWeight());
            subtractLoadWeightFromLocomotive(gas.getWeight());
        }
    }

    @Override
    public String toString() {
        return "GasRailroadCar: " +
                "\n  id: " + getId() +
                "\n  name: " + getName() +
                "\n  max load weight: " + getMaxLoadWeight() +
                "\n  current load weight: " + getCurrentLoadWeight() +
                "\n  material: " + getMaterial() +
                "\n  max pressure: " + maxPressure +
                "\n  inner cover of walls: " + maxPressure +
                "\n  number of gasses: " + gasList.size();
    }
}
