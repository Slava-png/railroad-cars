package model.railroadCars.heavyRailroadCars;

import model.railroadCars.RailroadCar;
import model.cargo.heavyMaterials.HeavyMaterials;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class HeavyRailroadCar extends RailroadCar implements LoadUnloadCargo<HeavyMaterials> {
    private String material;
    private double maxTimeOfCargoStorageInCar;
    private List<HeavyMaterials> heavyMaterialsList = new ArrayList<>();

    public HeavyRailroadCar(String name, int railroadCarWeight, int maxLoadWeight,
                            String material, double maxTimeOfCargoStorageInCar) {
        super(name, railroadCarWeight, maxLoadWeight);
        this.material = material;
        this.maxTimeOfCargoStorageInCar = maxTimeOfCargoStorageInCar;
    }

    public List<? extends HeavyMaterials> getCargo() {
        return heavyMaterialsList;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void addCargo(HeavyMaterials heavyMaterial) {
        if (heavyMaterialsList.contains(heavyMaterial)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        heavyMaterialsList.add(heavyMaterial);
        setCurrentLoadWeight(getCurrentLoadWeight() + heavyMaterial.getWeight());
        addLoadWeightToLocomotive(heavyMaterial.getWeight());
    }

    @Override
    public void removeCargo(HeavyMaterials heavyMaterial) {
        if (heavyMaterialsList.contains(heavyMaterial)) {
            heavyMaterialsList.remove(heavyMaterial);
            setCurrentLoadWeight(getCurrentLoadWeight() - heavyMaterial.getWeight());
            subtractLoadWeightFromLocomotive(heavyMaterial.getWeight());
        }
    }

    @Override
    public String toString() {
        return "HeavyRailroadCar: " +
                super.toString() +
                "\n  material: " + material +
                "\n  number of heavy materials: " + heavyMaterialsList.size();
    }
}
