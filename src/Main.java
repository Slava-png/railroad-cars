import menu.MenuImpl;
import model.cargo.Baggage;
import model.cargo.Dish;
import model.cargo.Parcel;
import model.cargo.Passenger;
import model.cargo.basicMaterials.BasicMaterials;
import model.cargo.basicMaterials.Liquid;
import model.cargo.basicMaterials.Meat;
import model.graph.*;
import model.railroadCars.*;
import model.locomotive.Locomotive;
import model.railroadCars.basicRailroadCars.BasicRailroadCar;
import model.railroadCars.basicRailroadCars.LiquidRailroadCar;
import model.railroadCars.basicRailroadCars.RefrigeratorRailroadCar;
import report.WriteReportImpl;
import service.LocomotiveService;
import service.LocomotiveServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // generate all stations
        Graph graph = GraphGenerator.getGraph();

        // menu
        List<Locomotive> locCreatedByMenu = new MenuImpl().menu();

        // create all locomotives
        List<Locomotive> locomotives = new ArrayList<>(locCreatedByMenu);

        Locomotive locomotive1 = new Locomotive( "KM-205", 100, 4100, 190, 5, "Berlin", "Bremen", "Lyon");
        Locomotive locomotive2 = new Locomotive( "RM-995", 125, 4100, 125, 9, "Hamburg", "Stuttgart", "Hague");
        Locomotive locomotive3 = new Locomotive( "IM-489", 163, 4100, 127, 6, "Prague", "Duisburg", "Bologna");
        Locomotive locomotive4 = new Locomotive( "LP-111", 1054, 4100, 182, 8, "Amsterdam", "Riga", "Varna");
        Locomotive locomotive5 = new Locomotive( "TI-236", 123, 4100, 191, 10, "Berlin", "Aarhus", "Cologne");
        Locomotive locomotive6 = new Locomotive( "TY-353", 150, 4100, 182, 23, "Riga", "Amsterdam", "Zagreb");
        Locomotive locomotive7 = new Locomotive( "IX-925", 123, 4100, 179, 7, "Alicante", "Alexandria", "Alicante");
        Locomotive locomotive8 = new Locomotive( "LIO-", 132, 4100, 101, 9, "Amsterdam", "Copenhagen", "Warsaw");
        Locomotive locomotive9 = new Locomotive( "KQW-736", 109, 4100, 184, 11, "Berlin", "Milan", "Berlin");
        Locomotive locomotive10 = new Locomotive( "RIP-2567", 180, 4100, 162, 9, "Hamburg", "Madrid", "Kyiv");
        Locomotive locomotive11 = new Locomotive( "IVO-245", 110, 4100, 148, 4, "Prague", "Alexandria", "Sofia");
        Locomotive locomotive12 = new Locomotive( "WX-", 143, 4100, 161, 6, "Amsterdam", "Dublin", "Istanbul");
        Locomotive locomotive13 = new Locomotive( "KR-426", 120, 4100, 174, 3, "Berlin", "Alexandria", "Odessa");
        Locomotive locomotive14 = new Locomotive( "RRM-765", 170, 4100, 182, 6, "Bucharest", "Zaporizia", "Tirana");
        Locomotive locomotive15 = new Locomotive( "ITI-884", 150, 4100, 167, 2, "Doha", "Baku", "Kaunas");
        Locomotive locomotive16 = new Locomotive( "XY-264", 106, 4100, 172, 7, "Amsterdam", "Bielefeld", "Utrecht");
        Locomotive locomotive17 = new Locomotive( "KTN-865", 123, 4100, 164, 9, "Berlin", "Izmir", "Szczecin");
        Locomotive locomotive18 = new Locomotive( "RGUX-578", 186, 4100, 155, 11, "Hamburg", "Nuremberg", "Poznań");
        Locomotive locomotive19 = new Locomotive( "UBF-654", 146, 4100, 194, 13, "Prague", "Vilnius", "Leipzig");
        Locomotive locomotive20 = new Locomotive( "USZ-878", 171, 4100, 171, 7, "Amsterdam", "Riga", "Mecca");
        Locomotive locomotive21 = new Locomotive( "KRFV-569", 126, 4100, 148, 8, "Berlin", "Lisabon", "Toulouse");
        Locomotive locomotive22 = new Locomotive( "RIS-235", 171, 4100, 139, 8, "Kyiv", "Doha", "Dresden");
        Locomotive locomotive23 = new Locomotive( "IOBQ-456", 134, 4100, 180, 11, "Prague", "Dortmund", "Athens");
        Locomotive locomotive24 = new Locomotive( "IDR-753", 154, 4100, 179, 12, "Amsterdam", "Seville", "Kraków");
        Locomotive locomotive25 = new Locomotive( "TKP-965", 171, 4100, 183, 9, "Prague", "Marseille", "Amsterdam");

        locomotives.add(locomotive1);
        locomotives.add(locomotive2);
        locomotives.add(locomotive3);
        locomotives.add(locomotive4);
        locomotives.add(locomotive5);
        locomotives.add(locomotive6);
        locomotives.add(locomotive7);
        locomotives.add(locomotive8);
        locomotives.add(locomotive9);
        locomotives.add(locomotive10);
        locomotives.add(locomotive11);
        locomotives.add(locomotive12);
        locomotives.add(locomotive13);
        locomotives.add(locomotive14);
        locomotives.add(locomotive15);
        locomotives.add(locomotive16);
        locomotives.add(locomotive17);
        locomotives.add(locomotive18);
        locomotives.add(locomotive19);
        locomotives.add(locomotive20);
        locomotives.add(locomotive21);
        locomotives.add(locomotive22);
        locomotives.add(locomotive23);
        locomotives.add(locomotive24);
        locomotives.add(locomotive25);

        // create railroad cars of all types
        BasicRailroadCar basicRailroadCar = new BasicRailroadCar("2-43", 10, 40, "paper", 20);
        LiquidRailroadCar liquidRailroadCar = new LiquidRailroadCar("w-692", 16, 55, "watercolors", true, 11, "all");
        RefrigeratorRailroadCar refrigeratorRailroadCar = new RefrigeratorRailroadCar("w-65", 18, 32, 12, "food", -5, "meat");
        BaggageRailroadCar baggageRailroadCar = new BaggageRailroadCar("w-43", 8, 11, 200, 100);
        PassengerRailroadCar passengerRailroadCar = new PassengerRailroadCar("w-58", 4, 12, 100, 5, 5);
        PostOfficeRailroadCar postOfficeRailroadCar = new PostOfficeRailroadCar("w-545", 15, 22, 48, true);
        RestaurantRailroadCar restaurantRailroadCar = new RestaurantRailroadCar("w-78", 20, 19, 60, true);

        // add railroad cars to locomotives
        LocomotiveService locomotiveService = new LocomotiveServiceImpl();

        List<RailroadCar> railroadCars = new ArrayList<>();
        railroadCars.add(basicRailroadCar);
        railroadCars.add(liquidRailroadCar);
        railroadCars.add(refrigeratorRailroadCar);
        railroadCars.add(baggageRailroadCar);
        railroadCars.add(passengerRailroadCar);
        railroadCars.add(postOfficeRailroadCar);
        railroadCars.add(restaurantRailroadCar);

        for (Locomotive locomotive : locomotives) {
            for (RailroadCar railroadCar: railroadCars) {
                locomotiveService.addRailRoadCar(locomotive, railroadCar);
            }
        }

        // create cargo to each type of railroad car
        BasicMaterials basicMaterials = new BasicMaterials(20, "paper");
        Liquid liquid = new Liquid(12, "red watercolor", 1200);
        Meat meat = new Meat(15, "Turkey", -2);
        Passenger passenger = new Passenger("John Smith", false, false);
        Baggage baggage = new Baggage(12, passenger, "suitcase");
        Parcel parcel = new Parcel(10, "Warsaw", "Kielce", passenger);
        Dish dish = new Dish("Soup", 600);

        // add cargo to railroad cars
        basicRailroadCar.addCargo(basicMaterials);
        liquidRailroadCar.addCargo(liquid);
        refrigeratorRailroadCar.addCargo(meat);
        baggageRailroadCar.addCargo(baggage);
        passengerRailroadCar.addCargo(passenger);
        postOfficeRailroadCar.addCargo(parcel);
        restaurantRailroadCar.addCargo(dish);

        // Write data to file every file seconds
        Thread writeReport = new WriteReportImpl(locomotives);
        writeReport.start();

        // start all locomotives
        for (Locomotive locomotive : locomotives) {
            locomotive.start();
        }
    }
}
