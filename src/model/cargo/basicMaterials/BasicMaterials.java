package model.cargo.basicMaterials;

import model.cargo.Cargo;

public class BasicMaterials extends Cargo {
    private String name;

    public BasicMaterials(int weight, String name) {
        super(weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "    BasicMaterials: " +
                "\n      id: " + getId() +
                "\n      name: " + name;
    }
}
