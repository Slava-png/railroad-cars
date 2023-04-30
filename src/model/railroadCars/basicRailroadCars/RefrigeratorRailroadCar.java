package model.railroadCars.basicRailroadCars;

import model.cargo.basicMaterials.BasicMaterials;
import model.cargo.basicMaterials.Meat;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class RefrigeratorRailroadCar extends BasicRailroadCar implements LoadUnloadCargo<BasicMaterials> {
    private int temperature;
    private String productType;
    private List<Meat> meatList = new ArrayList<>();

    public RefrigeratorRailroadCar(String name, int railroadCarWeight, int maxLoadWeight, int maxTimeStoredInRailcar,
                                   String material, int temperature, String productType) {
        super(name, railroadCarWeight, maxLoadWeight, material, maxTimeStoredInRailcar);
        this.temperature = temperature;
        this.productType = productType;
    }

    public List<Meat> getMeatList() {
        return meatList;
    }

    public void addMeat(Meat meat) {
        meatList.add(meat);
    }

    public int getTemperature() {
        return temperature;
    }

    public String getProductType() {
        return productType;
    }

    public List<Meat> getCargo() {
        return meatList;
    }

    @Override
    public void addCargo(BasicMaterials cargo) {
        Meat meat = (Meat) cargo;
        if (meatList.contains(meat)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        meatList.add(meat);
        setCurrentLoadWeight(getCurrentLoadWeight() + meat.getWeight());
        addLoadWeightToLocomotive(meat.getWeight());
    }

    @Override
    public void removeCargo(BasicMaterials cargo) {
        Meat meat = (Meat) cargo;
        if (meatList.contains(meat)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        meatList.add(meat);
        setCurrentLoadWeight(getCurrentLoadWeight() + meat.getWeight());
        addLoadWeightToLocomotive(meat.getWeight());
    }

    @Override
    public String toString() {
        return "RefrigeratorRailroadCar: " +
                "\n  id: " + getId() +
                "\n  name: " + getName() +
                "\n  maxLoadWeight: " + getMaxLoadWeight() +
                "\n  currentLoadWeight: " + getCurrentLoadWeight() +
                "\n  material: " + getMaterial() +
                "\n  temperature: " + temperature +
                "\n  product type: " + productType +
                "\n  number of meats: " + meatList.size();
    }
}
