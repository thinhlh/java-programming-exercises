package models;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidFieldException;
import safety.ValidatedDouble;
import safety.ValidatedInteger;
import safety.ValidatedModel;

/**
 * The base class for vehicles
 * 
 * There are 4 extended vehicles namely
 * 
 * @class Bicycle
 * @class Car
 * @class Bike
 * @class Truck
 */

abstract class Vehicle {
    protected ValidatedModel model;
    protected String color;
    protected int year;
    protected int numWheels;
    protected Double price;
    protected double weight;

    /**
     * Calling input function when started
     */
    protected Vehicle() {
        inputFromScanner();
    }

    /**
     * This will instantiate the vehicle from it's input string
     * 
     * Every element in the property string will have this pattern [property]
     * 
     * @param propertiesString
     */
    protected Vehicle(ArrayList<String> propertiesString) {
        inputFromProperties(propertiesString);
    }

    public abstract void turn();

    public abstract Double getMileage();

    /**
     * This base input for all vehicles using scanner object
     * 
     * @return Vehicle
     */
    protected Vehicle inputFromScanner() {
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Nhap ten model cua xe: ");
                this.model = new ValidatedModel(scanner.nextLine());

                if (!this.model.isValid())
                    throw new InvalidFieldException("Ten model khong hop le");

                break;
            } catch (InvalidFieldException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        System.out.print("Nhap mau cua xe: ");
        this.color = scanner.nextLine();

        System.out.print("Nhap nam san xuat: ");

        do {
            try {
                this.year = new ValidatedInteger.Builder()
                        .setLowerBound(1990)
                        .setUpperBound(Year.now().getValue())
                        .build(scanner)
                        .getValue();
                break;
            } catch (InvalidFieldException e) {
                System.out.println("Nam san xuat phai lon hon 1990 va nho hon nam hien tai.");
            } catch (Exception e) {
                System.out.println("Nam san xuat phai la so nguyen duong");
            }
        } while (true);

        do {
            try {
                this.numWheels = new ValidatedInteger.Builder()
                        .setLowerBound(1)
                        .build(scanner)
                        .getValue();
                break;
            } catch (InvalidFieldException e) {
                System.out.println("So banh xe phai lon hon 0");
            } catch (Exception e) {
                System.out.println("So banh xe phai la so nguyen duong");
            }
        } while (true);

        do {
            try {
                System.out.print("Nhap gia thanh cua xe: ");
                this.price = new ValidatedDouble.Builder()
                        .setLowerBound(0.0)
                        .build(scanner)
                        .getValue();
                break;
            } catch (InvalidFieldException e) {
                System.out.println("Gia thanh phai lon hon hoac bang 0");
            } catch (Exception e) {
                System.out.println("Gia thanh phai la so nguyen duong");
            }

        } while (true);

        do {
            try {
                System.out.print("Nhap trong luong xe: ");
                this.weight = new ValidatedInteger.Builder()
                        .setLowerBound(0)
                        .build(scanner)
                        .getValue();
                break;
            } catch (InvalidFieldException e) {
                System.out.println("Trong luong phai lon hon 0");
            } catch (Exception e) {
                System.out.println("Trong luong phai la so nguyen duong");
            }

        } while (true);

        return this;
    }

    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        this.model = new ValidatedModel(properties.get(0));
        this.color = properties.get(1);
        try {
            this.year = new ValidatedInteger.Builder()
                    .setLowerBound(0)
                    .setUpperBound(Year.now().getValue())
                    .build(Integer.parseInt(properties.get(2)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("Nam san xuat phai lon hon 1990 va nho hon nam hien tai.");
        }
        try {
            this.numWheels = new ValidatedInteger.Builder()
                    .setLowerBound(0)
                    .build(Integer.parseInt(properties.get(3)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("So banh xe phai la so nguyen duong");
            e.printStackTrace();
        }
        try {
            this.price = new ValidatedDouble.Builder()
                    .setLowerBound(0.0)
                    .build(Double.parseDouble(properties.get(4)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("Gia thanh phai la so nguyen duong");
        }
        try {
            this.weight = new ValidatedDouble.Builder()
                    .setLowerBound(0.0)
                    .build(Double.parseDouble(properties.get(5)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("Trong luong phai la so nguyen duong");
        }
        return this;
    }

    @Override
    public String toString() {
        return "ten cua xe= " + model.toString()
                + ", mau cua xe= " + color
                + ", nam san xuat= " + year
                + ", so banh xe= " + numWheels
                + ", gia thanh cua xe= " + price
                + ", trong luong cua xe= " + weight;
    }

    /**
     * Getters & Setters
     */

    public ValidatedModel getModel() {
        return model;
    }

    public void setModel(ValidatedModel model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumWheels() {
        return numWheels;
    }

    public void setNumWheels(int numWheels) {
        this.numWheels = numWheels;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean newlyManufactored() {
        return Math.abs(Double.valueOf(this.year - Year.now().getValue())) <= 3.0;
    }

}