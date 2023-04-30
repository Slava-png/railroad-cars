import menu.MenuImpl;
import model.cargo.Baggage;
import model.cargo.Dish;
import model.cargo.Parcel;
import model.cargo.Passenger;
import model.cargo.basicMaterials.BasicMaterials;
import model.cargo.basicMaterials.Gas;
import model.cargo.basicMaterials.Liquid;
import model.cargo.basicMaterials.Meat;
import model.cargo.heavyMaterials.AtomicBomb;
import model.cargo.heavyMaterials.HeavyMaterials;
import model.cargo.heavyMaterials.ToxicLiquid;
import model.cargo.heavyMaterials.ToxicMaterials;
import model.graph.Graph;
import model.graph.GraphGenerator;
import model.graph.Node;
import model.locomotive.Locomotive;
import model.railroadCars.BaggageRailroadCar;
import model.railroadCars.PassengerRailroadCar;
import model.railroadCars.PostOfficeRailroadCar;
import model.railroadCars.RestaurantRailroadCar;
import model.railroadCars.basicRailroadCars.BasicRailroadCar;
import model.railroadCars.basicRailroadCars.GasRailroadCar;
import model.railroadCars.basicRailroadCars.LiquidRailroadCar;
import model.railroadCars.basicRailroadCars.RefrigeratorRailroadCar;
import model.railroadCars.heavyRailroadCars.ExplosiveRailroadCar;
import model.railroadCars.heavyRailroadCars.HeavyRailroadCar;
import model.railroadCars.heavyRailroadCars.LiquidToxicMaterialsRailroadCar;
import model.railroadCars.heavyRailroadCars.ToxicMaterialsRailroadCar;
import report.WriteReportImpl;
import service.LocomotiveService;
import service.LocomotiveServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Presentation {
    public static void main(String[] args) {
        Graph graph = GraphGenerator.getGraph();

        // menu
        List<Locomotive> locCreatedByMenu = new MenuImpl().menu();

        // create wagons and add them to list of all locomotives
        List<Locomotive> locomotives = new ArrayList<>(locCreatedByMenu);

        Locomotive locomotive1 = new Locomotive( "KM-205", 100, 4100, 197, 5, "Berlin", "Prague", "Bucharest");
        Locomotive locomotive2 = new Locomotive( "RM-995", 100, 4100, 195, 5, "Hamburg", "Doha", "Kyiv");
        Locomotive locomotive3 = new Locomotive( "IM-489", 100, 4100, 195, 5, "Prague", "Alexandria", "Alicante");
        Locomotive locomotive4 = new Locomotive( "LP-111", 100, 4100, 195, 5, "Amsterdam", "Riga", "Varna");
        locomotives.add(locomotive1);
        locomotives.add(locomotive2);
        locomotives.add(locomotive3);
        locomotives.add(locomotive4);

        // create railroad cars of all types
        BasicRailroadCar basicRailroadCar = new BasicRailroadCar("2-43", 10, 40, "paper", 20);
        GasRailroadCar gasRailroadCar = new GasRailroadCar("w-54", 12, 44, 14, "gas", 100000, "Hydro-isolation");
        LiquidRailroadCar liquidRailroadCar = new LiquidRailroadCar("w-692", 16, 55, "watercolors", true, 11, "all");
        RefrigeratorRailroadCar refrigeratorRailroadCar = new RefrigeratorRailroadCar("w-65", 18, 32, 12, "food", -5, "meat");
        ExplosiveRailroadCar explosiveRailroadCar = new ExplosiveRailroadCar("w-233", 18, 55, "Atomic Bombs", 15, 20, 8);
        HeavyRailroadCar heavyRailroadCar = new HeavyRailroadCar("w-89", 21, 44, "metal", 25);
        LiquidToxicMaterialsRailroadCar liquidToxicMaterialsRailroadCar = new LiquidToxicMaterialsRailroadCar("w-56", 43, 32, "Toxic liquids", 15, 8, 20);
        ToxicMaterialsRailroadCar toxicMaterialsRailroadCar = new ToxicMaterialsRailroadCar("w-12", 32, 54, 12, "Toxic materials", 6, "Radiation protection coverage");
        BaggageRailroadCar baggageRailroadCar = new BaggageRailroadCar("w-43", 8, 11, 200, 100);
        PassengerRailroadCar passengerRailroadCar = new PassengerRailroadCar("w-58", 4, 12, 100, 5, 5);
        PostOfficeRailroadCar postOfficeRailroadCar = new PostOfficeRailroadCar("w-545", 15, 22, 48, true);
        RestaurantRailroadCar restaurantRailroadCar = new RestaurantRailroadCar("w-78", 23, 19, 60, true);

        // create cargo to each type of railroad car
        BasicMaterials basicMaterials = new BasicMaterials(20, "paper");
        Gas gas = new Gas(22, "metan", 6);
        Liquid liquid = new Liquid(12, "red watercolor", 1200);
        Meat meat = new Meat(15, "Turkey", -2);
        AtomicBomb atomicBomb = new AtomicBomb(30, "B-52", true, 9);
        HeavyMaterials heavyMaterials = new HeavyMaterials(33, "metal", true);
        ToxicLiquid toxicLiquid = new ToxicLiquid(29, "chemical liquid", true, 6);
        ToxicMaterials toxicMaterials = new ToxicMaterials(22, "uranium", true, 10);
        Passenger passenger = new Passenger("John Smith", false, false);
        Baggage baggage = new Baggage(12, passenger, "suitcase");
        Parcel parcel = new Parcel(10, "Warsaw", "Kielce", passenger);
        Dish dish = new Dish("Soup", 600);

        // add railroad cars to locomotives
        LocomotiveService locomotiveService = new LocomotiveServiceImpl();
        locomotiveService.addRailRoadCar(locomotive1, basicRailroadCar);
        locomotiveService.addRailRoadCar(locomotive2, gasRailroadCar);
        locomotiveService.addRailRoadCar(locomotive3, liquidRailroadCar);
        locomotiveService.addRailRoadCar(locomotive4, refrigeratorRailroadCar);
        locomotiveService.addRailRoadCar(locomotive1, explosiveRailroadCar);
        locomotiveService.addRailRoadCar(locomotive2, heavyRailroadCar);
        locomotiveService.addRailRoadCar(locomotive3, liquidToxicMaterialsRailroadCar);
        locomotiveService.addRailRoadCar(locomotive4, toxicMaterialsRailroadCar);
        locomotiveService.addRailRoadCar(locomotive1, baggageRailroadCar);
        locomotiveService.addRailRoadCar(locomotive2, passengerRailroadCar);
        locomotiveService.addRailRoadCar(locomotive3, postOfficeRailroadCar);
        locomotiveService.addRailRoadCar(locomotive4, restaurantRailroadCar);

        // add cargo to railroad cars
        basicRailroadCar.addCargo(basicMaterials);
        gasRailroadCar.addCargo(gas);
        liquidRailroadCar.addCargo(liquid);
        refrigeratorRailroadCar.addCargo(meat);
        explosiveRailroadCar.addCargo(atomicBomb);
        heavyRailroadCar.addCargo(heavyMaterials);
        liquidToxicMaterialsRailroadCar.addCargo(toxicLiquid);
        toxicMaterialsRailroadCar.addCargo(toxicMaterials);
        baggageRailroadCar.addCargo(baggage);
        passengerRailroadCar.addCargo(passenger);
        postOfficeRailroadCar.addCargo(parcel);
        restaurantRailroadCar.addCargo(dish);

        // remove cargo to railroad cars
        basicRailroadCar.removeCargo(basicMaterials);
        gasRailroadCar.removeCargo(gas);
        liquidRailroadCar.removeCargo(liquid);
        refrigeratorRailroadCar.removeCargo(meat);
        explosiveRailroadCar.removeCargo(atomicBomb);
        heavyRailroadCar.removeCargo(heavyMaterials);
        liquidToxicMaterialsRailroadCar.removeCargo(toxicLiquid);
        toxicMaterialsRailroadCar.removeCargo(toxicMaterials);
        baggageRailroadCar.removeCargo(baggage);
        passengerRailroadCar.removeCargo(passenger);
        postOfficeRailroadCar.removeCargo(parcel);
        restaurantRailroadCar.removeCargo(dish);

        // remove railroad cars to locomotives
        locomotiveService.removeRailRoadCar(locomotive1, basicRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive2, gasRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive3, liquidRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive4, refrigeratorRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive1, explosiveRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive2, heavyRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive3, liquidToxicMaterialsRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive4, toxicMaterialsRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive1, baggageRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive2, passengerRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive3, postOfficeRailroadCar);
        locomotiveService.removeRailRoadCar(locomotive4, restaurantRailroadCar);

        // Write data to file every file seconds
        Thread writeReport = new WriteReportImpl(locomotives);
        writeReport.start();

        // add station to graph (with name of station, or with already created station)
        GraphGenerator.getGraph().addNode("Luhansk");
        GraphGenerator.getGraph().addNode(new Node("Donetsk"));

        // add railroad to graph
        GraphGenerator.getGraph().addEdge("Luhansk", "Donetsk", 823);

        // start locomotives
        locomotive1.start();
        locomotive2.start();
        locomotive3.start();
        locomotive4.start();
    }
}

