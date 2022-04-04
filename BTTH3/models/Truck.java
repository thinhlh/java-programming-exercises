package models;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidFieldException;
import models.devices.DVDPlayer;
import models.devices.Device;
import models.devices.LCDTelevision;
import safety.ValidatedDouble;

/**
 * The Truck object, which extends Vehicle
 * 
 * There are 4 new fields named
 * 
 * @property mileage
 * @property plateNumber
 * @property loadCapacity
 */
class Truck extends Vehicle implements IVehicleControllable, IInstallable {
    private double mileage;
    private String plateNumber;
    private double loadCapacity;

    private Device television;
    private Device player;

    Truck() {
        super();
        try {
            television = new LCDTelevision("TruckLCD");
            player = new DVDPlayer("TruckDVD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Truck(ArrayList<String> propertiesString) {
        super(propertiesString);
        try {
            television = new LCDTelevision("TruckLCD");
            player = new DVDPlayer("TruckDVD");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Using polymorphism that this method will be executed when creating Truck
     * object and call turn
     */
    @Override
    public void turn() {
        System.out.println("Truck turns");
    }

    @Override
    protected Vehicle inputFromScanner() {
        Scanner scanner = new Scanner(System.in);
        super.inputFromScanner();

        do {
            try {
                System.out.print("Nhap so mile da di chuyen: ");
                this.mileage = new ValidatedDouble.Builder()
                        .setLowerBound(0.0)
                        .build(scanner)
                        .getValue();

                break;
            } catch (InvalidFieldException e) {
                System.out.println("So mile phai lon hon 0");
            } catch (Exception e) {
                System.out.println("So mile phai la so nguyen duong");
            }
        } while (true);
        scanner.nextLine();

        do {
            try {
                System.out.print("Nhap bien so xe: ");
                this.plateNumber = scanner.nextLine();

                if (this.plateNumber.length() <= 0)
                    throw new InvalidFieldException("Bien so xe phai toi thieu 1 ki tu");
                break;
            } catch (InvalidFieldException e) {
                System.out.println("Bien so xe phai co toi thieu 1 ki tu");
            }
        } while (true);

        do {
            try {
                System.out.print("Nhap trong luong khoi hang: ");
                this.loadCapacity = new ValidatedDouble.Builder()
                        .setLowerBound(0.0)
                        .build(scanner)
                        .getValue();
                break;
            } catch (InvalidFieldException e) {
                System.out.println("Trong luong phai lon hon 0");
            } catch (Exception e) {
                System.out.println("Trong luong khoi hang phai la so nguyen duong");
            }

        } while (true);

        return this;
    }

    @Override
    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        super.inputFromProperties(properties);
        try {
            this.mileage = new ValidatedDouble.Builder()
                    .setLowerBound(0.0)
                    .build(Double.parseDouble(properties.get(6)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("So mile phai lon hon 0");
            e.printStackTrace();
        }
        this.plateNumber = properties.get(7);
        try {
            this.loadCapacity = new ValidatedDouble.Builder()
                    .setLowerBound(0.0)
                    .build(Double.parseDouble(properties.get(8)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("Trong luong phai lon hon 0");
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public String toString() {
        return "Xe tai: " +
                ", " + super.toString()
                + ", so mile da di chuyen= " + mileage
                + ", bien so xe= " + plateNumber
                + ", trong luong hang hoa= " + loadCapacity
                + ", so tien tra sau= " + this.getPayOff();
    }

    /**
     * Display the transport information
     * 
     * @param goodType
     * @param load
     */
    public void transportGoods(String goodType, double load) {
        System.out.println(
                "Good type= " + goodType +
                        ", load= " + load);
    }

    /**
     * Getters & Setters
     */
    @Override
    public Double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void start() {
        System.out.println("Truck starts");
        television.turnOn();
        player.turnOn();
    }

    @Override
    public void stop() {
        System.out.println("Truck stops");
        television.turnOff();
        player.turnOff();
    }

    @Override
    public double getPayOff() {
        var payOffPercentage = (loadCapacity <= 5) ? 50.0 / 100 : 40.0 / 100;
        return this.price * payOffPercentage;
    }
}
