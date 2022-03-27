package models;

import java.util.ArrayList;
import java.util.Scanner;

import helper.StringHelper;

/**
 * The Truck object, which extends Vehicle
 * 
 * There are 4 new fields named
 * 
 * @property mileage
 * @property plateNumber
 * @property loadCapacity
 */
class Truck extends Vehicle {
    private double mileage;
    private String plateNumber;
    private double loadCapacity;

    Truck() {
        super();
    }

    Truck(ArrayList<String> propertiesString) {
        super(propertiesString);
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
            System.out.print("Nhap so mile da di chuyen: ");
            this.mileage = scanner.nextDouble();
        } while (this.mileage < 0);
        scanner.nextLine();

        do {
            System.out.print("Nhap bien so xe: ");
            this.plateNumber = scanner.nextLine();
        } while (this.plateNumber.length() <= 0);

        do {
            System.out.print("Nhap trong luong khoi hang: ");
            this.loadCapacity = scanner.nextDouble();
        } while (this.loadCapacity < 0);

        return this;
    }

    @Override
    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        super.inputFromProperties(properties);
        this.mileage = Double.parseDouble(properties.get(6));
        this.plateNumber = properties.get(7);
        this.loadCapacity = Double.parseDouble(properties.get(8));
        return this;
    }

    @Override
    public String toString() {
        return "Xe tai: " +
                ", " + super.toString()
                + ", so mile da di chuyen= " + mileage
                + ", bien so xe= " + plateNumber
                + ", trong luong hang hoa= " + loadCapacity;
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
}
