package model.locomotive;

import model.graph.Edge;
import report.BuildLocomotiveReport;
import report.BuildLocomotiveReportImpl;

import java.util.Random;

public class SpeedRegulatorForLocomotiveImpl extends Thread implements SpeedRegulatorForLocomotive {
    private BuildLocomotiveReport buildLocomotiveReport = new BuildLocomotiveReportImpl();
    private Locomotive locomotive;
    private boolean stillPrinting = true;
    private long timeLocomotiveIsMoving;

    public SpeedRegulatorForLocomotiveImpl(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("SpeedController for " + locomotive.getNAme());
        while (true) {
            if (locomotive.isLocomotiveMoving()) {
                try {
                    Thread.sleep(1000);
                    timeLocomotiveIsMoving++;
                    changeSpeedRandomly();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
            timeLocomotiveIsMoving = 0;
        }
    }

    private void changeSpeedRandomly() {
        // check if locomotive is moving
        if (! locomotive.isLocomotiveMoving()) return;

        int rand = new Random().nextInt(2);

        if (rand == 1) locomotive.setSpeed(locomotive.getSpeed() + locomotive.getSpeed() * 0.03);
        else locomotive.setSpeed(locomotive.getSpeed() - locomotive.getSpeed() * 0.03);

        if (locomotive.getSpeed() > 200 && stillPrinting) {
            System.out.println("======Locomotive " + locomotive.getNAme() + " was moving with speed " + Math.round(locomotive.getSpeed() * 100) / 100
                    + "km/h and RailroadHazard occurred\n" +
                    buildLocomotiveReport.buildBasicReport(locomotive, calculateDistBetweenTwoNearestStation(), calculateDistBetweenStartAndFinish()));
            // message that train exceeded speed of 200km/h won't be printed anymore
            stillPrinting = false;
        }
    }

    @Override
    public double calculateDistBetweenTwoNearestStation() {
        //time which was needed for traveling from station to having a RailroadHazard
        double distanceTraveled = timeLocomotiveIsMoving * locomotive.getSpeed();

        // calculate percentage of route traveled
        return Math.round(distanceTraveled * 10000 / locomotive.getCurrRoute().getWeight()) / 100;
    }

    @Override
    public double calculateDistBetweenStartAndFinish() {
        double distance = 0;
        double traveledDistance = 0;
        boolean isCurrStationChecked = true;

        // calculate path traveled between end and start of route, and between start and curr position of Locomotive
        for (Edge edge: locomotive.getPath()) {
            if (edge.getSource().getName().equals(locomotive.getCurrRoute().getSource().getName()) && isCurrStationChecked){
                traveledDistance += edge.getWeight();
                isCurrStationChecked = false;
            }
            distance += edge.getWeight();
        }

        // calculate percentage of path already traveled
        return Math.round(traveledDistance * 10000 / distance) / 100;
    }
}
