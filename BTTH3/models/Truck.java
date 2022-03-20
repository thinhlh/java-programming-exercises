package models;

import java.util.Scanner;

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

    /**
     * Using polymorphism that this method will be executed when creating Truck
     * object and call turn
     */
    @Override
    public void turn() {
        System.out.println("Truck turns");
    }

    @Override
    protected Vehicle input() {
        Scanner scanner = new Scanner(System.in);
        Truck truck = (Truck) super.input();

        do {
            System.out.print("Nhap so mile da di chuyen: ");
            truck.mileage = scanner.nextDouble();
        } while (truck.mileage < 0);
        scanner.nextLine();

        do {
            System.out.print("Nhap bien so xe: ");
            truck.plateNumber = scanner.nextLine();
        } while (truck.plateNumber.length() <= 0);

        do {
            System.out.print("Nhap trong luong khoi hang: ");
            truck.loadCapacity = scanner.nextDouble();
        } while (truck.loadCapacity < 0);

        return truck;
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
