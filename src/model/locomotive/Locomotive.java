package model.locomotive;

import model.IdGenerator;
import model.railroadCars.RailroadCar;
import model.graph.Edge;
import model.graph.GraphGenerator;
import model.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class Locomotive extends Thread {
    private int id;
    private String name;
    private double maxLoadWeight;
    private double currentLoadWeight;
    private double locomotiveWeight;
    private volatile double speed;
    private int currentCarsForElectricalGrid;
    private int maxCarsForElectricalGrid;
    private String homeStation;
    private volatile Node departureStation;
    private volatile Node destinationStation;
    private List<RailroadCar> railroadCars = new ArrayList<>();
    private volatile boolean isLocomotiveMoving;
    private List<Edge> path = new ArrayList<>();
    private Edge currRoute;

    public Locomotive(String name, double locomotiveWeight, double maxLoadWeight,
                      double speed, int maxCarsForElectricalGrid, String homeStation,
                      String departureStation, String destinationStation) {
        this.id = IdGenerator.getId();
        this.name = name;
        this.maxLoadWeight = maxLoadWeight;
        this.locomotiveWeight = locomotiveWeight;
        this.speed = speed;
        this.maxCarsForElectricalGrid = maxCarsForElectricalGrid;
        this.homeStation = homeStation;
        this.departureStation = GraphGenerator.getGraph().getNodeByName(departureStation);
        this.destinationStation = GraphGenerator.getGraph().getNodeByName(destinationStation);
    }

    public Locomotive() {}

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNAme() {
        return name;
    }

    public double getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public void addLoadWeightToLocomotive(int weight) {
        currentLoadWeight += weight;
    }

    public void subtractLoadWeightFromLocomotive(int weight) {
        currentLoadWeight -= weight;
    }

    public synchronized void setSpeed(double speed) {
        this.speed = speed;
    }

    public synchronized double getSpeed() {
        return speed;
    }

    public int getMaxCarsForElectricalGrid() {
        return maxCarsForElectricalGrid;
    }

    public void setMaxCarsForElectricalGrid(int maxCarsForElectricalGrid) {
        this.maxCarsForElectricalGrid = maxCarsForElectricalGrid;
    }

    public String getHomeStation() {
        return homeStation;
    }

    public Node getDestinationStation() {
        return destinationStation;
    }

    public Node getDepartureStation() {
        return departureStation;
    }

    public List<RailroadCar> getRailroadCars() {
        return railroadCars;
    }

    public void addRailroadCar(RailroadCar railroadCar) {
        railroadCars.add(railroadCar);
    }

    public void removeRailroadCar(RailroadCar railroadCar) {
        railroadCars.remove(railroadCar);
    }

    public double getCurrentLoadWeight() {
        return currentLoadWeight;
    }

    public void setCurrentLoadWeight(double currentLoadWeight) {
        this.currentLoadWeight = currentLoadWeight;
    }

    public int getCurrentCarsForElectricalGrid() {
        return currentCarsForElectricalGrid;
    }

    public void setCurrentCarsForElectricalGrid(int currentCarsForElectricalGrid) {
        this.currentCarsForElectricalGrid = currentCarsForElectricalGrid;
    }

    public synchronized boolean isLocomotiveMoving() {
        return isLocomotiveMoving;
    }

    public List<Edge> getPath() {
        return path;
    }

    public Edge getCurrRoute() {
        return currRoute;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("Locomotive " + name);

        SpeedRegulatorForLocomotiveImpl speedRegulator = new SpeedRegulatorForLocomotiveImpl(this);
        speedRegulator.start();

        System.out.println("Locomotive " + name + " is on station " + departureStation.getName());

        while (true) {
            path = GraphGenerator.getGraph().getShortestPath(departureStation, destinationStation);

            for (Edge edge: path) {
                currRoute = edge;
                synchronized (edge) {
                    while (true) {
                        // check if railroad is used by a different locomotive
                        if (!edge.isUsedByLocomotive()) {
                            //set the route used by a locomotive
                            edge.setUsedByLocomotive(true);

                            // surround all Thread.sleep() methods in one try-catch block
                            try {
                                isLocomotiveMoving = true;

                                System.out.println("Locomotive " + name + ", is between " + edge.getSource().getName() + " and " + edge.getDestination().getName());
                                // evaluate needed time for traveling between two stations with respect to length of route (weight of edge)
                                // multiply by 600 to make time of traveling a bit longer
                                long timeToTravel = (long) (edge.getWeight() / speed) * 2000;
                                Thread.sleep(timeToTravel);

                                isLocomotiveMoving = false;

                                // check if it's the last station in our path
                                if (edge.getDestination().equals(destinationStation)) {
                                    System.out.println("Locomotive " + name + ", is currently unloading and loading cargo on destination station " + destinationStation.getName());
                                    Thread.sleep(3000);

                                    // change station with themselves, as locomotive is moving back
                                    Node temp = departureStation;
                                    departureStation = destinationStation;
                                    destinationStation = temp;
                                } else {
                                    System.out.println("Locomotive " + name + ", is on station " + edge.getDestination().getName());
                                    Thread.sleep(2000);
                                }
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            // set the route free (other locomotives can use it)
                            edge.setUsedByLocomotive(false);
                            break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxLoadWeight=" + maxLoadWeight +
                ", currentLoadWeight=" + currentLoadWeight +
                ", locomotiveWeight=" + locomotiveWeight +
                ", speed=" + speed +
                ", currentCarsForElectricalGrid=" + currentCarsForElectricalGrid +
                ", maxCarsForElectricalGrid=" + maxCarsForElectricalGrid +
                ", homeStation='" + homeStation + '\'' +
                ", departureStation='" + departureStation + '\'' +
                ", destinationStation='" + destinationStation + '\'' +
                '}';
    }
}
