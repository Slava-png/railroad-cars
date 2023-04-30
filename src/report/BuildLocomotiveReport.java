package report;

import model.locomotive.Locomotive;

import java.util.List;

public interface BuildLocomotiveReport {
    String buildBasicReport(Locomotive locomotive, double nearestStations, double wholePath);

    String buildAdvancedReport(List<Locomotive> locomotives);
}
