package models;

import java.time.Year;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import helper.StringHelper;
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
    protected double price;
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
            System.out.print("Nhap ten model cua xe: ");
            this.model = new ValidatedModel(scanner.nextLine());
        } while (!this.model.isValid());

        System.out.print("Nhap mau cua xe: ");
        this.color = scanner.nextLine();

        do {
            System.out.print("Nhap nam san xuat: ");
            this.year = scanner.nextInt();
        } while (this.year < 1990 || this.year > Year.now().getValue());

        do {
            System.out.print("Nhap so banh xe: ");
            this.numWheels = scanner.nextInt();
        } while (this.numWheels <= 0);

        do {
            System.out.print("Nhap gia thanh cua xe: ");
            this.price = scanner.nextDouble();
        } while (this.price < 0);

        do {
            System.out.print("Nhap trong luong xe: ");
            this.weight = scanner.nextInt();
        } while (this.weight < 0);

        return this;
    }

    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        this.model = new ValidatedModel(properties.get(0));
        this.color = properties.get(1);
        this.year = Integer.parseInt(properties.get(2));
        this.numWheels = Integer.parseInt(properties.get(3));
        this.price = Double.parseDouble(properties.get(4));
        this.weight = Double.parseDouble(properties.get(5));
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