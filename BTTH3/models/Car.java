package models;

import java.util.Scanner;

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

    /**
     * Using polymorphism that this method will be executed when creating Car object
     * and call turn
     */
    @Override
    public void turn() {
        System.out.println("Car turns");
    }

    @Override
    protected Vehicle input() {
        Scanner scanner = new Scanner(System.in);
        Car car = (Car) super.input();

        do {
            System.out.print("Nhap so mile da di chuyen: ");
            car.mileage = scanner.nextDouble();
        } while (car.mileage < 0);
        scanner.nextLine();

        do {
            System.out.print("Nhap bien so xe: ");
            car.plateNumber = scanner.nextLine();
        } while (car.plateNumber.length() <= 0);

        do {
            System.out.print("Nhap so cho ngoi: ");
            car.numSeats = scanner.nextInt();
        } while (car.numSeats <= 0);

        do {
            System.out.print("Nhap so cua: ");
            car.numDoors = scanner.nextInt();
        } while (car.numDoors <= 0);

        return car;
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
