package model.cargo;

import model.IdGenerator;

public class Dish {
    private int id;
    private String name;
    private int calorieAmount;

    public Dish(String name, int calorieAmount) {
        this.id = IdGenerator.getId();
        this.name = name;
        this.calorieAmount = calorieAmount;
    }

    public String getName() {
        return name;
    }

    public int getCalorieAmount() {
        return calorieAmount;
    }

    @Override
    public String toString() {
        return "    Dish: " +
                "\n      id: " + id +
                "\n      name: " + name +
                "\n      calorie amount: " + calorieAmount;
    }
}

