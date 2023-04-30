package model.cargo.heavyMaterials;

import model.cargo.Cargo;

public class HeavyMaterials extends Cargo {
    private String material;
    private boolean materialInBoxes;

    public HeavyMaterials(int weight, String material, boolean materialInBoxes) {
        super(weight);
        this.material = material;
        this.materialInBoxes = materialInBoxes;
    }

    public String getMaterial() {
        return material;
    }

    public boolean getMaterialInBaggages() {
        return materialInBoxes;
    }

    @Override
    public String toString() {
        return "    HeavyMaterial: " +
                "\n      id: " + getId() +
                "\n      material: " + material +
                "\n      material is in boxes: " + materialInBoxes;
    }
}
