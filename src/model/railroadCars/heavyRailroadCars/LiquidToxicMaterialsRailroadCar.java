package model.railroadCars.heavyRailroadCars;

import model.cargo.heavyMaterials.HeavyMaterials;
import model.cargo.heavyMaterials.ToxicLiquid;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class LiquidToxicMaterialsRailroadCar extends HeavyRailroadCar implements LoadUnloadCargo<HeavyMaterials> {
    private int levelOfToxicity;
    private int maxTemperature;
    private List<ToxicLiquid> toxicLiquidList = new ArrayList<>();

    public LiquidToxicMaterialsRailroadCar(String name, int railroadCarWeight, int maxLoadWeight, String material,
                                           double maxTimeOfCargoStorageInCar, int levelOfToxicity, int maxTemperature) {
        super(name, railroadCarWeight, maxLoadWeight, material, maxTimeOfCargoStorageInCar);
        this.levelOfToxicity = levelOfToxicity;
        this.maxTemperature = maxTemperature;
    }

    public int getLevelOfToxicity() {
        return levelOfToxicity;
    }

    public int getMaxTemperature() {
        return maxTemperature;
    }

    public List<ToxicLiquid> getCargo() {
        return toxicLiquidList;
    }

    @Override
    public void addCargo(HeavyMaterials cargo) {
        ToxicLiquid toxicLiquid = (ToxicLiquid) cargo;
        if (toxicLiquidList.contains(toxicLiquid)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        toxicLiquidList.add(toxicLiquid);
        setCurrentLoadWeight(getCurrentLoadWeight() + toxicLiquid.getWeight());
        addLoadWeightToLocomotive(toxicLiquid.getWeight());
    }

    @Override
    public void removeCargo(HeavyMaterials cargo) {
        ToxicLiquid toxicLiquid = (ToxicLiquid) cargo;
        if (toxicLiquidList.contains(toxicLiquid)) {
            toxicLiquidList.remove(toxicLiquid);
            setCurrentLoadWeight(getCurrentLoadWeight() - toxicLiquid.getWeight());
            subtractLoadWeightFromLocomotive(toxicLiquid.getWeight());
        }
    }

    @Override
    public String toString() {
        return "LiquidToxicMaterialsRailroadCar: " +
                "\n  id: " + getId() +
                "\n  name: " + getName() +
                "\n  maxLoadWeight: " + getMaxLoadWeight() +
                "\n  currentLoadWeight: " + getCurrentLoadWeight() +
                "\n  material: " + getMaterial() +
                "\n  toxicity of liquid: " + levelOfToxicity +
                "\n  max temperature: " + maxTemperature +
                "\n  toxic liquid list: " + toxicLiquidList +
                "\n  number of liquid toxic materials: " + toxicLiquidList.size();
    }
}
