package model.railroadCars;

import model.cargo.Passenger;

import java.util.ArrayList;
import java.util.List;

public class PassengerRailroadCar extends RailroadCar implements ElecGridConnection, LoadUnloadCargo<Passenger> {
    private int seatsNumber;
    private int seatsForPregnant;
    private int seatsForDisabled;
    private List<Passenger> passengerList = new ArrayList<>();

    public PassengerRailroadCar(String name, int railroadCarWeight, int maxLoadWeight,
                                int seatsNumber, int seatsForPregnant, int seatsForDisabled) {
        super(name, railroadCarWeight, maxLoadWeight);
        this.seatsNumber = seatsNumber;
        this.seatsForPregnant = seatsForPregnant;
        this.seatsForDisabled = seatsForDisabled;
    }

    @Override
    public List<Passenger> getCargo() {
        return passengerList;
    }

    @Override
    public boolean isElecConnectionStatus() {
        return true;
    }

    @Override
    public void addCargo(Passenger passenger) {
        if (passengerList.contains(passenger)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        passengerList.add(passenger);
    }

    @Override
    public void removeCargo(Passenger passenger) {
        passengerList.remove(passenger);
    }

    @Override
    public String toString() {
        return "PassengerRailroadCar: " +
                super.toString() +
                "\n  seats number: " + seatsNumber +
                "\n  seats for pregnant: " + seatsForPregnant +
                "\n  seats for disabled: " + seatsForDisabled +
                "\n  number of passenger: " + passengerList.size();
    }
}
