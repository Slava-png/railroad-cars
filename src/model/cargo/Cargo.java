package model.cargo;

import model.IdGenerator;

public abstract class Cargo {
    private int id;
    private int weight;

    public Cargo(int weight) {
        this.id = IdGenerator.getId();
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
