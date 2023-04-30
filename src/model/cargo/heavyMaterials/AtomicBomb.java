package model.cargo.heavyMaterials;

public class AtomicBomb extends HeavyMaterials {
    private int levelOfExplosiveness;

    public AtomicBomb(int weight, String name, boolean materialInBoxes, int levelOfExplosiveness) {
        super(weight, name, materialInBoxes);
        this.levelOfExplosiveness = levelOfExplosiveness;
    }

    @Override
    public String toString() {
        return "    AtomicBomb: " +
                "\n      id: " + getId() +
                "\n      name: " + getMaterial() +
                "\n      level of explosiveness: " + levelOfExplosiveness;
    }
}
