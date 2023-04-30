package report;

import model.locomotive.Locomotive;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteReportImpl extends Thread implements WriteReport {
    private List<Locomotive> locomotives;
    private static final File FILE = new File(System.getProperty("user.dir" ) + "\\src\\report\\AppState.txt").exists() ?
            new File(System.getProperty("user.dir" ) + "\\src\\report\\AppState.txt") :
            new File(System.getProperty("user.dir" ) + "\\project-railroad-cars\\src\\Statistics\\Statistics.txt");;

    public WriteReportImpl(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    @Override
    public void writeToFile(String report) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(FILE, true))) {
            bf.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Couldn't find file" + FILE, e);
        }
    }

    @Override
    public void run() {
        BuildLocomotiveReport buildLocomotiveReport = new BuildLocomotiveReportImpl();
        while (true) {
            try {
                Thread.sleep(5000);
                writeToFile(buildLocomotiveReport.buildAdvancedReport(locomotives));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
