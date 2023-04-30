package model.cargo.basicMaterials;

public class Meat extends BasicMaterials {
    private int temperatureOfStoring;

    public Meat(int weight, String name, int temperatureOfStoring) {
        super(weight, name);
        this.temperatureOfStoring = temperatureOfStoring;
    }

    public int getTemperatureOfStoring() {
        return temperatureOfStoring;
    }

    @Override
    public String toString() {
        return "    Meat: " +
                "\n      id: " + getId() +
                "\n      name: " + getName() +
                "\n      temperature of storing: " + temperatureOfStoring;
    }
}
