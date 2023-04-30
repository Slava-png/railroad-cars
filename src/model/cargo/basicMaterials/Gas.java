package model.cargo.basicMaterials;

public class Gas extends BasicMaterials {
    private int levelOfExplosiveness;

    public Gas(int weight, String name, int levelOfExplosiveness) {
        super(weight, name);
        this.levelOfExplosiveness = levelOfExplosiveness;
    }

    public int getLevelOfExplosiveness() {
        return levelOfExplosiveness;
    }

    @Override
    public String toString() {
        return "    Gas: " +
                "\n      id: " + getId() +
                "\n      name: " + getName() +
                "\n      level of explosiveness: " + levelOfExplosiveness;
    }
}
