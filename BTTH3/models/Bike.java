package models;

import java.util.ArrayList;
import java.util.Scanner;

import helper.StringHelper;

/**
 * The Bike object, which extends Vehicle
 * 
 * This object has a new field named
 * 
 * @property mileage
 * @property plateNumber
 * @property numSeats
 */

class Bike extends Vehicle {
    private double mileage;
    private String plateNumber;
    private int numSeats;

    Bike() {
        super();
    }

    Bike(ArrayList<String> propertiesString) {
        super(propertiesString);
    }

    @Override
    public Vehicle inputFromScanner() {
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
            System.out.print("Nhap so cho ngoi: ");
            this.numSeats = scanner.nextInt();
        } while (this.numSeats <= 0);

        return this;
    }

    @Override
    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        super.inputFromProperties(properties);

        this.mileage = Double.parseDouble(properties.get(6));
        this.plateNumber = properties.get(7);
        this.numSeats = Integer.parseInt(properties.get(8));

        return this;
    }

    @Override
    public String toString() {
        return "Xe may: " +
                ", " + super.toString()
                + ", so mile da di chuyen= " + mileage
                + ", bien so xe= " + plateNumber
                + ", so cho ngoi= " + numSeats;
    }

    /**
     * Using polymorphism that this method will be executed when creating Bike
     * object and call turn
     */
    @Override
    public void turn() {
        System.out.println("Bike turns");
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

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
}
