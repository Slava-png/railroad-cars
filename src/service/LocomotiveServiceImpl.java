package service;

import exception.AddRailroadCarException;
import exception.RemoveRailroadCarException;
import model.locomotive.Locomotive;
import model.railroadCars.RailroadCar;
import model.railroadCars.ElecGridConnection;

import java.util.List;

public class LocomotiveServiceImpl implements LocomotiveService {
    @Override
    public void addRailRoadCar(Locomotive locomotive, RailroadCar railroadCar) {
        if (locomotive.getCurrentLoadWeight() + railroadCar.getCurrentLoadWeight()
                + railroadCar.getRailroadCarWeight() > locomotive.getMaxLoadWeight()) {
            // I do not throw exception because then program stops its execution, instead I print a message
            // throw new AddRailroadCarException("You exceeded your max of railroad cars attached with electrical grid to one locomotive");
            System.out.println("=======Can't add railroad car, because you exceeded your max weight " + locomotive.getMaxLoadWeight()+ "\n========" + railroadCar);
            return;
        } else if (railroadCar instanceof ElecGridConnection) {
            if (locomotive.getCurrentCarsForElectricalGrid() >= locomotive.getMaxCarsForElectricalGrid()) {
                // I do not throw exception because then program stops its execution, instead I print a message
                // throw new AddRailroadCarException("You exceeded your max of railroad cars attached with electrical grid to one locomotive");
                System.out.println("======You exceeded your max of railroad cars attached with electrical grid to one locomotive: \n=======" + locomotive);
                return;
            }
            locomotive.setCurrentCarsForElectricalGrid(locomotive.getCurrentCarsForElectricalGrid() + 1);
        }

        locomotive.setCurrentLoadWeight(locomotive.getCurrentLoadWeight() + railroadCar.getCurrentLoadWeight() + railroadCar.getRailroadCarWeight());
        railroadCar.setLocomotive(locomotive);

        List<RailroadCar> railroadCars = locomotive.getRailroadCars();
        if (railroadCars.size() == 0) { // if railroadCars is empty, we can't attach new car to previous;
            locomotive.addRailroadCar(railroadCar);
            return;
        }
        RailroadCar theLastRailroadCar = railroadCars.get(railroadCars.size() - 1);

        // setting that the old last car will be pointing to new car
        theLastRailroadCar.setNextRailRoadCar(railroadCar);
        // setting that the new last car will be pointing to previous last car
        railroadCar.setPreviousRailroadCar(theLastRailroadCar);
        locomotive.addRailroadCar(railroadCar);
    }

    @Override
    public void removeRailRoadCar(Locomotive locomotive, RailroadCar railroadCar) {
        List<RailroadCar> railroadCars = locomotive.getRailroadCars();

        if (railroadCars.isEmpty()) {
//             I do not throw exception because then program stops its execution, instead I print a message
//            throw new RemoveRailroadCarException("Can't remove railroad car, as no is attached to locomotive");
            System.out.println("==========Can't remove railroad car, as no is attached to locomotive");
            return;
        }

        for (int i = 0; i < railroadCars.size(); i++) {
            if (railroadCars.get(i).getId() == railroadCar.getId()) {
                if (i == 0 && railroadCars.size() == 1) {      // if only one element is in ArrayList
                    locomotive.removeRailroadCar(railroadCar);
                    return;
                } else if (i == 0) {   // deleting connection between first and second
                    railroadCars.get(i + 1).setPreviousRailroadCar(null);
                } else if (i == railroadCars.size() - 1) {  // delete connection between last and one before last
                    railroadCars.get(i - 1).setNextRailRoadCar(null);
                } else {
                    RailroadCar next = railroadCars.get(i + 1);
                    RailroadCar previous = railroadCars.get(i - 1);
                    previous.setNextRailRoadCar(next);
                    next.setPreviousRailroadCar(previous);
                }
                locomotive.removeRailroadCar(railroadCar);
                return;
            }
        }

//        I do not throw exception because then program stops its execution, instead I print a message
//        throw new RemoveRailroadCarException("Can't find railroadCar with id: " + railroadCar.getId() + " in list");
        System.out.println("=========Can't find railroadCar with id: " + railroadCar.getId() + " in list");
    }
}
