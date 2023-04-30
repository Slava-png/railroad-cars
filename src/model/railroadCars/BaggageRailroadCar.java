package model.railroadCars;

import model.cargo.Baggage;

import java.util.ArrayList;
import java.util.List;

public class BaggageRailroadCar extends RailroadCar implements LoadUnloadCargo<Baggage> {
    private int maxSmallLuggageNumber;
    private int maxBigLuggageNumber;
    private List<Baggage> baggageList = new ArrayList<>();

    public BaggageRailroadCar(String name, int railroadCarWeight, int maxLoadWeight,
                              int maxSmallLuggageNumber, int maxBigLuggageNumber) {
        super(name, railroadCarWeight, maxLoadWeight);
        this.maxSmallLuggageNumber = maxSmallLuggageNumber;
        this.maxBigLuggageNumber = maxBigLuggageNumber;
    }

    @Override
    public List<Baggage> getCargo() {
        return baggageList;
    }

    @Override
    public void addCargo(Baggage baggage) {
        if (baggageList.contains(baggage)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        baggageList.add(baggage);
        setCurrentLoadWeight(getCurrentLoadWeight() + baggage.getWeight());
        addLoadWeightToLocomotive(baggage.getWeight());
    }

    @Override
    public void removeCargo(Baggage baggage) {
        if (baggageList.contains(baggage)) {
            baggageList.remove(baggage);
            setCurrentLoadWeight(getCurrentLoadWeight() - baggage.getWeight());
            subtractLoadWeightFromLocomotive(baggage.getWeight());
        }
    }

    @Override
    public String toString() {
        return "BaggageRailroadCar: " +
                super.toString() +
                "\n  max small luggageNumber: " + maxSmallLuggageNumber +
                "\n  max big luggage number: " + maxBigLuggageNumber +
                "\n  number of baggages: " + baggageList.size();
    }
}
