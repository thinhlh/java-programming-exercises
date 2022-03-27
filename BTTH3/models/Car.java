package models;

import java.util.ArrayList;
import java.util.Scanner;

import helper.StringHelper;

/**
 * The Car object, which extends Vehicle
 * 
 * There are 4 new fields named
 * 
 * @property mileage
 * @property plateNumber
 * @property numSeats
 * @property numDoors
 */

class Car extends Vehicle {
    private double mileage;
    private String plateNumber;
    private int numSeats;
    private int numDoors;

    Car() {
        super();
    }

    Car(ArrayList<String> propertiesString) {
        super(propertiesString);
    }

    /**
     * Using polymorphism that this method will be executed when creating Car object
     * and call turn
     */
    @Override
    public void turn() {
        System.out.println("Car turns");
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
            System.out.print("Nhap so cho ngoi: ");
            this.numSeats = scanner.nextInt();
        } while (this.numSeats <= 0);

        do {
            System.out.print("Nhap so cua: ");
            this.numDoors = scanner.nextInt();
        } while (this.numDoors <= 0);

        return this;
    }

    @Override
    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        super.inputFromProperties(properties);

        this.mileage = Double.parseDouble(properties.get(6));
        this.plateNumber = properties.get(7);
        this.numSeats = Integer.parseInt(properties.get(8));
        this.numDoors = Integer.parseInt(properties.get(9));

        return this;
    }

    @Override
    public String toString() {
        return "Xe hoi: " +
                ", " + super.toString()
                + ", so mile da di chuyen= " + mileage
                + ", bien so xe= " + plateNumber
                + ", so cho ngoi= " + numSeats
                + ", so cua= " + numDoors;

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

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
}
