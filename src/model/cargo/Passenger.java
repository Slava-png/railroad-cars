package model.cargo;

import model.IdGenerator;

public class Passenger {
    private int id;
    private String name;
    private boolean pregnant;
    private boolean disabled;

    public Passenger(String name, boolean pregnant, boolean disabled) {
        this.id = IdGenerator.getId();
        this.name = name;
        this.pregnant = pregnant;
        this.disabled = disabled;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "    Passenger: " +
                "\n      id: " + id +
                "\n      name: " + name +
                "\n      pregnant: " + pregnant +
                "\n      disabled: " + disabled;
    }
}
