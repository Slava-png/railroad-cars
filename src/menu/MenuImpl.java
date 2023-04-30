package menu;

import model.graph.Edge;
import model.graph.GraphGenerator;
import model.graph.Node;
import model.railroadCars.RailroadCar;
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
import service.LocomotiveService;
import service.LocomotiveServiceImpl;

import java.util.*;

public class MenuImpl implements Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private LocomotiveService locomotiveService = new LocomotiveServiceImpl();
    private List<Locomotive> locomotives = new ArrayList<>();

    @Override
    public List<Locomotive> menu() {
        System.out.println("=======================================");
        System.out.println("Available options:\n" +
                "Create locomotive -> cl\n" +
                "Remove locomotive -> rl\n" +
                "Create wagon -> cw\n" +
                "Remove wagon -> rw\n" +
                "Create cargo -> cc\n" +
                "Remove cargo -> rc\n" +
                "Create station -> cs\n" +
                "Remove station -> rs\n" +
                "Create railroad -> cr\n" +
                "Remove railroad -> rr\n" +
                "Exit menu -> ex\n" +
                "Stop program -> st");

        System.out.print("Choose letter combination for running command: ");
        String letters = scanner.next();

        switch (letters) {
            case "cl" -> createLocomotive();
            case "rl" -> removeLocomotive();
            case "cw" -> createWagon();
            case "rw" -> removeWagon();
            case "cc" -> createCargo();
            case "rc" -> removeCargo();
            case "cs" -> createStation();
            case "rs" -> removeStation();
            case "cr" -> createRailroad();
            case "rr" -> removeRailroad();
            case "ex" -> {
                return locomotives;
            }
            case "st" -> exitProgram();
            default -> menu();
        }

        return locomotives;
    }

    @Override
    public void createLocomotive() {
        System.out.print("Locomotive name: ");
        String name = scanner.next();
        System.out.print("Max load weight (in tons): ");
        double maxLoadWeight = scanner.nextDouble();
        System.out.print("Weight of locomotive (in tons): ");
        double locWeight = scanner.nextDouble();
        System.out.print("Speed km/h: ");
        double speed = scanner.nextDouble();
        System.out.print("Max railroad cars for electrical grid: ");
        int maxElecGrid = scanner.nextInt();
        printAllStations();
        System.out.print("Home station: ");
        String homeStation = scanner.next();
        System.out.print("Departure station: ");
        String departureStation = scanner.next();
        System.out.print("Destination station: ");
        String destinationStation = scanner.next();

        if (GraphGenerator.getGraph().getNodeByName(homeStation) != null && GraphGenerator.getGraph().getNodeByName(destinationStation) != null
                  && GraphGenerator.getGraph().getNodeByName(departureStation) != null) {
            Locomotive loc = new Locomotive(name,locWeight, maxLoadWeight, speed, maxElecGrid, homeStation, departureStation, destinationStation);
            locomotives.add(loc);
        } else {
            System.out.println("Incorrect data input. Try again");
        }

        menu();
    }

    @Override
    public void removeLocomotive() {
        Locomotive locomotive = getLocomotiveFromConsoleByName("Choose locomotive by name: ");
        locomotives.remove(locomotive);

        menu();
    }

    private Locomotive getLocomotiveFromConsoleByName(String message) {
        if (locomotives.size() == 0) {
            System.out.println("You don't have any locomotives");
            menu();
        }

        for (Locomotive locomotive : locomotives) {
            System.out.println(locomotive.getNAme());
        }
        System.out.print(message);
        String loc = scanner.next();
        Locomotive locom = null;

        for (Locomotive locomotive : locomotives) {
            if (locomotive.getNAme().equals(loc)) {
                locom = locomotive;
            }
        }
        if (locom == null) {
            System.out.println("Your input data is incorrect");
            menu();
        }
        return locom;
    }

    @Override
    public void createWagon() {
        Locomotive locomotive = getLocomotiveFromConsoleByName("Choose locomotive to which railroad car will be added: ");

        System.out.println("Basic railroad car -> bas" +
                "\nGas railroad car -> gas" +
                "\nLiquid railroad car -> liq" +
                "\nRefrigerator railroad car -> ref" +
                "\nExplosive railroad car -> exp" +
                "\nHeavy railroad car -> hev" +
                "\nLiquid toxic railroad car -> toxliq" +
                "\nToxic material railroad car -> toxmat" +
                "\nBaggage railroad car -> bag" +
                "\nPassenger railroad car -> pas" +
                "\nPostoffice railroad car -> post" +
                "\nRestaurant railroad car -> rest");

        System.out.print("Choose letter combination for creating a wagon: ");
        String wagonType = scanner.next();

        switch (wagonType) {
            case "gas" -> locomotiveService.addRailRoadCar(locomotive, createGasRailroadCar());
            case "bas" -> locomotiveService.addRailRoadCar(locomotive, createBasicRailroadCar());
            case "liq" -> locomotiveService.addRailRoadCar(locomotive, createLiquidRailroadCar());
            case "ref" -> locomotiveService.addRailRoadCar(locomotive, createRefrigeratorRailroadCar());
            case "hev" -> locomotiveService.addRailRoadCar(locomotive, createHeavyRailroadCar());
            case "exp" -> locomotiveService.addRailRoadCar(locomotive, createExplosiveRailroadCar());
            case "toxliq" -> locomotiveService.addRailRoadCar(locomotive, createLiquidToxicRailroadCar());
            case "toxmat" -> locomotiveService.addRailRoadCar(locomotive, createToxicMaterialsRailroadCar());
            case "bag" -> locomotiveService.addRailRoadCar(locomotive, createBaggageRailroadCar());
            case "pas" -> locomotiveService.addRailRoadCar(locomotive, createPassengerRailroadCar());
            case "post" -> locomotiveService.addRailRoadCar(locomotive, createPostOfficeRailroadCar());
            case "rest" -> locomotiveService.addRailRoadCar(locomotive, createRestaurantRailroadCar());
            default -> createWagon();
        }
        menu();
    }

    private GasRailroadCar createGasRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();
        System.out.print("Max pressure (kilo-pascals): ");
        int maxPressure = scanner.nextInt();
        System.out.print("Inner cover of walls of railroad car: ");
        String inner = scanner.nextLine();

        System.out.println("Gas railroad car was added");

        return new GasRailroadCar(name, carWeight, maxLoadWeight, maxTime, material, maxPressure, inner);
    }

    private BasicRailroadCar createBasicRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();

        System.out.println("Basic railroad car was added");

        return new BasicRailroadCar(name, carWeight, maxLoadWeight, material, maxTime);
    }

    private LiquidRailroadCar createLiquidRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Temperature regulator (true/false): ");
        boolean tempReg = scanner.nextBoolean();
        System.out.print("Allowed types of liquid: ");
        String liquidTypes = scanner.nextLine();
        System.out.print("Material: ");
        String material = scanner.next();

        System.out.println("Liquid railroad car was added");

        return new LiquidRailroadCar(name, carWeight, maxLoadWeight, material, tempReg, maxTime, liquidTypes);
    }

    private RefrigeratorRailroadCar createRefrigeratorRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();
        System.out.print("Temperature of refrigerator (in degrees C): ");
        int temperature = scanner.nextInt();
        System.out.print("Product type: ");
        String productType = scanner.nextLine();

        System.out.println("Refrigerator railroad car was added");

        return new RefrigeratorRailroadCar(name, carWeight, maxLoadWeight, maxTime, material, temperature, productType);
    }

    private HeavyRailroadCar createHeavyRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();

        System.out.println("Heavy railroad car was added");

        return new HeavyRailroadCar(name, carWeight, maxLoadWeight, material, maxTime);
    }

    private ExplosiveRailroadCar createExplosiveRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weigh (in tons)t: ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();
        System.out.print("Max storing temperature (in degrees C): ");
        int maxTemp = scanner.nextInt();
        System.out.print("Level of explosiveness (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Explosive railroad car was added");

        return new ExplosiveRailroadCar(name, carWeight, maxLoadWeight, material, maxTime, maxTemp, level);
    }

    private LiquidToxicMaterialsRailroadCar createLiquidToxicRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();
        System.out.print("Max storing temperature (in degrees C): ");
        int maxTemp = scanner.nextInt();
        System.out.print("Level of toxicity (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.print("Liquid toxic railroad car was added");

        return new LiquidToxicMaterialsRailroadCar(name, carWeight, maxLoadWeight, material, maxTime, maxTemp, level);
    }

    private ToxicMaterialsRailroadCar createToxicMaterialsRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max time cargo can be stored in wagon (in days): ");
        int maxTime = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();
        System.out.print("Inner cover of walls of railroad car: ");
        String inner = scanner.next();
        System.out.print("Level of toxicity (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Toxic materials railroad car was added");

        return new ToxicMaterialsRailroadCar(name, carWeight, maxLoadWeight, maxTime, material, level, inner);
    }

    private BaggageRailroadCar createBaggageRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max number of small luggage: ");
        int maxOfSmall = scanner.nextInt();
        System.out.print("Max number of big luggage: ");
        int maxOfBig = scanner.nextInt();


        System.out.println("Baggage railroad car was added");

        return new BaggageRailroadCar(name, carWeight, maxLoadWeight, maxOfSmall, maxOfBig);
    }

    private PassengerRailroadCar createPassengerRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Number of seats: ");
        int numberOfSeats = scanner.nextInt();
        System.out.print("Number of seats for disabled: ");
        int disabled = scanner.nextInt();
        System.out.print("Number of seats for pregnant: ");
        int pregnant = scanner.nextInt();

        System.out.println("Passenger railroad car was added");

        return new PassengerRailroadCar(name, carWeight, maxLoadWeight, numberOfSeats, pregnant, disabled);
    }

    private PostOfficeRailroadCar createPostOfficeRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max weight of parcel: ");
        double maxWeight = scanner.nextDouble();
        System.out.print("Animal transfer (true/false): ");
        boolean animals = scanner.nextBoolean();

        System.out.println("Post office railroad car was added");

        return new PostOfficeRailroadCar(name, carWeight, maxLoadWeight, maxWeight, animals);
    }

    private RestaurantRailroadCar createRestaurantRailroadCar() {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Railroad car weight (in tons): ");
        int carWeight = scanner.nextInt();
        System.out.print("Max load weight (in tons): ");
        int maxLoadWeight = scanner.nextInt();
        System.out.print("Max number of seats: ");
        int maxSeats = scanner.nextInt();
        System.out.print("Dish service (true/false): ");
        boolean dishService = scanner.nextBoolean();

        System.out.println("Restaurant railroad car was added");

        return new RestaurantRailroadCar(name, carWeight, maxLoadWeight, maxSeats, dishService);
    }

    @Override
    public void removeWagon() {
        Locomotive locomotive = getLocomotiveFromConsoleByName("Choose locomotive from which railroad car must be removed: ");

        if (locomotive.getRailroadCars().isEmpty()) {
            System.out.println("Locomotive " + locomotive.getNAme() + " has no railroad cars attached to it");
            menu();
        }

        for (RailroadCar railroadCar: locomotive.getRailroadCars()) {
            System.out.println(railroadCar.getName());
        }

        System.out.println("Choose railroad car which must be removed: ");
        String toRemove = scanner.next();
        RailroadCar car = null;

        for (RailroadCar railroadCar : locomotive.getRailroadCars()) {
            if (railroadCar.getName().equals(toRemove)) {
                car = railroadCar;
                break;
            }
        }

        if (car != null) {
            locomotiveService.removeRailRoadCar(locomotive, car);
        } else {
            System.out.println("Incorrect input data. Try again");
        }
        menu();
    }

    @Override
    public void createCargo() {
        Locomotive locomotive = getLocomotiveFromConsoleByName("Choose locomotive to which cargo will be added: ");

        System.out.println("List of railroad cars attached to locomotive " + locomotive.getNAme() + ":");
        for (RailroadCar railroadCar: locomotive.getRailroadCars()) {
            System.out.println(railroadCar.getName());
        }

        System.out.print("Choose to which railroad car cargo will be added: ");
        String inputCar = scanner.next();
        RailroadCar car = null;

        for (RailroadCar railroadCar : locomotive.getRailroadCars()) {
            if (railroadCar.getName().equals(inputCar)) {
                car = railroadCar;
                break;
            }
        }
        if (car == null) {
            System.out.println("Incorrect input data. Try again");
            menu();
        }

        switch (car.getClass().toString()) {
            case "class model.railroadCars.BaggageRailroadCar" -> createBaggageCargo((BaggageRailroadCar) car);
            case "class model.railroadCars.PassengerRailroadCar" -> createPassengerCargo((PassengerRailroadCar) car);
            case "class model.railroadCars.PostOfficeRailroadCar" -> createParcelCargo((PostOfficeRailroadCar) car);
            case "class model.railroadCars.RestaurantRailroadCar" -> createDishCargo((RestaurantRailroadCar) car);
            case "class model.railroadCars.HeavyRailroadCar" -> createHeavyMaterialsCargo((HeavyRailroadCar) car);
            case "class model.railroadCars.ExplosiveRailroadCar" -> createAtomicBombCargo((ExplosiveRailroadCar) car);
            case "class model.railroadCars.LiquidToxicMaterialsRailroadCar" -> createToxicLiquidCargo((LiquidToxicMaterialsRailroadCar) car);
            case "class model.railroadCars.ToxicMaterialsRailroadCar" -> createToxicMaterialsCargo((ToxicMaterialsRailroadCar) car);
            case "class model.railroadCars.BasicRailroadCar" -> createBasicMaterialsCargo((BasicRailroadCar) car);
            case "class model.railroadCars.GasRailroadCar" -> createGasCargo((GasRailroadCar) car);
            case "class model.railroadCars.LiquidRailroadCar" -> createLiquidCargo((LiquidRailroadCar) car);
            case "class model.railroadCars.RefrigeratorRailroadCar" -> createMeatCargo((RefrigeratorRailroadCar) car);
        }
        menu();
    }

    private void createBaggageCargo(BaggageRailroadCar baggageRailroadCar) {
        System.out.print("Weight of baggage (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Baggage type: ");
        String bagType = scanner.next();
        System.out.println("Fill the data regarding the person who owns baggage: ");
        System.out.print("Name: ");
        String name = scanner.next();

        System.out.println("Baggage was successfully added");

        baggageRailroadCar.addCargo(new Baggage(weight, new Passenger(name, false, false), bagType));
    }

    private void createDishCargo(RestaurantRailroadCar restaurantRailroadCar) {
        System.out.print("Name of dish: ");
        String name = scanner.next();
        System.out.print("Amount of calories: ");
        int calories = scanner.nextInt();

        System.out.print("Dish was successfully added");

        restaurantRailroadCar.addCargo(new Dish(name, calories));
    }

    private void createParcelCargo(PostOfficeRailroadCar postOfficeRailroadCar) {
        System.out.print("Weight of parcel (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("From where parcel is sent: ");
        String from = scanner.next();
        System.out.print("To where parcel is sent: ");
        String to = scanner.next();
        System.out.println("Fill the data regarding the person who sends parcel: ");
        System.out.print("Name: ");
        String name = scanner.next();

        System.out.println("Parcel was successfully added");

        postOfficeRailroadCar.addCargo(new Parcel(weight, from, to, new Passenger(name, false, false)));
    }

    private void createPassengerCargo(PassengerRailroadCar passengerRailroadCar) {
        System.out.print("Name: ");
        String name = scanner.next();
        System.out.print("Pregnant (true/false): ");
        boolean pregnant = scanner.nextBoolean();
        System.out.print("Disabled (true/false): ");
        boolean disabled = scanner.nextBoolean();

        System.out.println("Passenger was successfully added");

        passengerRailroadCar.addCargo(new Passenger(name, pregnant, disabled));
    }

    private void createHeavyMaterialsCargo(HeavyRailroadCar heavyRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Material: ");
        String material = scanner.next();
        System.out.print("Material in boxes (true/false): ");
        boolean boxes = scanner.nextBoolean();

        System.out.println("Heavy materials were successfully added");

        heavyRailroadCar.addCargo(new HeavyMaterials(weight, material, boxes));
    }

    private void createAtomicBombCargo(ExplosiveRailroadCar explosiveRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name: ");
        String material = scanner.next();
        System.out.print("Material in boxes (true/false): ");
        boolean boxes = scanner.nextBoolean();
        System.out.print("Level of explosiveness (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Atomic bomb was successfully added");

        explosiveRailroadCar.addCargo(new AtomicBomb(weight, material, boxes, level));
    }

    private void createToxicLiquidCargo(LiquidToxicMaterialsRailroadCar liquidToxicMaterialsRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name: ");
        String material = scanner.next();
        System.out.print("Material in boxes (true/false): ");
        boolean boxes = scanner.nextBoolean();
        System.out.print("Level of toxicity (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Toxic liquid was successfully added");

        liquidToxicMaterialsRailroadCar.addCargo(new ToxicLiquid(weight, material, boxes, level));
    }

    private void createToxicMaterialsCargo(ToxicMaterialsRailroadCar toxicMaterialsRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name: ");
        String material = scanner.next();
        System.out.print("Material in boxes (true/false): ");
        boolean boxes = scanner.nextBoolean();
        System.out.print("Level of toxicity (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Toxic materials was successfully added");

        toxicMaterialsRailroadCar.addCargo(new ToxicMaterials(weight, material, boxes, level));
    }

    private void createBasicMaterialsCargo(BasicRailroadCar basicRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name of cargo: ");
        String material = scanner.next();

        System.out.println("Basic materials were successfully added");

        basicRailroadCar.addCargo(new BasicMaterials(weight, material));
    }

    private void createGasCargo(GasRailroadCar gasRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name of cargo: ");
        String material = scanner.next();
        System.out.print("Level of explosiveness (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Gas was successfully added");

        gasRailroadCar.addCargo(new Gas(weight, material, level));
    }

    private void createLiquidCargo(LiquidRailroadCar liquidRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name of cargo: ");
        String material = scanner.next();
        System.out.print("Density of liquid (from 1 to 10): ");
        int level = scanner.nextInt();

        System.out.println("Liquid was successfully added");

        liquidRailroadCar.addCargo(new Liquid(weight, material, level));
    }

    private void createMeatCargo(RefrigeratorRailroadCar refrigeratorRailroadCar) {
        System.out.print("Weight (in kg): ");
        int weight = scanner.nextInt();
        System.out.print("Name of cargo: ");
        String material = scanner.next();
        System.out.print("Temperature of storing meat (in degrees): ");
        int level = scanner.nextInt();

        System.out.println("Meat was successfully added");

        refrigeratorRailroadCar.addCargo(new Meat(weight, material, level));
    }

    @Override
    public void removeCargo() {
        Locomotive locomotive = getLocomotiveFromConsoleByName("Choose locomotive: ");

        System.out.println("List of railroad cars attached to locomotive " + locomotive.getNAme() + ":");
        for (RailroadCar railroadCar: locomotive.getRailroadCars()) {
            System.out.println(railroadCar.getName());
        }

        System.out.print("Choose from which railroad car cargo will be removed: ");
        String inputCar = scanner.next();
        RailroadCar car = null;

        for (RailroadCar railroadCar : locomotive.getRailroadCars()) {
            if (railroadCar.getName().equals(inputCar)) {
                car = railroadCar;
                break;
            }
        }
        if (car == null) {
            System.out.println("Incorrect input data. Try again");
            menu();
        }

        List cargo = car.getCargo();
        if (cargo.isEmpty()) {
            System.out.println("This railroad car doesn't have any cargo");
            menu();
        }

        // it's better to use hash map for deleting objects because we may have many elements of cargo with the same name
        // (that's why deletion is implemented by indexes)
        Map<Integer, Object> cargoMap = new HashMap<>();

        System.out.println("List of cargo: ");
        for (int i = 0; i < cargo.size(); i++) {
            cargoMap.put(i, cargo.get(i));
            System.out.println("Index for deletion " + i + ", cargo:\n" + cargo.get(i));
        }

        System.out.print("Write index of cargo which must be deleted: ");
        int index = scanner.nextInt();

        if (! cargoMap.containsKey(index)) {
            System.out.println("Incorrect input data. Try again");
            menu();
        }

        switch (car.getClass().toString()) {
            case "class model.railroadCars.BaggageRailroadCar":
                BaggageRailroadCar baggageRailroadCar = (BaggageRailroadCar) car;
                baggageRailroadCar.removeCargo((Baggage) cargoMap.get(index));
                break;
            case "class model.railroadCars.PassengerRailroadCar":
                PassengerRailroadCar passengerRailroadCar = (PassengerRailroadCar) car;
                passengerRailroadCar.removeCargo((Passenger) cargoMap.get(index));
                break;
            case "class model.railroadCars.PostOfficeRailroadCar":
                PostOfficeRailroadCar postOfficeRailroadCar = (PostOfficeRailroadCar) car;
                postOfficeRailroadCar.removeCargo((Parcel) cargoMap.get(index));
                break;
            case "class model.railroadCars.RestaurantRailroadCar":
                RestaurantRailroadCar restaurantRailroadCar = (RestaurantRailroadCar) car;
                restaurantRailroadCar.removeCargo((Dish) cargoMap.get(index));
                break;
            case "class model.railroadCars.HeavyRailroadCar":
                HeavyRailroadCar heavyRailroadCar = (HeavyRailroadCar) car;
                heavyRailroadCar.removeCargo((HeavyMaterials) cargoMap.get(index));
                break;
            case "class model.railroadCars.ExplosiveRailroadCar":
                ExplosiveRailroadCar explosiveRailroadCar = (ExplosiveRailroadCar) car;
                explosiveRailroadCar.removeCargo((AtomicBomb) cargoMap.get(index));
                break;
            case "class model.railroadCars.LiquidToxicMaterialsRailroadCar":
                LiquidToxicMaterialsRailroadCar liquidToxicMaterialsRailroadCar = (LiquidToxicMaterialsRailroadCar) car;
                liquidToxicMaterialsRailroadCar.removeCargo((ToxicLiquid) cargoMap.get(index));
                break;
            case "class model.railroadCars.ToxicMaterialsRailroadCar":
                ToxicMaterialsRailroadCar toxicMaterialsRailroadCar = (ToxicMaterialsRailroadCar) car;
                toxicMaterialsRailroadCar.removeCargo((ToxicMaterials) cargoMap.get(index));
                break;
            case "class model.railroadCars.GasRailroadCar":
                GasRailroadCar gasRailroadCar = (GasRailroadCar) car;
                gasRailroadCar.removeCargo((Gas) cargoMap.get(index));
                break;
            case "class model.railroadCars.LiquidRailroadCar":
                LiquidRailroadCar liquidRailroadCar = (LiquidRailroadCar) car;
                liquidRailroadCar.removeCargo((Liquid) cargoMap.get(index));
                break;
            case "class model.railroadCars.RefrigeratorRailroadCar":
                RefrigeratorRailroadCar refrigeratorRailroadCar = (RefrigeratorRailroadCar) car;
                refrigeratorRailroadCar.removeCargo((Meat) cargoMap.get(index));
                break;
        }

        System.out.println("Cargo was deleted successfully");
        menu();
    }

    @Override
    public void createStation() {
        System.out.println("List of existing stations: ");
        printAllStations();

        System.out.print("Write name of station which must be added: ");
        String station = scanner.next();
        GraphGenerator.getGraph().addNode(station);
        menu();
    }

    @Override
    public void removeStation() {
        System.out.println("List of existing stations: ");
        printAllStations();

        System.out.print("Write name of station which must be removed: ");
        String station = scanner.next();
        Node node = GraphGenerator.getGraph().removeNode(station);

        if (node == null) {
            System.out.println("Incorrect input data. Try again");
        } else {
            System.out.println("Station " + station + " was removed successfully");
        }
        menu();
    }

    @Override
    public void createRailroad() {
        System.out.println("List of existing railroads: ");
        printAllRailroads();

        System.out.print("Write departure station: ");
        String dep = scanner.next();
        System.out.print("Write destination station: ");
        String des = scanner.next();
        System.out.print("Distance between stations (in km): ");
        int distance = scanner.nextInt();

        Node departure = GraphGenerator.getGraph().getNodeByName(dep);
        Node destination = GraphGenerator.getGraph().getNodeByName(des);

        GraphGenerator.getGraph().addEdge(departure, destination, distance);
        menu();
    }

    @Override
    public void removeRailroad() {
        System.out.println("List of existing railroads: ");
        printAllRailroads();

        System.out.print("Write departure station: ");
        String dep = scanner.next();
        System.out.print("Write destination station: ");
        String des = scanner.next();

        Node departure = GraphGenerator.getGraph().getNodeByName(dep);
        Node destination = GraphGenerator.getGraph().getNodeByName(des);
        Edge removedEdge = null;

        for (Edge edge: GraphGenerator.getGraph().getEdgeMap().get(departure)) {
            if (edge.getDestination().equals(destination)) {
                removedEdge = GraphGenerator.getGraph().removeEdge(edge);
                break;
            }
        }
        if (removedEdge == null) {
            System.out.println("Incorrect input data. Try again");
        } else {
            System.out.println("Railroad was removed successfully");
        }
        menu();
    }

    @Override
    public void exitProgram() {
        // zero means normal exit
        System.exit(0);
    }

    private void printAllStations() {
        Set<String> stations = GraphGenerator.getGraph().getNamesOfStations();

        for (String station: stations)
            System.out.println(station);
    }

    private void printAllRailroads() {
        Map<Node, List<Edge>> edgeMap = GraphGenerator.getGraph().getEdgeMap();

        for (List<Edge> edges: edgeMap.values()) {
            for (Edge edge: edges) {
                System.out.println("Departure station: " + edge.getSource().getName() + ", destination station: " + edge.getDestination().getName() + ", distance: " + edge.getWeight() + "km");
            }
            System.out.println();
        }
    }
}

