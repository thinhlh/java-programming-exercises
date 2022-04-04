package models;

import java.util.Scanner;

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

    @Override
    public Vehicle input() {
        Scanner scanner = new Scanner(System.in);
        Bike bike = (Bike) super.input();

        do {
            System.out.print("Nhap so mile da di chuyen: ");
            bike.mileage = scanner.nextDouble();
        } while (bike.mileage < 0);
        scanner.nextLine();

        do {
            System.out.print("Nhap bien so xe: ");
            bike.plateNumber = scanner.nextLine();
        } while (bike.plateNumber.length() <= 0);

        do {
            System.out.print("Nhap so cho ngoi: ");
            bike.numSeats = scanner.nextInt();
        } while (bike.numSeats <= 0);

        return bike;
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
