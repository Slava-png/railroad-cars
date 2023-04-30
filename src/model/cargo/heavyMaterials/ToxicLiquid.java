package model.cargo.heavyMaterials;

public class ToxicLiquid extends HeavyMaterials {
    private int levelOfToxicity;

    public ToxicLiquid(int weight, String material, boolean materialInBoxes, int levelOfToxicity) {
        super(weight, material, materialInBoxes);
        this.levelOfToxicity = levelOfToxicity;
    }

    public int getLevelOfToxicity() {
        return levelOfToxicity;
    }

    @Override
    public String toString() {
        return "    ToxicLiquid: " +
                "\n      id: " + getId() +
                "\n      material: " + getMaterial() +
                "\n      level of toxicity: " + levelOfToxicity;
    }
}
