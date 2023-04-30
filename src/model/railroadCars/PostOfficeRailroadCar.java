package model.railroadCars;


import model.cargo.Parcel;

import java.util.ArrayList;
import java.util.List;

public class PostOfficeRailroadCar extends RailroadCar implements ElecGridConnection, LoadUnloadCargo<Parcel> {
    private static final boolean REQUIRES_GRID_CONNECTION = true;
    private static final int MAX_GROSS_WEIGHT_IN_TONES = 100;
    private double maxWeightOfParcel;
    private boolean animalTransfer;
    private List<Parcel> parcelList = new ArrayList<>();

    public PostOfficeRailroadCar(String name, int railroadCarWeight, int maxLoadWeight,
                                 double maxWeightOfParcel, boolean animalTransfer) {
        super(name, railroadCarWeight, maxLoadWeight);
        this.maxWeightOfParcel = maxWeightOfParcel;
        this.animalTransfer = animalTransfer;
    }

    @Override
    public List<Parcel> getCargo() {
        return parcelList;
    }

    @Override
    public boolean isElecConnectionStatus() {
        return true;
    }

    @Override
    public void addCargo(Parcel parcel) {
        if (parcelList.contains(parcel)) {
            System.out.println("Such baggage is already among added ones");
            return;
        }
        parcelList.add(parcel);
        setCurrentLoadWeight(getCurrentLoadWeight() + parcel.getWeight());
        addLoadWeightToLocomotive(parcel.getWeight());
    }

    @Override
    public void removeCargo(Parcel parcel) {
        if (parcelList.contains(parcel)) {
            parcelList.remove(parcel);
            setCurrentLoadWeight(getCurrentLoadWeight() - parcel.getWeight());
            subtractLoadWeightFromLocomotive(parcel.getWeight());
        }
    }

    @Override
    public String toString() {
        return "PostOfficeRailroadCar: " +
                super.toString() +
                "\n  max weight of parcel: " + maxWeightOfParcel +
                "\n  animal transfer: " + animalTransfer +
                "\n  number of parcels: " + parcelList.size();
    }
}
