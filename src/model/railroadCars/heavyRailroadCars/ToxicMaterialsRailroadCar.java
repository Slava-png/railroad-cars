package model.railroadCars.heavyRailroadCars;

import model.cargo.heavyMaterials.HeavyMaterials;
import model.cargo.heavyMaterials.ToxicMaterials;
import model.railroadCars.LoadUnloadCargo;

import java.util.ArrayList;
import java.util.List;

public class ToxicMaterialsRailroadCar extends HeavyRailroadCar implements LoadUnloadCargo<HeavyMaterials> {
    private int levelOfToxicity;
    private String materialOfContainer;
    private List<ToxicMaterials> toxicMaterialsList = new ArrayList<>();

    public ToxicMaterialsRailroadCar(String name, int railroadCarWeight, int maxLoadWeight, double maxTimeOfCargoStorageInCar,
                                     String material, int levelOfToxicity, String materialOfContainer) {
        super(name, railroadCarWeight, maxLoadWeight, material, maxTimeOfCargoStorageInCar);
        this.levelOfToxicity = levelOfToxicity;
        this.materialOfContainer = materialOfContainer;
    }

    public int getLevelOfToxicity() {
        return levelOfToxicity;
    }

    public String getMaterialOfContainer() {
        return materialOfContainer;
    }

    public List<ToxicMaterials> getCargo() {
        return toxicMaterialsList;
    }

    @Override
    public void addCargo(HeavyMaterials cargo) {
        ToxicMaterials toxicMaterials = (ToxicMaterials) cargo;
        if (toxicMaterialsList.contains(toxicMaterials)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        toxicMaterialsList.add(toxicMaterials);
        setCurrentLoadWeight(getCurrentLoadWeight() + toxicMaterials.getWeight());
        addLoadWeightToLocomotive(toxicMaterials.getWeight());
    }

    @Override
    public void removeCargo(HeavyMaterials cargo) {
        ToxicMaterials toxicMaterials = (ToxicMaterials) cargo;
        if (toxicMaterialsList.contains(toxicMaterials)) {
            toxicMaterialsList.remove(toxicMaterials);
            setCurrentLoadWeight(getCurrentLoadWeight() - toxicMaterials.getWeight());
            subtractLoadWeightFromLocomotive(toxicMaterials.getWeight());
        }
    }

    @Override
    public String toString() {
        return "ToxicMaterialsRailroadCar: " +
                "\n  id: " + getId() +
                "\n  name: " + getName() +
                "\n  maxLoadWeight: " + getMaxLoadWeight() +
                "\n  currentLoadWeight: " + getCurrentLoadWeight() +
                "\n  material: " + getMaterial() +
                "\n  level of toxicity: " + levelOfToxicity +
                "\n  material of container: " + materialOfContainer +
                "\n  toxic materials list: " + toxicMaterialsList +
                "\n  number of toxic materials: " + toxicMaterialsList.size();
    }
}
