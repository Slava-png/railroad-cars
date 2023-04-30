package menu;

import model.locomotive.Locomotive;

import java.util.List;

public interface Menu {
    List<Locomotive> menu();

    void createLocomotive();

    void removeLocomotive();

    void createWagon();

    void removeWagon();

    void createCargo();

    void removeCargo();

    void createStation();

    void removeStation();

    void createRailroad();

    void removeRailroad();

    void exitProgram();
}
