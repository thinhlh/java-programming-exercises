package models;

import java.util.Scanner;

/**
 * The bicycle object, which extends Vehicle
 * 
 * This object has a new field named
 * 
 * @param saddleSeatHeight
 */

class Bicycle extends Vehicle {
    private double saddleSeatHeight;

    /**
     * Using polymorphism that this method will be executed when creating Bicycle
     * object and call turn
     */
    @Override
    public void turn() {
        System.out.println("Bicycle turns");
    }

    @Override
    protected Vehicle input() {
        Scanner scanner = new Scanner(System.in);
        Bicycle bicycle = (Bicycle) super.input();

        do {
            System.out.print("Nhap chieu cao yen xe: ");
            bicycle.saddleSeatHeight = scanner.nextDouble();
        } while (bicycle.saddleSeatHeight <= 0);

        return bicycle;
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
