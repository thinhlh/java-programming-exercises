package models;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidFieldException;
import safety.ValidatedDouble;
import safety.ValidatedInteger;
import safety.ValidatedModel;

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
                System.out.print("Nhap so cho ngoi: ");
                this.numSeats = new ValidatedInteger.Builder()
                        .setLowerBound(0)
                        .build(scanner)
                        .getValue();

                break;
            } catch (InvalidFieldException e) {
                System.out.println("So cho ngoi phai lon hon 0");
            } catch (Exception e) {
                System.out.println("So cho ngoi phai la so nguyen duong");
            }

        } while (true);

        do {
            try {
                System.out.print("Nhap so cua: ");
                this.numDoors = new ValidatedInteger.Builder()
                        .setLowerBound(0)
                        .build(scanner)
                        .getValue();

                break;
            } catch (InvalidFieldException e) {
                System.out.println("So cua phai lon hon 0");
            } catch (Exception e) {
                System.out.println("So cua phai la so nguyen duong");
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
            System.out.println("So mile phai la so nguyen duong");
            e.printStackTrace();
        }
        this.plateNumber = properties.get(7);
        try {
            this.numSeats = new ValidatedInteger.Builder()
                    .setLowerBound(0)
                    .build(Integer.parseInt(properties.get(8)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("So cho ngoi phai la so nguyen duong");
            e.printStackTrace();
        }
        try {
            this.numDoors = new ValidatedInteger.Builder()
                    .setLowerBound(0)
                    .build(Integer.parseInt(properties.get(9)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("So cua phai la so nguyen duong");
            e.printStackTrace();
        }

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
