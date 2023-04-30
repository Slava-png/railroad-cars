package model.railroadCars.basicRailroadCars;

import model.cargo.basicMaterials.BasicMaterials;
import model.cargo.basicMaterials.Liquid;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class LiquidRailroadCar extends BasicRailroadCar implements LoadUnloadCargo<BasicMaterials> {
    private boolean temperatureRegulator;
    private String allowedTypesOfLiquids;
    private List<Liquid> liquidList = new ArrayList<>();

    public LiquidRailroadCar(String name, int railroadCarWeight, int maxLoadWeight, String material, boolean temperatureRegulator,
                             int maxTimeStoredInRailcar, String allowedTypesOfLiquids) {
        super(name, railroadCarWeight, maxLoadWeight, material, maxTimeStoredInRailcar);
        this.temperatureRegulator = temperatureRegulator;
        this.allowedTypesOfLiquids = allowedTypesOfLiquids;
    }

    public boolean isTemperatureRegulator() {
        return temperatureRegulator;
    }

    public String getAllowedTypesOfLiquids() {
        return allowedTypesOfLiquids;
    }

    public List<Liquid> getCargo() {
        return liquidList;
    }

    @Override
    public void addCargo(BasicMaterials cargo) {
        Liquid liquid = (Liquid) cargo;
        if (liquidList.contains(liquid)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        liquidList.add(liquid);
        setCurrentLoadWeight(getCurrentLoadWeight() + liquid.getWeight());
        addLoadWeightToLocomotive(liquid.getWeight());
    }

    @Override
    public void removeCargo(BasicMaterials cargo) {
        Liquid liquid = (Liquid) cargo;
        if (liquidList.contains(liquid)) {
            liquidList.remove(liquid);
            setCurrentLoadWeight(getCurrentLoadWeight() - liquid.getWeight());
            subtractLoadWeightFromLocomotive(liquid.getWeight());
        }
    }

    @Override
    public String toString() {
        return "LiquidRailroadCar: " +
                "\n  id: " + getId() +
                "\n  name: " + getName() +
                "\n  maxLoadWeight: " + getMaxLoadWeight() +
                "\n  currentLoadWeight: " + getCurrentLoadWeight() +
                "\n  material: " + getMaterial() +
                "\n  temperature regulator: " + temperatureRegulator +
                "\n  allowed types of liquid: " + allowedTypesOfLiquids +
                "\n  number of liquids: " + liquidList.size();
    }
}
