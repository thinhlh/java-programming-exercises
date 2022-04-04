package models;

import java.util.ArrayList;
import java.util.Scanner;

import exceptions.InvalidFieldException;
import safety.ValidatedDouble;

/**
 * The bicycle object, which extends Vehicle
 * 
 * This object has a new field named
 * 
 * @param saddleSeatHeight
 */

class Bicycle extends Vehicle {
    private double saddleSeatHeight;

    Bicycle() {
        super();
    }

    Bicycle(ArrayList<String> propertiesString) {
        super(propertiesString);
    }

    /**
     * Using polymorphism that this method will be executed when creating Bicycle
     * object and call turn
     */
    @Override
    public void turn() {
        System.out.println("Bicycle turns");
    }

    @Override
    protected Vehicle inputFromScanner() {
        Scanner scanner = new Scanner(System.in);
        super.inputFromScanner();

        do {
            try {
                System.out.print("Nhap chieu cao yen xe: ");
                this.saddleSeatHeight = new ValidatedDouble.Builder()
                        .setLowerBound(0.0)
                        .build(scanner)
                        .getValue();
                break;
            } catch (InvalidFieldException e) {
                System.out.println("Chieu cao yen xe phai lon hon 0");
            } catch (Exception e) {
                System.out.println("Chieu cao yen xe phai la so nguyen duong");
            }
        } while (true);

        return this;
    }

    @Override
    protected Vehicle inputFromProperties(ArrayList<String> properties) {
        super.inputFromProperties(properties);

        try {
            this.saddleSeatHeight = new ValidatedDouble.Builder()
                    .setLowerBound(0.0)
                    .build(Double.parseDouble(properties.get(6)))
                    .getValue();
        } catch (NumberFormatException | InvalidFieldException e) {
            System.out.println("Chieu cao yen xe phai la so nguyen duong");
        }

        return this;
    }

    @Override
    public String toString() {
        return "Xe dap: " +
                super.toString() +
                ", chieu cao yen xe= " + saddleSeatHeight;
    }

    @Override
    public Double getMileage() {
        return null;
    }

    /**
     * Getter & Setters
     */
    public void setSaddleSeatHeight(double saddleSeatHeight) {
        this.saddleSeatHeight = saddleSeatHeight;
    }

    public double getSaddleSeatHeight() {
        return saddleSeatHeight;
    }
}
