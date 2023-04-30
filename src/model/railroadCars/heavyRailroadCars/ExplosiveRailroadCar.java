package model.railroadCars.heavyRailroadCars;

import model.cargo.heavyMaterials.AtomicBomb;
import model.cargo.heavyMaterials.HeavyMaterials;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class ExplosiveRailroadCar extends HeavyRailroadCar implements LoadUnloadCargo<HeavyMaterials>{
    private int maxStoringTemperature;
    private int levelOfExplosiveness;
    private List<AtomicBomb> atomicBombList = new ArrayList<>();

    public ExplosiveRailroadCar(String name, int railroadCarWeight, int maxLoadWeight, String material,
                                double maxTimeOfCargoStorageInCar, int maxStoringTemperature, int levelOfExplosiveness) {
        super(name, railroadCarWeight, maxLoadWeight, material, maxTimeOfCargoStorageInCar);
        this.maxStoringTemperature = maxStoringTemperature;
        this.levelOfExplosiveness = levelOfExplosiveness;
    }

    public int getMaxStoringTemperature() {
        return maxStoringTemperature;
    }

    public int getLevelOfExplosiveness() {
        return levelOfExplosiveness;
    }

    public List<AtomicBomb> getCargo() {
        return atomicBombList;
    }

    @Override
    public void addCargo(HeavyMaterials cargo) {
        AtomicBomb atomicBomb = (AtomicBomb) cargo;
        if (atomicBombList.contains(atomicBomb)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        atomicBombList.add(atomicBomb);
        setCurrentLoadWeight(getCurrentLoadWeight() + atomicBomb.getWeight());
        addLoadWeightToLocomotive(atomicBomb.getWeight());
    }

    @Override
    public void removeCargo(HeavyMaterials cargo) {
        AtomicBomb atomicBomb = (AtomicBomb) cargo;
        if (atomicBombList.contains(atomicBomb)) {
            atomicBombList.remove(atomicBomb);
            setCurrentLoadWeight(getCurrentLoadWeight() - atomicBomb.getWeight());
            subtractLoadWeightFromLocomotive(atomicBomb.getWeight());
        }
    }

    @Override
    public String toString() {
        return "ExplosiveRailroadCar: " +
                "\n  id: " + getId() +
                "\n  name: " + getName() +
                "\n  maxLoadWeight: " + getMaxLoadWeight() +
                "\n  currentLoadWeight: " + getCurrentLoadWeight() +
                "\n  material: " + getMaterial() +
                "\n  max storing temperature: " + maxStoringTemperature +
                "\n  level of explosiveness: " + levelOfExplosiveness +
                "\n  number of atomic bombs: " + atomicBombList.size();
    }
}
