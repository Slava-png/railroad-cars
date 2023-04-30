package model.railroadCars.basicRailroadCars;

import model.railroadCars.RailroadCar;
import model.cargo.basicMaterials.BasicMaterials;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class BasicRailroadCar extends RailroadCar implements LoadUnloadCargo<BasicMaterials> {
    private String material;
    private int maxTimeStoredInRailcar;
    private List<BasicMaterials> basicMaterialsList = new ArrayList<>();

    public BasicRailroadCar(String name, int railroadCarWeight, int maxLoadWeight,
                            String material, int maxTimeStoredInRailcar) {
        super(name, railroadCarWeight, maxLoadWeight);
        this.material = material;
        this.maxTimeStoredInRailcar = maxTimeStoredInRailcar;
    }

    public String getMaterial() {
        return material;
    }

    public List<? extends BasicMaterials> getCargo() {
        return basicMaterialsList;
    }

    @Override
    public void addCargo(BasicMaterials basicMaterial) {
        if (basicMaterialsList.contains(basicMaterial)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        basicMaterialsList.add(basicMaterial);
        setCurrentLoadWeight(getCurrentLoadWeight() + basicMaterial.getWeight());
        addLoadWeightToLocomotive(basicMaterial.getWeight());
    }

    @Override
    public void removeCargo(BasicMaterials basicMaterial) {
        if (basicMaterialsList.contains(basicMaterial)) {
            basicMaterialsList.remove(basicMaterial);
            setCurrentLoadWeight(getCurrentLoadWeight() - basicMaterial.getWeight());
            subtractLoadWeightFromLocomotive(basicMaterial.getWeight());
        }
    }

    @Override
    public String toString() {
        return "BasicRailroadCar: " +
                super.toString() +
                "\n  material: " + material +
                "\n max number of days cargo can be in railroad car: " + maxTimeStoredInRailcar +
                "\n  number of basic materials: " + basicMaterialsList.size();
    }
}
