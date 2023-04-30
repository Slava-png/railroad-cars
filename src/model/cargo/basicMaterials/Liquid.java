package model.cargo.basicMaterials;

public class Liquid extends BasicMaterials {
    private int densityOfLiquid;

    public Liquid(int weight, String name, int densityOfLiquid) {
        super(weight, name);
        this.densityOfLiquid = densityOfLiquid;
    }

    public int getDensityOfLiquid() {
        return densityOfLiquid;
    }

    @Override
    public String toString() {
        return "    Liquid: " +
                "\n      id: " + getId() +
                "\n      name: " + getName() +
                "\n      density of liquid: " + densityOfLiquid;
    }
}
