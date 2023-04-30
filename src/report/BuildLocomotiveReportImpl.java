package report;

import model.railroadCars.RailroadCar;
import model.locomotive.Locomotive;
import model.locomotive.SpeedRegulatorForLocomotiveImpl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildLocomotiveReportImpl implements BuildLocomotiveReport {
    @Override
    public String buildBasicReport(Locomotive locomotive, double nearestStations, double wholePath) {
        StringBuilder report = new StringBuilder();

        report.append("========START OF REPORT========\n");

        // add info about locomotive
        report.append(getLocomotiveReport(locomotive))
                .append("\n  percent of route traveled between two nearest stations: ")
                .append(nearestStations)
                .append("\n  percent of route traveled from the whole path: ")
                .append(wholePath);

        // add info about railroad cars
        locomotive.getRailroadCars().forEach(e -> report.append("\n").append(e));

        report.append("\n========END OF REPORT========");

        return report.toString();
    }

    @Override
    public String buildAdvancedReport(List<Locomotive> locomotives) {
        SpeedRegulatorForLocomotiveImpl speedRegulatorForLocomotive = new SpeedRegulatorForLocomotiveImpl(locomotives.get(1));
        Map<String, Double> speedOfLocomotivesMap = new HashMap<>();
        StringBuilder report = new StringBuilder();

        // save calculateDistBetweenStartAndFinish for every locomotive
        for (Locomotive locomotive: locomotives) {
            speedRegulatorForLocomotive.setLocomotive(locomotive);
            speedOfLocomotivesMap.put(locomotive.getNAme(), speedRegulatorForLocomotive.calculateDistBetweenStartAndFinish());
        }

        // sort locomotives in descending order by percentage of route they traveled
        locomotives.sort(new Comparator<Locomotive>() {
            @Override
            public int compare(Locomotive first, Locomotive second) {
                if (speedOfLocomotivesMap.get(first.getNAme()) == speedOfLocomotivesMap.get(second.getNAme())) return 0;
                else if (speedOfLocomotivesMap.get(first.getNAme()) <= speedOfLocomotivesMap.get(second.getNAme()))
                    return 1;
                else return -1;
            }
        });

        // comparator for sorting railroad cars in ascending order
        Comparator<RailroadCar> railroadCarComparator = new Comparator<RailroadCar>() {
            @Override
            public int compare(RailroadCar first, RailroadCar second) {
                if (first.getCurrentLoadWeight() == second.getCurrentLoadWeight()) return 0;
                else if (first.getCurrentLoadWeight() >= second.getCurrentLoadWeight()) return 1;
                else return -1;
            }
        };


        report.append("========START OF REPORT========");

        for (Locomotive locomotive: locomotives) {
            // add info about locomotive
            report.append("\n").append(getLocomotiveReport(locomotive))
                    .append("\n").append("  Route locomotive travelled from start to end: ")
                    .append(speedOfLocomotivesMap.get(locomotive.getNAme()));

            List<RailroadCar> railroadCars = locomotive.getRailroadCars();
            railroadCars.sort(railroadCarComparator);

            // add info about railroad cars
            for (RailroadCar railroadCar: railroadCars) {
                report.append("\n").append(railroadCar)
                        .append("\n").append("  Cargo list: ");
                List cargo = railroadCar.getCargo();

                for (int i = 0; i < cargo.size(); i++) {
                    report.append("\n").append(cargo.get(i));
                }
            }
        }
        report.append("\n========END OF REPORT========\n\n\n");

        return report.toString();
    }

    public String getLocomotiveReport(Locomotive locomotive) {
        return "Locomotive: " + "\n" +
                "  name: " + locomotive.getNAme() + "\n" +
                "  id: " + locomotive.getID() + "\n" +
                "  departure station: " + locomotive.getDepartureStation() + "\n" +
                "  destination station: " + locomotive.getDestinationStation() + "\n" +
                "  home station: " + locomotive.getHomeStation() + "\n" +
                "  max load weight: " + locomotive.getMaxLoadWeight() + "\n" +
                "  current load weight: " + locomotive.getCurrentLoadWeight() + "\n" +
                "  speed: " + locomotive.getSpeed();
    }
}
